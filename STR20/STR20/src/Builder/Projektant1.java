/* Projektant1.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 06.11.2017
 */

package Builder;

import AbstractProductC.Kontroler1;
import AbstractProductA.*;
import AbstractProductB.*;

// promenljivo!!!
public class Projektant1 extends Projektant {
    
    @Override
    public void kreirajSoftverskiSistem()
    { ss = new SoftverskiSistem();
    }
    
    @Override
    public void kreirajEkranskuFormu() 
      { Panel pan = new Panel1(); // promenljivo!!!
        ss.ef = new EkranskaForma2(); // promenljivo!!!
        ss.ef.setPanel(pan);
        ss.ef.pack();
      }   
    
    @Override
    public void kreirajBrokerBazePodataka () 
      { ss.bbp = new BrokerBazePodataka1(); // promenljivo!!!
      }  
        
    @Override
    public void kreirajKontroler () 
      { ss.kon = new Kontroler1(ss.ef,ss.bbp); // promenljivo!!!
      }

    @Override
    public void prikaziEkranskuFormu() 
      { ss.ef.prikaziEkranskuFormu();
      }
}

