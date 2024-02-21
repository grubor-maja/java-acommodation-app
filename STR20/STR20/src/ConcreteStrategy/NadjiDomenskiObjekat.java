/* NadjiDomenskiObjekat.java
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
import DomainClasses.Rezervacija;
import Strategy.SistemskaOperacija;

 public class NadjiDomenskiObjekat implements  SistemskaOperacija{ // Receiver
    
    BrokerBazePodataka bbp;
    Kontroler kon;
    
    
    public NadjiDomenskiObjekat(BrokerBazePodataka bbp1,Kontroler kon1){bbp=bbp1;kon=kon1;} 
     
    public boolean izvrsiSO(){
    kon.napuniDomenskiObjekatIzGrafickogObjekta();
     boolean signal;
    bbp.makeConnection();
    Rezervacija r = (Rezervacija)bbp.findRecord(kon.getDomenskiObjekat()); // Promenljivo!!!
    if (r != null) 
        { kon.napuniGrafickiObjekatIzDomenskogObjekta(r);
          kon.setPoruka("Sistem je pronasao rezervaciju."); // Promenljivo!!!
          signal = true;
        }
        else
        { kon.isprazniGrafickiObjekat();
          kon.setPoruka("Sistem ne moze da nadje rezervaciju."); // Promenljivo!!!
          signal = false;
        }
    kon.prikaziPoruku();
    bbp.closeConnection();
    return signal;  
}
    
}
