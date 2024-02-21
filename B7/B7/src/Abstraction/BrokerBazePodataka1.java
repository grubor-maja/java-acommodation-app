/* BrokerBazePodataka1.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 06.11.2017
 */

package Abstraction;


import java.sql.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import Implementor.GeneralDObject;



public class BrokerBazePodataka1 extends BrokerBazePodataka // Abstraction
{
   Connection conn = null;
   
   // Promenljivo!!! 
   @Override
    public boolean makeConnection() 
    {
        String Url;
        try {
             
             Url = vratiURL();
             conn = DriverManager.getConnection(Url,vratiKorisnickoIme(),vratiSifru());
             conn.setAutoCommit(false); // Ako se ovo ne uradi nece moci da se radi roolback.
            } catch (SQLException ex) {
            Logger.getLogger(BrokerBazePodataka1.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
  
  
    @Override
    public boolean insertRecord(GeneralDObject odo)
    {  
       String upit = "INSERT INTO " + odo.getClassName() +  " VALUES (" + odo.getAtrValue() + ")";
       return executeUpdate(upit,odo,"insertRecord");
    }


   
    @Override
    public boolean getCounter(GeneralDObject odo,AtomicInteger counter) 
    {  
        String sql = "SELECT Counter FROM Counter WHERE TableName = '" + odo.getClassName() + "'";
       
        ResultSet rs = null;
        Statement st = null;
               
        boolean signal = false; // record doesn't exist
        try  { st  = conn.prepareStatement(sql);
               rs = st.executeQuery(sql);
               signal = rs.next(); 
               counter.set(rs.getInt("Counter") + 1);
	     } catch (SQLException  ex)  
                { Logger.getLogger(BrokerBazePodataka1.class.getName()).log(Level.SEVERE, null, ex);
                  signal = false;
                } 
               finally {close(null,st,rs);}
        return signal;
       
    }
  
    @Override
    public boolean increaseCounter(GeneralDObject odo,AtomicInteger counter) 
    {   String  upit = "UPDATE Counter SET Counter =" + counter.get() + " WHERE TableName = '" + odo.getClassName() + "'";
       return executeUpdate(upit,odo,"increaseCounter");
    }
  
    @Override
    public boolean deleteRecord(GeneralDObject odo) 
    {   String upit ="DELETE FROM " + odo.getClassName() + " WHERE " + odo.getWhereCondition();
        return executeUpdate(upit,odo,"deleteRecord");
    }

    @Override
    public boolean updateRecord(GeneralDObject odo,GeneralDObject odoold) 
    {   String  upit = "UPDATE " + odo.getClassName() +  " SET " + odo.setAtrValue() +   " WHERE " + odoold.getWhereCondition();
        return executeUpdate(upit,odo,"updateRecord");       
    }

    @Override
    public boolean updateRecord(GeneralDObject odo) 
    {   String  upit = "UPDATE " + odo.getClassName() +  " SET " + odo.setAtrValue() +   " WHERE " + odo.getWhereCondition();
        return executeUpdate(upit,odo,"updateRecord");       
    }
     
    public boolean executeUpdate(String upit,GeneralDObject odo, String operacija) 
    {   Statement st=null;
        boolean signal = false;
  	try {   st  = conn.prepareStatement(upit);
                int rowcount = st.executeUpdate(upit);
                if (rowcount > 0) 
                    signal = true;    
	    } catch (SQLException ex)  
                {   Logger.getLogger(BrokerBazePodataka1.class.getName()).log(Level.SEVERE, null, ex);
                    signal = false;
                } finally {close(null,st,null);}
        System.out.println("Izvrsena je operacija:" + operacija + " nad tabelom:" + odo.getClassName() + " koja se nalazi u:" + vratiDBMS());
	return signal;
    }
   
    @Override
    public GeneralDObject findRecord(GeneralDObject odo) 
    {   ResultSet rs = null;
        Statement st = null;
        String  upit = "SELECT * FROM " + odo.getClassName() +  " WHERE " + odo.getWhereCondition();
        boolean signal; 
  	try {   st  = conn.prepareStatement(upit);
                rs = st.executeQuery(upit);
                signal = rs.next(); // rs.next() vraca true ako ima postoji rezultat upita.
                if (signal == true)
                    odo = odo.getNewRecord(rs);
                else
                    odo = null;
	    } catch (SQLException  ex)  
               {   Logger.getLogger(BrokerBazePodataka1.class.getName()).log(Level.SEVERE, null, ex);
               } finally {close(null,st,rs);}
	return odo;
    }
    
    @Override
    public boolean commitTransation()
    {   try { conn.commit();
	    } catch(SQLException esql){ return false; }
	return true;
    }

	
   @Override
    public boolean rollbackTransation()
    {   try { conn.rollback();
	    } catch(SQLException esql){ return false;  }
		   
	return true;
    }
        
    @Override
    public void closeConnection() 
    { close(conn,null,null);
    }
        
    public void close(Connection conn, Statement st, ResultSet rs) 
    { if (rs != null) 
        {  try { rs.close(); 
               } catch (SQLException ex) 
                   { Logger.getLogger(BrokerBazePodataka1.class.getName()).log(Level.SEVERE, null, ex);}
        }
        
      if (st != null) 
        { try { st.close();
              } catch (SQLException ex) 
                  { Logger.getLogger(BrokerBazePodataka1.class.getName()).log(Level.SEVERE, null, ex);}
        }
      if (conn != null) 
        { try { conn.close();
              } catch (SQLException ex) 
                  { Logger.getLogger(BrokerBazePodataka1.class.getName()).log(Level.SEVERE, null, ex);}
        }
    }
    
    protected String vratiDrajver(){return null;}
    protected String vratiURL(){return "jdbc:mysql://127.0.0.1:3306/rezervacija";}
    protected String vratiKorisnickoIme(){return "root";}
    protected String vratiSifru(){return "root";}
    protected String vratiDBMS(){return null;}
}
