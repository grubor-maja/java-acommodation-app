/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbstractProductC;


import AbstractProductA.EkranskaForma;
import AbstractProductA.*;
import AbstractProductB.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Timer;
import java.util.TimerTask;
import DomainClasses.Rezervacija;  // Promenljivo
import java.util.Date;


public final class Kontroler1 extends Kontroler{
   
    
   
    
    public Kontroler1(EkranskaForma ef1,BrokerBazePodataka bbp1){ef=ef1;bbp=bbp1; Povezi();}
    
    void Povezi()
    {javax.swing.JButton Kreiraj = ef.getPanel().getKreiraj();
     javax.swing.JButton Promeni = ef.getPanel().getPromeni();
     javax.swing.JButton Obrisi = ef.getPanel().getObrisi();
     javax.swing.JButton Nadji = ef.getPanel().getNadji();
     Kreiraj.addActionListener( new OsluskivacKreiraj(this));
     Promeni.addActionListener( new OsluskivacPromeni(this));
     Obrisi.addActionListener( new OsluskivacObrisi(this));
     Nadji.addActionListener( new OsluskivacNadji(this));
     
     javax.swing.JTextField SifraRezervacije= ef.getPanel().getSifraRezervacije1(); // Promenljivo!!!
     SifraRezervacije.addFocusListener( new OsluskivacNadji1(this));
     
    }
    
// Promenljivo!!!  
void napuniDomenskiObjekatIzGrafickogObjekta()   {
       r= new Rezervacija();
       r.setSifraRezervacije(getInteger(ef.getPanel().getSifraRezervacije()));
       r.setImePrezime(ef.getPanel().getImePrezime());
       r.setNazivHotela(ef.getPanel().getNazivHotela());
       r.setBrojOsoba(getInteger(ef.getPanel().getBrojOsoba()));
  
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       java.util.Date Datum = java.sql.Date.valueOf(sdf.format(ef.getPanel().getDatumPocetka())); 
       r.setDatumPocetka(Datum); 
       
       java.util.Date Datum2 = java.sql.Date.valueOf(sdf.format(ef.getPanel().getDatumZavrsetka())); 
       r.setDatumZavrsetka(Datum2);
    
    }

// Promenljivo!!!
void napuniGrafickiObjekatIzDomenskogObjekta(Rezervacija r){
    ef.getPanel().setSifraRezervacije(Integer.toString(r.getSifraRezervacije()));
    ef.getPanel().setImePrezime(r.getImePrezime());
    ef.getPanel().setNazivHotela(r.getNazivHotela());
    ef.getPanel().setBrojOsoba(Integer.toString(r.getBrojOsoba()));
    ef.getPanel().setDatumPocetka(r.getDatumPocetka());
    ef.getPanel().setDatumZavrsetka(r.getDatumZavrsetka());
      
    }

// Promenljivo!!!
void isprazniGrafickiObjekat(){

    ef.getPanel().setSifraRezervacije("");
    ef.getPanel().setImePrezime("N/A");
    ef.getPanel().setNazivHotela("N/A");
    ef.getPanel().setBrojOsoba("");
    ef.getPanel().setDatumPocetka(new java.util.Date());
    ef.getPanel().setDatumZavrsetka(new java.util.Date());
    
}

void prikaziPoruku() 
{ ef.getPanel().setPoruka(poruka);
      
  Timer timer = new Timer();
  
  timer.schedule(new TimerTask() {
  @Override
  public void run() {
    ef.getPanel().setPoruka(""); 
  }
}, 3000);
  
}

