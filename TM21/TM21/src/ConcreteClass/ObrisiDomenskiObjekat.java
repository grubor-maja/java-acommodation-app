/* ObrisiDomenskiObjekat.java
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


public class ObrisiDomenskiObjekat extends OpstaDBSO{ // ConcreteClass

    public ObrisiDomenskiObjekat(BrokerBazePodataka bbp1,Kontroler kon1) {super(bbp1,kon1);}
    
    
       
    @Override
    public boolean konkretnaDBSO() // delete record
   { return bbp.deleteRecord(kon.getDomenskiObjekat());}
    
    @Override
    public void uspesnaDBOperacija()
    { bbp.commitTransation();
      kon.setPoruka("Sistem je obrisao rezervaciju.");
      kon.isprazniGrafickiObjekat();
    }

    @Override
    public void neuspesnaDBOperacija()
     { bbp.rollbackTransation();
      kon.setPoruka("Sistem ne moze da obrise rezervaciju.");
     }
   }
