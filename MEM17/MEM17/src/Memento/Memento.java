/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Memento;

import DomainClasses.Rezervacija;

/**
 *
 * @author prof.dr Sinisa Vlajic
 */
public class Memento {
    Rezervacija r;
    
    public Memento(Rezervacija r){this.r = r;}
    
    public Rezervacija getState() {return r;}
    public void setState(Rezervacija dkip) {this.r = r;}
}
