/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbstractFactory;

import AbstractProductA.EkranskaForma;
import AbstractProductA.*;
import AbstractProductB.*;
import AbstractProductC.*;

public interface Projektant {
       EkranskaForma kreirajEkranskuFormu();   
       BrokerBazePodataka kreirajBrokerBazePodataka ();
       Kontroler kreirajKontroler (EkranskaForma ef,BrokerBazePodataka dbbr);   
}
