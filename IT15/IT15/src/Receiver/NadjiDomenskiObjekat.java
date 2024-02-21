
package Receiver;

import AbstractProductB.BrokerBazePodataka;
import Client.Kontroler;
import DomainClasses.Rezervacija;

 public class NadjiDomenskiObjekat { // Receiver
    
    BrokerBazePodataka bbp;
    Kontroler kon;
    
    
    public NadjiDomenskiObjekat(BrokerBazePodataka bbp1,Kontroler kon1){bbp=bbp1;kon=kon1;} 
     
    public boolean nadjiDomenskiObjekat(){
    kon.napuniDomenskiObjekatIzGrafickogObjekta();
     boolean signal;
    bbp.makeConnection();
    Rezervacija r = (Rezervacija)bbp.findRecord(kon.getDomenskiObjekat()); // Promenljivo!!!
    if (r != null) 
        { kon.napuniGrafickiObjekatIzDomenskogObjekta(r);
          kon.setPoruka("Sistem je nasao rezervaciju."); // Promenljivo!!!
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
