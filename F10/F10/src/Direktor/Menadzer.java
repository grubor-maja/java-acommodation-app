/* Sef.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 06.11.2017
 */

package Direktor;

import Builder.*;


public class Menadzer { // Facade
        Projektant proj;    
        
public Menadzer (){proj = new Projektant1(); }   

public void kreirajSoftverskiSistem() {proj.kreirajSoftverskiSistem();}
public void kreirajEkranskuFormu() { proj.kreirajEkranskuFormu();}
public void kreirajBrokerBazePodataka(){ proj.kreirajBrokerBazePodataka();}
public void kreirajKontroler(){ proj.kreirajKontroler();}
public void prikaziEkranskuFormu (){ proj.prikaziEkranskuFormu();}
  
}
