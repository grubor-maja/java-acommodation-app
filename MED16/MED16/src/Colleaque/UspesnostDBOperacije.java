
package Colleaque;

import AbstractProductB.BrokerBazePodataka;
import Client.Kontroler;
import DomainClasses.GeneralDObject;
import Mediator.Mediator;

public class UspesnostDBOperacije extends Colleague{
   public UspesnostDBOperacije(BrokerBazePodataka bbp1,Kontroler kon1){bbp=bbp1;kon=kon1;}
   public void uspesnaDBOperacija(String poruka)
   {  bbp.commitTransation();
      kon.setPoruka(poruka);
   }
   public void uspesnaDBOperacija1(String poruka,GeneralDObject gdo)
   {  bbp.commitTransation();
      kon.setPoruka(poruka);
      kon.napuniGrafickiObjekatIzDomenskogObjekta(gdo);
   }
   public void uspesnaDBOperacija2(String poruka)
   {  bbp.commitTransation();
      kon.setPoruka(poruka);
      kon.isprazniGrafickiObjekat();
   }
   
   public void uspesnaDBOperacija3(String poruka,GeneralDObject gdo)
   {  kon.napuniGrafickiObjekatIzDomenskogObjekta(gdo);
      kon.setPoruka(poruka); 
   }
   
    public void neuspesnaDBOperacija(String poruka)
   {  bbp.rollbackTransation();
      kon.isprazniGrafickiObjekat();
      kon.setPoruka(poruka); 
   }
   
   public void neuspesnaDBOperacija1(String poruka)
   {  bbp.rollbackTransation();
      kon.setPoruka(poruka); 
   }
   
    public void neuspesnaDBOperacija2(String poruka)
   { kon.isprazniGrafickiObjekat();
     kon.setPoruka(poruka);
   }
   
     
}
