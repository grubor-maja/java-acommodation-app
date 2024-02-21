
package Receiver;

import AbstractProductB.BrokerBazePodataka;
import Client.Kontroler;

 public class PromeniDomenskiObjekat { // Receiver
    
    BrokerBazePodataka bbp;
    Kontroler kon;
    
    
    public PromeniDomenskiObjekat(BrokerBazePodataka bbp1,Kontroler kon1){bbp=bbp1;kon=kon1;} 
     
    public boolean promeniDomenskiObjekat(){
    kon.napuniDomenskiObjekatIzGrafickogObjekta();
    bbp.makeConnection();
    boolean signal = bbp.updateRecord(kon.getDomenskiObjekat());
    if (signal==true) 
        { bbp.commitTransation();
          kon.setPoruka("Систем je променио испитну пријаву."); // Promenljivo!!!
        }
        else
        { bbp.rollbackTransation();
          kon.isprazniGrafickiObjekat();
          kon.setPoruka("Систем не може да промени испитну пријаву."); // Promenljivo!!!
        }
    kon.prikaziPoruku();
    bbp.closeConnection();
    return signal;   
}
    
}
