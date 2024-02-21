/* Dugme.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 06.11.2017
 */

package Context;

import AbstractClass.OpstaDBSO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;




public class Dugme { // Invoker
   
    public Dugme(OpstaDBSO odbso,JButton dugme){
       dugme.addActionListener(new OsluskivacDugme(odbso)); 
    }
}

class OsluskivacDugme implements ActionListener
{   OpstaDBSO odbso;
 
    OsluskivacDugme(OpstaDBSO odbso1) {odbso = odbso1;}
    
    @Override
    public void actionPerformed(ActionEvent e) {
         odbso.opstaDBSO();
    }
}

