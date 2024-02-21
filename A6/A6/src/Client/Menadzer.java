/* Sef.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 06.11.2017
 */

package Client;

import Adaptee.Projektant;
import Adaptee.Projektant2;
import Adapter.Prevodilac1;
import Target.*;


public class Menadzer { // Client
        Prevodilac pse; //    
        
Menadzer (Prevodilac pse1){pse = pse1; }   
public static void main(String args[])  {  
       
Projektant proj = new Projektant2(); // promenljivo!!!
Prevodilac pse = new Prevodilac1(proj);
Menadzer sef = new Menadzer(pse);
sef.Konstruisi();
}

void Konstruisi()     {   
      pse.createSoftwareSystem();
      pse.createScreenForm();
      pse.createDatabaseBroker();
      pse.createController();
      pse.showScreenForm();
} 
    
}
