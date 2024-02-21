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
import ConcreteClass.KreirajDomenskiObjekat;
import ConcreteClass.NadjiDomenskiObjekat;
import ConcreteClass.ObrisiDomenskiObjekat;
import ConcreteClass.PromeniDomenskiObjekat;

import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;
import DomainClasses.GeneralDObject;
import DomainClasses.Rezervacija;
import Context.Dugme;
import Context.TekstPolje;



public final class Kontroler1 extends Kontroler{ // Client
   
    
   
    
    public Kontroler1(EkranskaForma ef1,BrokerBazePodataka bbp1){ef=ef1;bbp=bbp1; Povezi();}
    
    void Povezi()
    {
      KreirajDomenskiObjekat kdo = new KreirajDomenskiObjekat(bbp,this); 
      Dugme dk1 = new Dugme(kdo,ef.getPanel().getKreiraj()); 
      
      PromeniDomenskiObjekat pdo = new PromeniDomenskiObjekat(bbp,this);
      Dugme dk2 = new Dugme(pdo,ef.getPanel().getPromeni());
      
      ObrisiDomenskiObjekat odo = new ObrisiDomenskiObjekat(bbp,this);
      Dugme dk3 = new Dugme(odo,ef.getPanel().getObrisi());
      
      NadjiDomenskiObjekat ndo = new NadjiDomenskiObjekat(bbp,this);
      Dugme dk4 = new Dugme(ndo,ef.getPanel().getNadji());
      
      
      TekstPolje tp = new TekstPolje(ndo,ef.getPanel().getSifraRezervacije1());
         
     
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
        r= new Rezervacija();
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







