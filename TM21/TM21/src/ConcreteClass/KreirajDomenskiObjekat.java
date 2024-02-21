/* KreirajDomenskiObjekat.java
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
import DomainClasses.GeneralDObject;
import DomainClasses.Rezervacija;
import java.util.concurrent.atomic.AtomicInteger;


public class KreirajDomenskiObjekat extends OpstaDBSO{ // ConcreteClass

    public KreirajDomenskiObjekat(BrokerBazePodataka bbp1,Kontroler kon1) {super(bbp1,kon1);}
    
    
    @Override
    public void  makeConnection() {bbp.makeConnection();} 
    
    @Override
    public boolean konkretnaDBSO() // insert record
{     kon.isprazniGrafickiObjekat();
      GeneralDObject r = kon.getDomenskiObjekat();
      AtomicInteger counter = new AtomicInteger(0);
    
      if (!bbp.getCounter(r,counter)) return false;
      if (!bbp.increaseCounter(r,counter)) return false;
       kon.napuniDomenskiObjekatIzGrafickogObjekta();
      ((Rezervacija)kon.r).setSifraRezervacije(counter.get()); // Promenljivo!!!
      
      return bbp.insertRecord(kon.r);

}
    @Override
    public void uspesnaDBOperacija()
    { bbp.commitTransation();
      kon.setPoruka("Sistem je kreirao novu rezervaciju.");
      kon.napuniGrafickiObjekatIzDomenskogObjekta(kon.getDomenskiObjekat());
    }

    @Override
    public void neuspesnaDBOperacija()
     { bbp.rollbackTransation();
       kon.isprazniGrafickiObjekat();
       kon.setPoruka("Sistem ne moze da kreira novu rezervaciju.");
     }
    
}
