/* ZapamtiDomenskiObjekat.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 06.11.2017
 */

package ConcreteClass;

import AbstractClass.OpstaDBSO;
import AbstractProductB.BrokerBazePodataka;
import Client.Kontroler;


public class ZapamtiDomenskiObjekat extends OpstaDBSO{ // ConcreteClass

    public ZapamtiDomenskiObjekat(BrokerBazePodataka bbp1,Kontroler kon1) {super(bbp1,kon1);}
    
    
        
    @Override
    public boolean konkretnaDBSO() // insert record
   { return bbp.updateRecord(kon.getDomenskiObjekat());}
    
    @Override
    public void uspesnaDBOperacija()
    { bbp.commitTransation();
      kon.setPoruka("Sistem je zapamtio rezervaciju.");
    }

    @Override
    public void neuspesnaDBOperacija()
     {bbp.rollbackTransation();
      kon.isprazniGrafickiObjekat();
      kon.setPoruka("Sistem ne moze da zapamti rezervaciju.");
     }
  }
