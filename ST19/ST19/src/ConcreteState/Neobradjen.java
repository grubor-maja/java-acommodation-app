/* Neobradjen.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 02.12.2017
 */

package ConcreteState;

import AbstractProductC.Kontroler;
import DomainClasses.Rezervacija;
import State.Stanje;

public class Neobradjen extends Stanje{ 
    public Neobradjen(Kontroler kon1) {kon = kon1;}
    @Override
    public void obradiDomenskiObjekat()
    {  Rezervacija dk = (Rezervacija) kon.getDKObject();
       dk.setStanje("obradjen");
       kon.promeniDomenskiObjekat();
       kon.napuniGrafickiObjekatIzDomenskogObjekta(dk);
    }
    @Override
    public void stornirajDomenskiObjekat()
     { Rezervacija dk = (Rezervacija) kon.getDKObject();
       dk.setStanje("storniran");
       kon.promeniDomenskiObjekat();
       kon.napuniGrafickiObjekatIzDomenskogObjekta(dk);
     }
    
    public void promeniDomenskiObjekat()
    {  kon.promeniDomenskiObjekat();
    }
    
}
