
package Colleaque;

import AbstractProductB.BrokerBazePodataka;
import Client.Kontroler;
import Mediator.Mediator;

 public class PromeniDomenskiObjekat extends Colleague{ 
    
    public PromeniDomenskiObjekat(BrokerBazePodataka bbp1,Kontroler kon1,Mediator med1){bbp=bbp1;kon=kon1;med=med1;} 
    
    public boolean promeniDomenskiObjekat(){
    med.makeConnection();
    boolean signal = med.updateRecord();
    if (signal==true) 
        { med.uspesnaDBOperacija("Систем je променио испитну пријаву."); // Promenljivo!!!
        }
        else
        { med.neuspesnaDBOperacija("Систем не може да промени испитну пријаву."); // Promenljivo!!!
        }
    med.closeConnection();
    return signal;   
}
    
}
