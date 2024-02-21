/* ObrisiDomenskiObjekat.java
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


public class ObrisiDomenskiObjekat implements  SistemskaOperacija{
    BrokerBazePodataka bbp;
    Kontroler kon;
    
    
    public ObrisiDomenskiObjekat(BrokerBazePodataka bbp1,Kontroler kon1){bbp=bbp1;kon=kon1;} 
    
    public boolean izvrsiSO(){
     kon.napuniDomenskiObjekatIzGrafickogObjekta();
     bbp.makeConnection();
     boolean signal = bbp.deleteRecord(kon.getDomenskiObjekat());
     if (signal==true) 
        { bbp.commitTransation();
          kon.setPoruka("Sistem je obrisao rezervaciju."); // Promenljivo!!!
          kon.isprazniGrafickiObjekat();
        }
     else
        { bbp.rollbackTransation();
          kon.setPoruka("Sistem ne moze da obrise rezervaciju."); // Promenljivo!!!
        }
     kon.prikaziPoruku();
    bbp.closeConnection();
    return signal;   
  }   
}
