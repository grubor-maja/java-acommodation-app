/* Kontroler1.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 06.11.2017
 */

package Client;


import AbstractProductA.*;
import AbstractProductB.*;
import ConcreteCommand.SO;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask; 
import DomainClasses.GeneralDObject;
import ConcreteCommand.SOKreiraj;
import ConcreteCommand.SONadji;
import ConcreteCommand.SOObrisi;
import ConcreteCommand.SOPromeni;
import DomainClasses.Rezervacija;


import Receiver.KreirajDomenskiObjekat;
import Receiver.NadjiDomenskiObjekat;
import Receiver.ObrisiDomenskiObjekat;
import Receiver.PromeniDomenskiObjekat;


public final class Kontroler1 extends Kontroler{ // Client
   
    
   
    
    public Kontroler1(EkranskaForma ef1,BrokerBazePodataka bbp1,SO so)
    {ef=ef1;bbp=bbp1; Povezi(so);}
    
    void Povezi(SO so)
    {
      
      KreirajDomenskiObjekat kdo = new KreirajDomenskiObjekat(this);
      so.sok = new SOKreiraj(kdo); // povezivanje ConcreteCommand i Receiver
           
      PromeniDomenskiObjekat pdo = new PromeniDomenskiObjekat(this);
      so.sop = new SOPromeni(pdo); 
            
      ObrisiDomenskiObjekat odo = new ObrisiDomenskiObjekat(this);
      so.soo = new SOObrisi(odo); 
            
      
      NadjiDomenskiObjekat ndo = new NadjiDomenskiObjekat(this);
      so.son = new SONadji(ndo); 
          
     
    }
    
// Promenljivo!!!  
    @Override
    public void napuniDomenskiObjekatIzGrafickogObjekta()   {
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
    @Override
    public void napuniGrafickiObjekatIzDomenskogObjekta(GeneralDObject gdo){
       Rezervacija r = (Rezervacija)gdo;
    ef.getPanel().setSifraRezervacije(Integer.toString(r.getSifraRezervacije()));
    ef.getPanel().setImePrezime(r.getImePrezime());
    ef.getPanel().setNazivHotela(r.getNazivHotela());
    ef.getPanel().setBrojOsoba(Integer.toString(r.getBrojOsoba()));
    ef.getPanel().setDatumPocetka(r.getDatumPocetka());
    ef.getPanel().setDatumZavrsetka(r.getDatumZavrsetka());
      
    }

   
// Promenljivo!!!
    @Override
    public void isprazniGrafickiObjekat(){

    ef.getPanel().setSifraRezervacije("");
    ef.getPanel().setImePrezime("N/A");
    ef.getPanel().setNazivHotela("N/A");
    ef.getPanel().setBrojOsoba("");
    ef.getPanel().setDatumPocetka(new java.util.Date());
    ef.getPanel().setDatumZavrsetka(new java.util.Date());
}

    @Override 
    public void prikaziPoruku(){ 
  ef.getPanel().setPoruka(poruka);
      
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


}    







