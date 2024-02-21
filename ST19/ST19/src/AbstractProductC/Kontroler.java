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
import DomainClasses.GeneralDObject;

public abstract class Kontroler {
    EkranskaForma ef;
    BrokerBazePodataka bbp;
    Rezervacija r;   // Promenljivo!!!
    String poruka;
    public GeneralDObject getDKObject(){return r;}
    public abstract boolean promeniDomenskiObjekat();
    public void setPoruka(String poruka1){poruka = poruka1;}
    public abstract void prikaziPoruku(); 
    abstract public void napuniGrafickiObjekatIzDomenskogObjekta(Rezervacija r);
    abstract public boolean nadjiDomenskiObjekat1();
}
