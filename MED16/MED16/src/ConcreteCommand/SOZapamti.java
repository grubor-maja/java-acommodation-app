
package ConcreteCommand;

import Colleaque.ZapamtiDomenskiObjekat;
import Command.SistemskaOperacija;



  public class SOZapamti implements  SistemskaOperacija// ConcreteCommand
{   ZapamtiDomenskiObjekat zdo;
 
    public SOZapamti(ZapamtiDomenskiObjekat zdo1) 
      {zdo=zdo1;}
    
       
    @Override // execute(){receiver.action()}
    public void izvrsiSO()
    {zdo.zapamtiDomenskiObjekat();}
}  
