/* Kontroler.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 06.11.2017
 */

package ClientInterpreter;

import AbstractProductA.EkranskaForma;
import AbstractProductB.BrokerBazePodataka;
import DomainClasses.Rezervacija;

public abstract class Kontroler {
    EkranskaForma ef;
    BrokerBazePodataka bbp;
    Rezervacija r;   // Promenljivo!!!
    String poruka;
         
}
