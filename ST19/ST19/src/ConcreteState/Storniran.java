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
    {  kon.setPoruka("�� ���� �� �� ������ ���������� ������!");
       kon.prikaziPoruku();
       kon.nadjiDomenskiObjekat1();
     
    }
    @Override
    public void stornirajDomenskiObjekat()
    {  kon.setPoruka("�� ���� �� �� �������� ���������� ������!");
       kon.prikaziPoruku();
       kon.nadjiDomenskiObjekat1();
    }
    
    @Override
    public void promeniDomenskiObjekat()
     { kon.setPoruka("�� ���� �� �� ������� ���������� ������� ������!");
       kon.prikaziPoruku();
       kon.nadjiDomenskiObjekat1();
     }
}
