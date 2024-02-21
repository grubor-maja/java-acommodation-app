
package Colleaque;

import AbstractProductB.BrokerBazePodataka;
import Client.Kontroler;
import Mediator.Mediator;

public class CloseConnection extends Colleague{
   public CloseConnection(BrokerBazePodataka bbp1,Kontroler kon1){bbp=bbp1;kon=kon1;}
      
    public void closeConnection()
   {   kon.prikaziPoruku();
       bbp.closeConnection();
   }
   
}
