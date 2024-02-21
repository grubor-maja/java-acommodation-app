
package NonterminalExpression;

import AbstractExpression.ApstraktniIzraz;

public class SekSRPravilo1 extends NeterminalIzraz 
{  
   
 public SekSRPravilo1(ApstraktniIzraz ai1) {ai = new ApstraktniIzraz[1]; ai[0] = ai1;}
   
   @Override
   public boolean Interpretiraj(String sek)
   { 
       
     int prvaCifra = Integer.parseInt(sek.substring(0,1));
     if (prvaCifra==0) return false;
     if (!ai[0].Interpretiraj(sek)) return false;  
       

     return true;
   }

}