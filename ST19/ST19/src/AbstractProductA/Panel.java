/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Maja
 */
package AbstractProductA;



import java.awt.event.KeyEvent;
import java.util.Date;

// Promenljivo!!!
public abstract class Panel extends javax.swing.JPanel{
       
       public abstract String getSifraRezervacije(); // Promenljivo!!!
       public abstract javax.swing.JTextField getSifraRezervacije1();
       public abstract String getImePrezime(); // Promenljivo!!!
       public abstract String getNazivHotela();
       public abstract String getBrojOsoba();// Promenljivo!!!
       public abstract Date getDatumPocetka(); // Promenljivo!!!
       public abstract Date getDatumZavrsetka(); // Promenljivo!!!
       public abstract String getStanje ();
       
       public abstract void setSifraRezervacije(String sifraRezervacije); // Promenljivo!!!
       public abstract void setImePrezime(String imePrezime); // Promenljivo!!!
       public abstract void setNazivHotela(String nazivHotela);
       public abstract void setBrojOsoba(String brojOsoba);// Promenljivo!!!
       public abstract void setDatumPocetka(Date DatumPocetka); // Promenljivo!!!
       public abstract void setDatumZavrsetka(Date DatumZavrsetka); // Promenljivo!!!
       public abstract void setStanje(String Stanje1);
       public abstract void setPoruka(String Poruka);
       
       public abstract javax.swing.JButton getKreiraj(); 
       public abstract javax.swing.JButton getPromeni(); 
       public abstract javax.swing.JButton getObradi();
       public abstract javax.swing.JButton getStorniraj(); 
       public abstract javax.swing.JButton getNadji();

       
}