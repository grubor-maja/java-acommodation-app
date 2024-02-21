
package Colleaque;

import AbstractProductB.BrokerBazePodataka;
import Client.Kontroler;
import Mediator.Mediator;


public class MakeConnection extends Colleague{
   public MakeConnection(BrokerBazePodataka bbp1,Kontroler kon1){bbp=bbp1;kon=kon1;}
      
    public void makeConnection()
   {  kon.napuniDomenskiObjekatIzGrafickogObjekta();
      bbp.makeConnection();
   }
    
   
}
