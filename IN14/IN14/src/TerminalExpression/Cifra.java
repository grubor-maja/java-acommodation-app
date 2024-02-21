
package TerminalExpression;

public class Cifra extends TerminalIzraz 
{ @Override
  public boolean Interpretiraj(String broj)
   { try  { int c = Integer.parseInt(broj);
            return (c>=0) && (c<=9);
           }  catch(NumberFormatException nfe)  { return false; }

      }
}
