
package Originator;

import DomainClasses.Rezervacija;
import DomainClasses.Rezervacija;
import Memento.Memento;


public class Originator {
    Rezervacija r;
    
    public Originator(Rezervacija r) {this.r = r;}
    
    public Rezervacija setMemento(Memento mem)
    { 
      this.r = mem.getState();
      return this.r;
    }
    
    public Memento createMemento()
    { return new Memento(this.r);}
    
    
}
