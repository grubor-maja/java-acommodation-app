/* KreirajDomenskiObjekat.java
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
import java.util.concurrent.atomic.AtomicInteger;

 public class KreirajDomenskiObjekat implements  SistemskaOperacija{ // Receiver
    
    BrokerBazePodataka bbp;
    Kontroler kon;
     
    public KreirajDomenskiObjekat(BrokerBazePodataka bbp1,Kontroler kon1){bbp=bbp1;kon=kon1;} 
     
    @Override
    public boolean izvrsiSO(){
    boolean signal;
        Rezervacija r= new Rezervacija(); // Promenljivo!!!
    AtomicInteger counter = new AtomicInteger(0);
    kon.napuniDomenskiObjekatIzGrafickogObjekta();
    bbp.makeConnection();
    if (!bbp.getCounter(r,counter)) return false;
    if (!bbp.increaseCounter(r,counter)) return false;
          
    kon.r.setSifraRezervacije(counter.get()); // Promenljivo!!!
    signal = bbp.insertRecord(kon.r);
    if (signal==true) 
        { bbp.commitTransation();
          kon.napuniGrafickiObjekatIzDomenskogObjekta(r);
          kon.setPoruka("Sistem je kreirao rezervaciju."); // Promenljivo!!!
        }
        else
        { bbp.rollbackTransation();
        kon.isprazniGrafickiObjekat();
         kon.setPoruka("Sistem ne moze da kreira rezervaciju."); // Promenljivo!!!
        }
    kon.prikaziPoruku();
    bbp.closeConnection();
    return signal;
}
    
}
