
package ConcreteCommand;


import Colleaque.KreirajDomenskiObjekat;
import Command.SistemskaOperacija;



  public class SOKreiraj implements SistemskaOperacija
{   KreirajDomenskiObjekat kdo;
 
    public SOKreiraj(KreirajDomenskiObjekat kdo1) 
      {kdo = kdo1;}
    
       
    public void izvrsiSO()
    {kdo.kreirajDomenskiObjekat();}
}  
