
package Colleaque;

import AbstractProductB.BrokerBazePodataka;
import Client.Kontroler;
import Mediator.Mediator;


public class ObrisiDomenskiObjekat extends Colleague {
  
    public ObrisiDomenskiObjekat(BrokerBazePodataka bbp1,Kontroler kon1,Mediator med1){bbp=bbp1;kon=kon1;med=med1;}

    public boolean obrisiDomenskiObjekat(){
     med.makeConnection();
     boolean signal = med.deleteRecord();
     if (signal==true) 
        { med.uspesnaDBOperacija2("Систем je oбрисао испитну пријаву."); // Promenljivo!!!
        }
     else
        { med.neuspesnaDBOperacija1("Систем не може да обрише испитну пријаву."); // Promenljivo!!!
        }
     med.closeConnection();
     return signal;   
  }   
}
