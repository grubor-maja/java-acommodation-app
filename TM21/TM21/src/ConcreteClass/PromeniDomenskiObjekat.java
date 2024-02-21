/* PromeniDomenskiObjekat.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 06.11.2017
 */

package ConcreteClass;

import AbstractClass.OpstaDBSO;
import AbstractProductB.BrokerBazePodataka;
import Client.Kontroler;


public class PromeniDomenskiObjekat extends OpstaDBSO{ // ConcreteClass

    public PromeniDomenskiObjekat(BrokerBazePodataka bbp1,Kontroler kon1) {super(bbp1,kon1);}
    
    
        
    @Override
    public boolean konkretnaDBSO() // update record
   { return bbp.updateRecord(kon.getDomenskiObjekat());}
    
    @Override
    public void uspesnaDBOperacija()
    { bbp.commitTransation();
      kon.setPoruka("Систем je променио испитну пријаву.");
    }

    @Override
    public void neuspesnaDBOperacija()
     {  bbp.rollbackTransation();
      kon.isprazniGrafickiObjekat();
      kon.setPoruka("Систем не може да промени испитну пријаву.");
     }
   }
