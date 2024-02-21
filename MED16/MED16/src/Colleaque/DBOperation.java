
package Colleaque;

import AbstractProductB.BrokerBazePodataka;
import Client.Kontroler;
import DomainClasses.GeneralDObject;
import DomainClasses.Rezervacija;
import java.util.concurrent.atomic.AtomicInteger;

public class DBOperation extends Colleague{
   public DBOperation(BrokerBazePodataka bbp1,Kontroler kon1){bbp=bbp1;kon=kon1;}
      
       
    public boolean insertRecord()
    {
      GeneralDObject ip = kon.getDomenskiObjekat();
      AtomicInteger counter = new AtomicInteger(0);
    
      if (!bbp.getCounter(ip,counter)) return false;
      if (!bbp.increaseCounter(ip,counter)) return false;
          
      ((Rezervacija)ip).setSifraRezervacije(counter.get()); // Promenljivo!!!
      
      return bbp.insertRecord(ip);
    }
    
    public GeneralDObject findRecord()
    { return bbp.findRecord(kon.getDomenskiObjekat()); }
 
     public boolean deleteRecord()
      { return bbp.deleteRecord(kon.getDomenskiObjekat());}
     
     public boolean updateRecord()
      { return bbp.updateRecord(kon.getDomenskiObjekat());}
     
    
}
