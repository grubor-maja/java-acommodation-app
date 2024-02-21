/* NullStanje.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 02.12.2017
 */

package ConcreteState;

import AbstractProductC.Kontroler;
import State.Stanje;

public class NullStanje extends Stanje{ 
    public NullStanje(Kontroler kon1) {kon = kon1;}
    @Override
    public void obradiDomenskiObjekat()
    {
       kon.setPoruka("Не може да се обради непостојећа пријава!");
       kon.prikaziPoruku();
    }
    @Override
    public void stornirajDomenskiObjekat()
    {
       kon.setPoruka("Не може да се сторнира непостојећа пријава!");
       kon.prikaziPoruku();
    }
    
    @Override
    public void promeniDomenskiObjekat()
    {
       kon.setPoruka("Не може да се промени непостојећа пријава!");
       kon.prikaziPoruku();
    }
    
}
