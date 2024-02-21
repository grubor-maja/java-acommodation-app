/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbstractFactory;

import AbstractProductA.EkranskaForma2;
import AbstractProductA.EkranskaForma;
import AbstractProductA.*;
import AbstractProductB.*;
import AbstractProductC.*;

// Promenljivo!!!
public class Projektant1 implements Projektant {
        
    @Override
    public EkranskaForma kreirajEkranskuFormu() {
        Panel pan = new Panel2(); // Promenljivo!!!
        EkranskaForma2 r = new EkranskaForma2(); // Promenljivo!!!
        r.setPanel(pan);
        r.pack();
        return r;
    }   
    
    @Override
    public BrokerBazePodataka kreirajBrokerBazePodataka () 
      { BrokerBazePodataka dbbr = new BrokerBazePodataka1(); // Promenljivo!!!
        return dbbr;}  
    
    @Override
    public Kontroler kreirajKontroler (EkranskaForma ef,BrokerBazePodataka dbbr) {
        Kontroler kon = new Kontroler1(ef,dbbr); // Promenljivo!!!
        return kon;
    }
        
   
}
