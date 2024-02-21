
package Receiver;


import Client.Kontroler;
import DomainClasses.Rezervacija;
import java.util.concurrent.atomic.AtomicInteger;

 public class KreirajDomenskiObjekat { // Receiver
    
   Kontroler kon;
     
    public KreirajDomenskiObjekat(Kontroler kon1){kon=kon1;} 
     
    public boolean kreirajDomenskiObjekat(){
    boolean signal;
    Rezervacija r= new Rezervacija(); // Promenljivo!!!
    AtomicInteger counter = new AtomicInteger(0);
    
    kon.getBrokerBazePodataka().makeConnection();
    if (!kon.getBrokerBazePodataka().getCounter(r,counter)) return false;
    if (!kon.getBrokerBazePodataka().increaseCounter(r,counter)) return false;
          
    r.setSifraRezervacije(counter.get()); // Promenljivo!!!
    signal = kon.getBrokerBazePodataka().insertRecord(r);
    if (signal==true) 
        { kon.getBrokerBazePodataka().commitTransation();
          kon.napuniGrafickiObjekatIzDomenskogObjekta(r);
          kon.setPoruka("Sistem je kreirao novu rezervaciju."); // Promenljivo!!!
        }
        else
        { kon.getBrokerBazePodataka().rollbackTransation();
         kon.isprazniGrafickiObjekat();
         kon.setPoruka("Sistem ne moze da kreira novu rezervaciju."); // Promenljivo!!!
        }
    kon.prikaziPoruku();
    kon.getBrokerBazePodataka().closeConnection();
    return signal;
}
    
}
