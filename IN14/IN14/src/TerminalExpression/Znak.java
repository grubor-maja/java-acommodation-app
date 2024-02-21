
package TerminalExpression;

public class Znak extends TerminalIzraz
{ char znak;
  public Znak(char znak1){znak = znak1;}  
  @Override
  public boolean Interpretiraj(String znak)
   {  return String.valueOf(znak).equals(znak);
   }
}