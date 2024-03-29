/* Kontroler.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 06.11.2017
 */

package AbstractProductC;

import AbstractProductA.EkranskaForma;
import AbstractProductB.BrokerBazePodataka;
import DomainClasses.Rezervacija;
import Memento.Memento;
import Originator.Originator;

public abstract class Kontroler { //Caretaker
    EkranskaForma ef;
    BrokerBazePodataka bbp;
    Rezervacija r;   
    Memento memento;
    Originator orig;
    String poruka;
         
}
