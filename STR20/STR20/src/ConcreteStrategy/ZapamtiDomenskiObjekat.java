/* ZapamtiDomenskiObjekat.java
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

 public class ZapamtiDomenskiObjekat implements  SistemskaOperacija{ // Receiver
    
    BrokerBazePodataka bbp;
    Kontroler kon;
    
    
    public ZapamtiDomenskiObjekat(BrokerBazePodataka bbp1,Kontroler kon1){bbp=bbp1;kon=kon1;} 
     
    public boolean izvrsiSO(){
    kon.napuniDomenskiObjekatIzGrafickogObjekta();
    bbp.makeConnection();
    boolean signal = bbp.insertRecord(kon.getDomenskiObjekat());
    if (signal==true) 
        { bbp.commitTransation();
          kon.setPoruka("Sistem je zapamtio rezervaciju."); // Promenljivo!!!
        }
        else
        { bbp.rollbackTransation();
          kon.isprazniGrafickiObjekat();
          kon.setPoruka("Sistem ne moze da zapamti rezervaciju."); // Promenljivo!!!
        }
    kon.prikaziPoruku();
    bbp.closeConnection();
    return signal;   
}
    
}
