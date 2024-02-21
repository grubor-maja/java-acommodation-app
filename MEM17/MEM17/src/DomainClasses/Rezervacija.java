/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainClasses;


import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Promenljivo!!!
public class Rezervacija implements Serializable, GeneralDObject {
  
    private int sifraRezervacije;
    private String imePrezime;
    private String nazivHotela;
    private int brojOsoba;
    private java.util.Date datumPocetka;
    private java.util.Date datumZavrsetka;
    
     public Rezervacija() {
        sifraRezervacije = 0;
        imePrezime = "N/A";
        nazivHotela = "N/A";
        brojOsoba = 0;
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        Date dDatum = new Date();
        datumPocetka = java.sql.Date.valueOf(sm.format(dDatum));
        datumZavrsetka = java.sql.Date.valueOf(sm.format(dDatum));

    }

    public Rezervacija(int sifraRezervacije, String imePrezime, String nazivHotela, int brojOsoba, Date datumPocetka, Date datumZavrsetka) {
        this.sifraRezervacije = sifraRezervacije;
        this.imePrezime = imePrezime;
        this.nazivHotela = nazivHotela;
        this.brojOsoba = brojOsoba;
        this.datumPocetka = datumPocetka;
        this.datumZavrsetka = datumZavrsetka;
    }

     
    
    // Primarni kljuc		
    public Rezervacija(int sifraRezervacije)  	
    {   this.sifraRezervacije = sifraRezervacije;
    }

    public int getSifraRezervacije() {
        return sifraRezervacije;
    }

    public void setSifraRezervacije(int sifraRezervacije) {
        this.sifraRezervacije = sifraRezervacije;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public String getNazivHotela() {
        return nazivHotela;
    }

    public void setNazivHotela(String nazivHotela) {
        this.nazivHotela = nazivHotela;
    }

    public int getBrojOsoba() {
        return brojOsoba;
    }

    public void setBrojOsoba(int brojOsoba) {
        this.brojOsoba = brojOsoba;
    }
    

    public Date getDatumPocetka() {
        return datumPocetka;
    }

    public void setDatumPocetka(Date datumPocetka) {
        this.datumPocetka = datumPocetka;
    }

    public Date getDatumZavrsetka() {
        return datumZavrsetka;
    }

    public void setDatumZavrsetka(Date datumZavrsetka) {
        this.datumZavrsetka = datumZavrsetka;
    }
    
    
    
    @Override
    public String getNameByColumn(int index) {
        String columns[] = {"sifraRezervacije", "imePrezime", "nazivHotela","brojOsoba","datumPocetka", "datumZavrsetka"};
        return columns[index];
    }		
 
@Override
public String getAtrValue() {
    return sifraRezervacije + ", " + "'" + imePrezime + "'" + ", " + "'" + nazivHotela + "'" +", " +"'"+brojOsoba+"'"+", '" + datumPocetka + "', '" + datumZavrsetka + "'";
}

@Override
public String setAtrValue() {
    return   "sifraRezervacije=" + sifraRezervacije + ", " +
            "imePrezime='" + imePrezime + "', " +
            "nazivHotela='" + nazivHotela + "', " +
            "brojOsoba='" +brojOsoba+"', "+
            "datumPocetka='" + datumPocetka + "', " +
            "datumZavrsetka='" + datumZavrsetka + "'";
}


    @Override
    public String getClassName() {
       return "Rezervacija";
    }

    @Override
    public String getWhereCondition() {
       return "sifraRezervacije ="+sifraRezervacije;
    }
    @Override
    public GeneralDObject getNewRecord(ResultSet rs) throws SQLException {

    
     return new Rezervacija(rs.getInt("sifraRezervacije"), rs.getString("imePrezime"), rs.getString("nazivHotela"),rs.getInt("brojOsoba"),rs.getDate("datumPocetka"), rs.getDate("datumZavrsetka"));
        
    }
}
