/* Dugme.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 02.12.2017
 */

package Context;

import AbstractProductC.Kontroler;
import Strategy.SistemskaOperacija;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;



/*public class Dugme { // Context
   
    public Dugme(SistemskaOperacija so,JButton dugme){
       dugme.addActionListener(new OsluskivacDugme(so)); 
    }
}

class OsluskivacDugme implements ActionListener
{   SistemskaOperacija so;
 
    OsluskivacDugme(SistemskaOperacija so1) {so = so1;}
    
    @Override
    public void actionPerformed(ActionEvent e) {
         so.izvrsiSO();
    }
}*/

public class Dugme { // Context
   
    public Dugme(SistemskaOperacija so,JButton dugme){
       dugme.addActionListener((ActionEvent e)->{so.izvrsiSO();}); 
    }
}


