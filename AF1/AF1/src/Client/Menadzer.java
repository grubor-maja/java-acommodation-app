/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Client;

import AbstractProductA.EkranskaForma;
import AbstractFactory.*;
import AbstractProductA.*;
import AbstractProductB.*;
import AbstractProductC.*;

public class Menadzer { // Client
        Projektant proj; // Abstract Factory   
        class SoftverskiSistem // Complex Product
           {  EkranskaForma ef; // AbstractProductA 
              BrokerBazePodataka bbp; // AbstractProductB 
              Kontroler kon; // AbstractProductC 
              SoftverskiSistem(EkranskaForma ef1,BrokerBazePodataka bbp1,Kontroler kon1){ef=ef1;bbp=bbp1;kon=kon1;}
              void prikaziEkranskuFormu(){ef.prikaziEkranskuFormu();}
           }
        SoftverskiSistem ss;

Menadzer (Projektant proj1){proj = proj1; }   


public static void main(String args[])  {  
Menadzer sef; 
// ConcreteFactory3
Projektant proj = new Projektant1(); // Promenljivo!!! 
sef = new Menadzer(proj);
sef.Kreiraj();
}

void Kreiraj()     { 
      EkranskaForma ef =proj.kreirajEkranskuFormu();
      BrokerBazePodataka bbp = proj.kreirajBrokerBazePodataka();
      Kontroler kon= proj.kreirajKontroler(ef,bbp);
      ss = new SoftverskiSistem(ef,bbp,kon);
      ss.prikaziEkranskuFormu();
} 
    
}