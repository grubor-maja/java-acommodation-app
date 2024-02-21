
package Receiver;

import AbstractProductB.BrokerBazePodataka;
import Client.Kontroler;
import DomainClasses.Rezervacija;
import java.util.concurrent.atomic.AtomicInteger;

 public class KreirajDomenskiObjekat { // Receiver
    
    BrokerBazePodataka bbp;
    Kontroler kon;
     
    public KreirajDomenskiObjekat(BrokerBazePodataka bbp1,Kontroler kon1){bbp=bbp1;kon=kon1;} 
     
    public boolean kreirajDomenskiObjekat(){
    boolean signal;
    Rezervacija r= new Rezervacija(); // Promenljivo!!!
    AtomicInteger counter = new AtomicInteger(0);
    
    bbp.makeConnection();
    if (!bbp.getCounter(r,counter)) return false;
    if (!bbp.increaseCounter(r,counter)) return false;
          
    r.setSifraRezervacije(counter.get()); // Promenljivo!!!
    signal = bbp.insertRecord(r);
    if (signal==true) 
        { bbp.commitTransation();
          kon.napuniGrafickiObjekatIzDomenskogObjekta(r);
          kon.setPoruka("Sistem je kreirao novu rezervaciju."); // Promenljivo!!!
          kon.iteratorPostaviNaZadnji();
        }
        else
        { bbp.rollbackTransation();
        kon.isprazniGrafickiObjekat();
         kon.setPoruka("Sistem ne moze da kreira novu rezervaciju."); // Promenljivo!!!
        }
    kon.prikaziPoruku();
    bbp.closeConnection();
    return signal;
}
    
}
