/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package AbstractProductA;

import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Maja
 */
public class Panel1 extends Panel {

    /**
     * Creates new form Panel1
     */
    public Panel1() {
        initComponents();
        
               
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBrojOsoba = new javax.swing.JTextField();
        lblBrojOsoba = new javax.swing.JLabel();
        lblSifraRezervacije = new javax.swing.JLabel();
        txtSifraRezervacije = new javax.swing.JTextField();
        btnNadji = new javax.swing.JButton();
        lblIme = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        lblNazivHotela = new javax.swing.JLabel();
        lblDatumPocetka = new javax.swing.JLabel();
        lblDatumZavrsetka = new javax.swing.JLabel();
        btnKreiraj = new javax.swing.JButton();
        btnPromeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        lblPoruka = new javax.swing.JLabel();
        txtPoruka = new javax.swing.JTextField();
        comboBoxNazivHotela = new javax.swing.JComboBox<>();
        datumZavrsetkaPicker = new datechooser.beans.DateChooserCombo();
        datumPocetkaPicker = new datechooser.beans.DateChooserCombo();
        jLabelBackground = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(txtBrojOsoba, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 180, -1));

        lblBrojOsoba.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblBrojOsoba.setText("Broj osoba:");
        add(lblBrojOsoba, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 120, 70, 30));

        lblSifraRezervacije.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSifraRezervacije.setText("Sifra rezervacije:");
        add(lblSifraRezervacije, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 0, 160, 40));

        txtSifraRezervacije.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSifraRezervacijeKeyPressed(evt);
            }
        });
        add(txtSifraRezervacije, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 80, -1));

        btnNadji.setText("Nadji");
        add(btnNadji, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, -1, -1));

        lblIme.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblIme.setText("Ime i prezime:");
        add(lblIme, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 36, 148, 40));

        txtIme.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtImeKeyPressed(evt);
            }
        });
        add(txtIme, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 180, -1));

        lblNazivHotela.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNazivHotela.setText("Naziv hotela:");
        add(lblNazivHotela, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 76, 148, 30));

        lblDatumPocetka.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDatumPocetka.setText("Datum pocetka rezervacije:");
        add(lblDatumPocetka, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 156, 160, 30));

        lblDatumZavrsetka.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDatumZavrsetka.setText("Datum zavrsetka rezervacije:");
        add(lblDatumZavrsetka, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 170, -1));

        btnKreiraj.setText("Kreiraj");
        add(btnKreiraj, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        btnPromeni.setText("Promeni");
        add(btnPromeni, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, -1, -1));

        btnObrisi.setText("Obrisi");
        add(btnObrisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, -1, -1));

        lblPoruka.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPoruka.setText("Poruka:");
        add(lblPoruka, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 80, -1));

        txtPoruka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPorukaActionPerformed(evt);
            }
        });
        add(txtPoruka, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 260, -1));

        comboBoxNazivHotela.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hotel Zvezda", "Hotel Beli bor", "Hotel Zelenkada", "Hotel Planinac" }));
        add(comboBoxNazivHotela, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 180, -1));
        add(datumZavrsetkaPicker, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 180, -1));
        add(datumPocetkaPicker, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 180, -1));

        jLabelBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hotel2.jpg"))); // NOI18N
        add(jLabelBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, -17, 410, 350));
    }// </editor-fold>//GEN-END:initComponents

    private void txtSifraRezervacijeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSifraRezervacijeKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
                txtIme.requestFocusInWindow();
          }
    }//GEN-LAST:event_txtSifraRezervacijeKeyPressed

    private void txtImeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtImeKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
                comboBoxNazivHotela.requestFocusInWindow();
          }
    }//GEN-LAST:event_txtImeKeyPressed

    private void txtPorukaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPorukaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPorukaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKreiraj;
    private javax.swing.JButton btnNadji;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPromeni;
    private javax.swing.JComboBox<String> comboBoxNazivHotela;
    private datechooser.beans.DateChooserCombo datumPocetkaPicker;
    private datechooser.beans.DateChooserCombo datumZavrsetkaPicker;
    private javax.swing.JLabel jLabelBackground;
    private javax.swing.JLabel lblBrojOsoba;
    private javax.swing.JLabel lblDatumPocetka;
    private javax.swing.JLabel lblDatumZavrsetka;
    private javax.swing.JLabel lblIme;
    private javax.swing.JLabel lblNazivHotela;
    private javax.swing.JLabel lblPoruka;
    private javax.swing.JLabel lblSifraRezervacije;
    private javax.swing.JTextField txtBrojOsoba;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtPoruka;
    private javax.swing.JTextField txtSifraRezervacije;
    // End of variables declaration//GEN-END:variables

    @Override
    public String getSifraRezervacije() {
        return txtSifraRezervacije.getText();
    }

    

    @Override
    public String getImePrezime() {
        return txtIme.getText();
    }

    @Override
    public String getNazivHotela() {
        return comboBoxNazivHotela.getSelectedItem().toString();
    }

    public String getBrojOsoba() {
        return txtBrojOsoba.getText();
    }
    

    @Override
    public Date getDatumPocetka() {
    return datumPocetkaPicker.getSelectedDate().getTime();
    }

    @Override
    public Date getDatumZavrsetka() {
    return datumZavrsetkaPicker.getSelectedDate().getTime();
    }

    @Override
    public void setSifraRezervacije(String sifraRezervacije) {
        txtSifraRezervacije.setText(sifraRezervacije);
    }

    @Override
    public void setImePrezime(String imePrezime) {
        txtIme.setText(imePrezime);    }

    @Override
    public void setNazivHotela(String nazivHotela) {
        comboBoxNazivHotela.setSelectedItem(nazivHotela);    }

    @Override
    public void setBrojOsoba(String brojOsoba) {
        txtBrojOsoba.setText(brojOsoba);
    }
    @Override
    public void setDatumPocetka(Date datumPocetka) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(datumPocetka);
        datumPocetkaPicker.setSelectedDate(gc);
}

    @Override
    public void setDatumZavrsetka(Date datumZavrsetka) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(datumZavrsetka);
        datumZavrsetkaPicker.setSelectedDate(gc);
}

    @Override
    public void setPoruka(String Poruka) {
        txtPoruka.setText(Poruka);
    }

    @Override
    public JButton getKreiraj() {
        return btnKreiraj;
    }

    @Override
    public JButton getPromeni() {
        return btnPromeni;    }

    @Override
    public JButton getObrisi() {
        return btnObrisi;    }

    @Override
    public JButton getNadji() {
        return btnNadji;    }

    @Override
    public JTextField getSifraRezervacije1() {
        return txtSifraRezervacije;
    }

    
}
