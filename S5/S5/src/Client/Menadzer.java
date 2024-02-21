/* Sef.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 06.11.2017
 */

package Client;

import AbstractFactory.*;
import AbstractProductA.*;
import AbstractProductB.*;
import AbstractProductC.*;


class SoftverskiSistemSingleton   // Singleton
{
static Menadzer.SoftverskiSistem ss;
static boolean jedinstvenoPojavljivanje = false;

static Menadzer.SoftverskiSistem Instance(EkranskaForma ef1,BrokerBazePodataka bbp1,Kontroler kon1)
    {   if (jedinstvenoPojavljivanje == false)
           { ss = new Menadzer.SoftverskiSistem(ef1,bbp1,kon1);
             jedinstvenoPojavljivanje = true;
           }
        return ss;
    }
}

public class Menadzer { // Client
Projektant proj; // Abstract Factory   
        
        public static class SoftverskiSistem // Complex Product
                   {  EkranskaForma ef; // AbstractProductA 
                      BrokerBazePodataka bbp; // AbstractProductB 
                      Kontroler kon; // AbstractProductC 

                      public SoftverskiSistem(EkranskaForma ef1,BrokerBazePodataka bbp1,Kontroler kon1){ef=ef1;bbp=bbp1;kon=kon1;}
                      void prikaziEkranskuFormu(){ef.prikaziEkranskuFormu();}

                   }



Menadzer (Projektant proj1){proj = proj1; }   
public static void main(String args[])  {  
Menadzer sef;                    
// ConcreteFactory1
Projektant proj = new Projektant4(); // Promenljivo!!!
sef = new Menadzer(proj);
sef.Kreiraj();
}

void Kreiraj()     { 
      EkranskaForma ef =proj.kreirajEkranskuFormu();
      BrokerBazePodataka bbp = proj.kreirajBrokerBazePodataka();
      Kontroler kon= proj.kreirajKontroler(ef,bbp);
      Menadzer.SoftverskiSistem ss = SoftverskiSistemSingleton.Instance(ef,bbp,kon);
      System.out.println(ss);
      ss.prikaziEkranskuFormu();
      Menadzer.SoftverskiSistem ss1 = SoftverskiSistemSingleton.Instance(ef,bbp,kon);
      System.out.println(ss1);
} 


    
}
