
package ConcreteCommand;

import Colleaque.PromeniDomenskiObjekat;
import Command.SistemskaOperacija;



  public class SOPromeni implements  SistemskaOperacija// ConcreteCommand
{   PromeniDomenskiObjekat pdo;
 
    public SOPromeni(PromeniDomenskiObjekat pdo1) 
      {pdo=pdo1;}
    
       
    @Override // execute(){receiver.action()}
    public void izvrsiSO()
    {pdo.promeniDomenskiObjekat();}
}  
