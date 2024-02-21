/* PromeniDomenskiObjekat.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 02.12.2017
 */

package ConcreteStrategy;

import AbstractProductB.BrokerBazePodataka;
import AbstractProductC.Kontroler;
import Strategy.SistemskaOperacija;

 public class PromeniDomenskiObjekat implements  SistemskaOperacija{ // Receiver
    
    BrokerBazePodataka bbp;
    Kontroler kon;
    
    
    public PromeniDomenskiObjekat(BrokerBazePodataka bbp1,Kontroler kon1){bbp=bbp1;kon=kon1;} 
     
    public boolean izvrsiSO(){
    kon.napuniDomenskiObjekatIzGrafickogObjekta();
    bbp.makeConnection();
    boolean signal = bbp.updateRecord(kon.getDomenskiObjekat());
    if (signal==true) 
        { bbp.commitTransation();
          kon.setPoruka("Sistem je promenio rezervaciju."); // Promenljivo!!!
        }
        else
        { bbp.rollbackTransation();
          kon.isprazniGrafickiObjekat();
          kon.setPoruka("Sistem ne moze da promeni rezervaciju."); // Promenljivo!!!
        }
    kon.prikaziPoruku();
    bbp.closeConnection();
    return signal;   
}
    
}
