/* Panel.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 06.11.2017
 */


package AbstractProductA;



import java.awt.event.KeyEvent;
import java.util.Date;

// Promenljivo!!!
public abstract class Panel extends javax.swing.JPanel{
       
       public abstract String getSifraRezervacije(); // Promenljivo!!!
       public abstract javax.swing.JTextField getSifraRezervacije1();
       public abstract String getImePrezime(); // Promenljivo!!!
       public abstract String getNazivHotela(); // Promenljivo!!!
       public abstract Date getDatumPocetka(); // Promenljivo!!!
       public abstract Date getDatumZavrsetka(); // Promenljivo!!!
       public abstract String getBrojOsoba(); // Promenljivo!!!
       
       public abstract void setSifraRezervacije(String sifraRezervacije); // Promenljivo!!!
       public abstract void setImePrezime(String imePrezime); // Promenljivo!!!
       public abstract void setNazivHotela(String nazivHotela); // Promenljivo!!!
       public abstract void setDatumPocetka(Date DatumPocetka); // Promenljivo!!!
       public abstract void setDatumZavrsetka(Date DatumZavrsetka); // Promenljivo!!!
       public abstract void setBrojOsoba(String brojOsoba); // Promenljivo!!!
       
       public abstract void setPoruka(String Poruka);
       
       public abstract javax.swing.JButton getKreiraj(); 
       public abstract javax.swing.JButton getPromeni(); 
       public abstract javax.swing.JButton getObrisi(); 
       public abstract javax.swing.JButton getNadji();
       public abstract javax.swing.JButton getMemento();
       
       
       
}
