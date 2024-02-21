
package Invoker;

import Client.Kontroler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import Command.SistemskaOperacija;



public class Dugme { // Invoker
   
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
}

