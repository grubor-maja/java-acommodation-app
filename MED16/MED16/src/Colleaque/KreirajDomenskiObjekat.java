
package Colleaque;

import AbstractProductB.BrokerBazePodataka;
import Client.Kontroler;
import Mediator.Mediator;


 public class KreirajDomenskiObjekat extends Colleague{ 
    
    public KreirajDomenskiObjekat(BrokerBazePodataka bbp1,Kontroler kon1,Mediator med1){bbp=bbp1;kon=kon1;med=med1;} 
     
    public boolean kreirajDomenskiObjekat(){
    boolean signal;
    bbp.makeConnection();
    signal = med.insertRecord();
    if (signal==true) 
        { med.uspesnaDBOperacija1("������ �� ������� ���� ������� ������.",kon.getDomenskiObjekat()); // Promenljivo!!!
        }
        else
        { med.neuspesnaDBOperacija("������ �� ���� �� ������ ���� ������� ������."); // Promenljivo!!!
        }
    med.closeConnection();
    return signal;
}
    
}
