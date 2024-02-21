/* Stanje.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 02.12.2017
 */

package State;

import AbstractProductC.Kontroler;

public abstract class Stanje { 
    protected Kontroler kon;
    abstract public void obradiDomenskiObjekat();
    abstract public void stornirajDomenskiObjekat();
    abstract public void promeniDomenskiObjekat();
    
}
