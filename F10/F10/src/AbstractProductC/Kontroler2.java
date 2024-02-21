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
import DomainClasses.Rezervacija;
import java.util.Date;


public final class Kontroler2 extends Kontroler{
    
    
      
    public Kontroler2(EkranskaForma ef1,BrokerBazePodataka bbp1){ef=ef1;bbp=bbp1; Povezi(); osveziFormu();}
    
    void Povezi()
    {javax.swing.JButton Kreiraj = ef.getPanel().getKreiraj();
     javax.swing.JButton Promeni = ef.getPanel().getPromeni();
     javax.swing.JButton Obrisi = ef.getPanel().getObrisi();
     javax.swing.JButton Nadji = ef.getPanel().getNadji();
     Kreiraj.addActionListener( new OsluskivacKreiraj1(this));
     Promeni.addActionListener( new OsluskivacPromeni1(this));
     Obrisi.addActionListener( new OsluskivacObrisi1(this));
     Nadji.addActionListener( new OsluskivacNadji11(this));
     
     javax.swing.JTextField SifraPrijave = ef.getPanel().getSifraRezervacije1(); // Promenljivo!!!
     SifraPrijave.addFocusListener( new OsluskivacNadji12(this));
    }
    
// Promenljivo!!!  
void napuniDomenskiObjekatIzGrafickogObjekta()   {
       r= new Rezervacija();
       r.setSifraRezervacije(getInteger(ef.getPanel().getSifraRezervacije()));
       r.setImePrezime(ef.getPanel().getImePrezime());
       r.setNazivHotela(ef.getPanel().getNazivHotela());
  
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
    ef.getPanel().setDatumPocetka(r.getDatumPocetka());
    ef.getPanel().setDatumZavrsetka(r.getDatumZavrsetka());
      
    }

// Promenljivo!!!
void isprazniGrafickiObjekat(){

    ef.getPanel().setSifraRezervacije("");
    ef.getPanel().setImePrezime("N/A");
    ef.getPanel().setNazivHotela("N/A");
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


void prikaziPoruku(String poruka) 
{ ef.getPanel().setPoruka(poruka);
      
  Timer timer = new Timer();
  
  timer.schedule(new TimerTask() {
  @Override
  public void run() {
    ef.getPanel().setPoruka(""); 
  }
}, 1000);
  
}

void osveziFormu() 
{    
  Timer timer = new Timer();
  
  timer.scheduleAtFixedRate(new TimerTask() {
  @Override
  public void run() {
      napuniDomenskiObjekatIzGrafickogObjekta();
      nadjiDomenskiObjekat();
      prikaziPoruku("Osvezavanje forme!!!");
  }
}, 0,20000);
  
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
          poruka ="Sistem ne moze da zapamti novu rezervaciju"; // Promenljivo!!!  
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
          poruka = "Sistem je kreirao rezervaciju."; // Promenljivo!!!
        }
        else
        { bbp.rollbackTransation();
        isprazniGrafickiObjekat();
        poruka ="Sistem ne moze da kreira novu rezervaciju."; // Promenljivo!!!
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
          poruka = "Sistem je uspesno obrisao rezervaciju"; // Promenljivo!!!
            isprazniGrafickiObjekat();
        }
        else
        { bbp.rollbackTransation();
          poruka = "Sistem ne moze da brise rezervaciju."; // Promenljivo!!!
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
          poruka = "Sistem je uspesno promenio rezervaciju."; // Promenljivo!!!
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
          poruka = "Sistem je nasao rezervaciju.";  // Promenljivo!!!
          signal = true;
        }
        else
        { isprazniGrafickiObjekat();
          poruka ="Sistem ne moze da nadje rezervaciju"; // Promenljivo!!!
          signal = false;
        }
    prikaziPoruku();
    bbp.closeConnection();
    return signal;   
}

}

class OsluskivacZapamti1 implements ActionListener
{   Kontroler2 kon;
 
    OsluskivacZapamti1(Kontroler2 kon1) {kon = kon1;}
    
@Override
    public void actionPerformed(ActionEvent e) {
         kon.napuniDomenskiObjekatIzGrafickogObjekta();
         kon.zapamtiDomenskiObjekat();
        
    }
}

class OsluskivacKreiraj1 implements ActionListener
{   Kontroler2 kon;
 
    OsluskivacKreiraj1(Kontroler2 kon1) {kon = kon1;}
    
@Override
    public void actionPerformed(ActionEvent e) {
         kon.kreirajDomenskiObjekat();
         
        
    }
}

class OsluskivacObrisi1 implements ActionListener
{   Kontroler2 kon;
 
    OsluskivacObrisi1(Kontroler2 kon1) {kon = kon1;}
    
@Override
    public void actionPerformed(ActionEvent e) {
         kon.napuniDomenskiObjekatIzGrafickogObjekta();
         kon.obrisiDomenskiObjekat();
        
    }
}

class OsluskivacPromeni1 implements ActionListener
{   Kontroler2 kon;
 
    OsluskivacPromeni1(Kontroler2 kon1) {kon = kon1;}
    
@Override
    public void actionPerformed(ActionEvent e) {
         kon.napuniDomenskiObjekatIzGrafickogObjekta();
         kon.promeniDomenskiObjekat();
        
    }
}

class OsluskivacNadji11 implements ActionListener
{   Kontroler2 kon;
 
    OsluskivacNadji11(Kontroler2 kon1) {kon = kon1;}
    
@Override
    public void actionPerformed(ActionEvent e) {
         kon.napuniDomenskiObjekatIzGrafickogObjekta();
         kon.nadjiDomenskiObjekat();
        
    }
}

class OsluskivacNadji12 implements FocusListener
{   Kontroler2 kon;
 
    OsluskivacNadji12(Kontroler2 kon1) {kon = kon1;}
    

    public void focusLost(java.awt.event.FocusEvent e) {
         kon.napuniDomenskiObjekatIzGrafickogObjekta();
         kon.nadjiDomenskiObjekat();
        
    }

    @Override
    public void focusGained(FocusEvent e) {
       
    }
}

