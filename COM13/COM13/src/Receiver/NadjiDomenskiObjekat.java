
package Receiver;


import Client.Kontroler;
import DomainClasses.Rezervacija;

 public class NadjiDomenskiObjekat { // Receiver
    
   Kontroler kon;
    
    
    public NadjiDomenskiObjekat(Kontroler kon1){kon=kon1;} 
     
    public boolean nadjiDomenskiObjekat(){
    kon.napuniDomenskiObjekatIzGrafickogObjekta();
    boolean signal;
    kon.getBrokerBazePodataka().makeConnection();
    Rezervacija r = (Rezervacija)kon.getBrokerBazePodataka().findRecord(kon.getDomenskiObjekat()); // Promenljivo!!!
    if (r != null) 
        { kon.napuniGrafickiObjekatIzDomenskogObjekta(r);
          kon.setPoruka("Sistem je nasao rezervaciju"); // Promenljivo!!!
          signal = true;
        }
        else
        { kon.isprazniGrafickiObjekat();
          kon.setPoruka("Sistem ne moze da nadje rezervaciju."); // Promenljivo!!!
          signal = false;
        }
    kon.prikaziPoruku();
    kon.getBrokerBazePodataka().closeConnection();
    return signal;  
}
    
}