 public int getInteger(String s) {
    int broj = 0;
    try
        {
            if(s != null)
                broj = Integer.parseInt(s);
        }
            catch (NumberFormatException e)
            { broj = 0;}
   
    return broj;
}


 
boolean zapamtiDomenskiObjekat(){ 
    
    bbp.makeConnection();
    napuniDomenskiObjekatIzGrafickogObjekta();
    boolean signal = bbp.insertRecord(r);
    if (signal==true) 
        { bbp.commitTransation();
          poruka ="Sistem je zapamtio novu rezervaciju.."; // Promenljivo!!!
        }
        else
        { bbp.rollbackTransation();
          poruka ="Sistem ne moze da zapamti novu rezervaciju."; // Promenljivo!!!  
        }
    prikaziPoruku();
    bbp.closeConnection();
    return signal; 
       
    }
    
boolean kreirajDomenskiObjekat(){
    boolean signal;
    napuniDomenskiObjekatIzGrafickogObjekta();
    AtomicInteger counter = new AtomicInteger(0);
    
    bbp.makeConnection();
    if (!bbp.getCounter(r,counter)) return false;
    if (!bbp.increaseCounter(r,counter)) return false;
          
    r.setSifraRezervacije(counter.get()); // Promenljivo!!!
    signal = bbp.insertRecord(r);
    if (signal==true) 
        { bbp.commitTransation();
          napuniGrafickiObjekatIzDomenskogObjekta(r);
          poruka = "Sistem je kreirao novu rezervaciju."; // Promenljivo!!!
        }
        else
        { bbp.rollbackTransation();
        isprazniGrafickiObjekat();
        poruka ="Sistem ne moze da keira novu rezervaciju."; // Promenljivo!!!
        }
    prikaziPoruku();
    bbp.closeConnection();
    return signal;
}

boolean obrisiDomenskiObjekat(){
    bbp.makeConnection();
    boolean signal = bbp.deleteRecord(r);
    if (signal==true) 
        { bbp.commitTransation();
          poruka = "Sistem je obrisao rezervaciju."; // Promenljivo!!!
            isprazniGrafickiObjekat();
        }
        else
        { bbp.rollbackTransation();
          poruka = "Sistem ne moze da obrise rezervaciju."; // Promenljivo!!!
        }
    prikaziPoruku();
    bbp.closeConnection();
    return signal;   
}

boolean promeniDomenskiObjekat(){
    bbp.makeConnection();
    boolean signal = bbp.updateRecord(r);
    if (signal==true) 
        { bbp.commitTransation();
          poruka = "Sistem je promenio rezervaciju."; // Promenljivo!!!
        }
        else
        { bbp.rollbackTransation();
          isprazniGrafickiObjekat();
          poruka = "Sistem ne moze da promeni rezervaciju."; // Promenljivo!!!
        }
    prikaziPoruku();
    bbp.closeConnection();
    return signal;   
}


boolean nadjiDomenskiObjekat(){
    boolean signal;
    bbp.makeConnection();
    r = (Rezervacija)bbp.findRecord(r); // Promenljivo!!!
    if (r != null) 
        { napuniGrafickiObjekatIzDomenskogObjekta(r);
          poruka = "Sistem je nasao rezervaciju."; // Promenljivo!!!
          signal = true;
        }
        else
        { isprazniGrafickiObjekat();
          poruka ="Sistem ne moze da pronadje rezervaciju."; // Promenljivo!!!
          signal = false;
        }
    prikaziPoruku();
    bbp.closeConnection();
    return signal;   
}

}

class OsluskivacZapamti implements ActionListener
{   Kontroler1 kon;
 
    OsluskivacZapamti(Kontroler1 kon1) {kon = kon1;}
    
@Override
    public void actionPerformed(ActionEvent e) {
         kon.napuniDomenskiObjekatIzGrafickogObjekta();
         kon.zapamtiDomenskiObjekat();
        
    }
}

class OsluskivacKreiraj implements ActionListener
{   Kontroler1 kon;
 
    OsluskivacKreiraj(Kontroler1 kon1) {kon = kon1;}
    
@Override
    public void actionPerformed(ActionEvent e) {
         kon.kreirajDomenskiObjekat();
         
        
    }
}

class OsluskivacObrisi implements ActionListener
{   Kontroler1 kon;
 
    OsluskivacObrisi(Kontroler1 kon1) {kon = kon1;}
    
@Override
    public void actionPerformed(ActionEvent e) {
         kon.napuniDomenskiObjekatIzGrafickogObjekta();
         kon.obrisiDomenskiObjekat();
        
    }
}

class OsluskivacPromeni implements ActionListener
{   Kontroler1 kon;
 
    OsluskivacPromeni(Kontroler1 kon1) {kon = kon1;}
    
@Override
    public void actionPerformed(ActionEvent e) {
         kon.napuniDomenskiObjekatIzGrafickogObjekta();
         kon.promeniDomenskiObjekat();
        
    }
}

class OsluskivacNadji implements ActionListener
{   Kontroler1 kon;
 
    OsluskivacNadji(Kontroler1 kon1) {kon = kon1;}
    
@Override
    public void actionPerformed(ActionEvent e) {
         kon.napuniDomenskiObjekatIzGrafickogObjekta();
         kon.nadjiDomenskiObjekat();
        
    }
}

class OsluskivacNadji1 implements FocusListener
{   Kontroler1 kon;
 
    OsluskivacNadji1(Kontroler1 kon1) {kon = kon1;}
    

    public void focusLost(java.awt.event.FocusEvent e) {
         kon.napuniDomenskiObjekatIzGrafickogObjekta();
         kon.nadjiDomenskiObjekat();
        
    }

    @Override
    public void focusGained(FocusEvent e) {
        
    }
}
