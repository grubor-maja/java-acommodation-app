
package NonterminalExpression;

import AbstractExpression.ApstraktniIzraz;
import TerminalExpression.Cifra;
import TerminalExpression.Znak;


public class SekSR extends NeterminalIzraz 
{   String format;
    
    public SekSR(String format1) // Apstraktna sintaksa
    { 
      
      format = format1;
      int duzina = format.length();
      ai = new ApstraktniIzraz[duzina];
      
      for(int i=0;i<duzina;i++)
      {
        if (format.charAt(i) == 'C')
          {ai[i] = new Cifra();}
        else
          {ai[i] = new Znak(format.charAt(i));}
      
      }
   }        
    
    public String getFormat(){return format;}
    
    @Override
    public boolean Interpretiraj(String sek)
        {             
           String[] clan = sek.split(""); 
                     
           if (clan.length<1)
                  return false;
           
           
           if(clan.length>ai.length) return false;
           for(int i=0;i<clan.length;i++)
	      { System.out.println("Clan[" + i + "]: " +  clan[i]);
	        if (ai[i].Interpretiraj(clan[i])==false)
	             { return false;
	             }
              }
           return true;
       }
}



