
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
        { med.uspesnaDBOperacija("������ je �������� ������� ������."); // Promenljivo!!!
        }
        else
        { med.neuspesnaDBOperacija("������ �� ���� �� ������� ������� ������."); // Promenljivo!!!
        }
    med.closeConnection();
    return signal;   
}
    
}
