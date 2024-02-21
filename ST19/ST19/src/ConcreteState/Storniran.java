/* Storniran.java
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

public class Storniran extends Stanje{ 
    public Storniran(Kontroler kon1) {kon = kon1;}
    @Override
    public void obradiDomenskiObjekat()
    {  kon.setPoruka("Не може да се обради сторнирана пријава!");
       kon.prikaziPoruku();
       kon.nadjiDomenskiObjekat1();
     
    }
    @Override
    public void stornirajDomenskiObjekat()
    {  kon.setPoruka("Не може да се сторнира сторнирана пријава!");
       kon.prikaziPoruku();
       kon.nadjiDomenskiObjekat1();
    }
    
    @Override
    public void promeniDomenskiObjekat()
     { kon.setPoruka("Не може да се промени сторнирана испитна пријава!");
       kon.prikaziPoruku();
       kon.nadjiDomenskiObjekat1();
     }
}
