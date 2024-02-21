/* PoslovniPartner.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 19.11.2017
 */

package Client;

import Direktor.*;



public class PoslovniPartner { // Client
        Menadzer sef;   
        
PoslovniPartner (Menadzer sef1){sef=sef1; }   
public static void main(String args[])  {  
PoslovniPartner pp;                    
Menadzer sef = new Menadzer(); // promenljivo!!!
pp = new PoslovniPartner(sef);
pp.Konstruisi();
}

void Konstruisi()     {   
      sef.kreirajSoftverskiSistem();
      sef.kreirajEkranskuFormu();
      sef.kreirajBrokerBazePodataka();
      sef.kreirajKontroler();
      sef.prikaziEkranskuFormu();
} 



    
}
