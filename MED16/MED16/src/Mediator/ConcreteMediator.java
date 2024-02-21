
package Mediator;

import Colleaque.CloseConnection;

import Colleaque.DBOperation;
import Colleaque.MakeConnection;
import Colleaque.UspesnostDBOperacije;
import DomainClasses.GeneralDObject;


public class ConcreteMediator implements Mediator {
    MakeConnection mk;
    UspesnostDBOperacije udbo;
    CloseConnection cc;
    DBOperation dbo;
    public ConcreteMediator(MakeConnection mk1,UspesnostDBOperacije udbo1,CloseConnection cc1,DBOperation dbo1){mk=mk1;udbo=udbo1;cc=cc1;dbo=dbo1;}
    @Override
    public void neuspesnaDBOperacija(String poruka){udbo.neuspesnaDBOperacija(poruka);}
    
    @Override
    public void neuspesnaDBOperacija1(String poruka){udbo.neuspesnaDBOperacija1(poruka);}
    
    @Override
    public void neuspesnaDBOperacija2(String poruka){udbo.neuspesnaDBOperacija2(poruka);}
    
    @Override
    public void makeConnection() { mk.makeConnection(); }
    
    @Override
    public void uspesnaDBOperacija(String poruka) { udbo.uspesnaDBOperacija(poruka); }
    
    @Override
    public void uspesnaDBOperacija1(String poruka,GeneralDObject gdo) { udbo.uspesnaDBOperacija1(poruka,gdo); }
    
    @Override
    public void uspesnaDBOperacija2(String poruka) { udbo.uspesnaDBOperacija2(poruka); }
    
    @Override
    public void uspesnaDBOperacija3(String poruka,GeneralDObject gdo) { udbo.uspesnaDBOperacija3(poruka,gdo); }
    
    @Override
    public void closeConnection() { cc.closeConnection(); }
    
    @Override
    public boolean insertRecord() { return dbo.insertRecord(); }
    
    @Override
    public GeneralDObject findRecord() { return dbo.findRecord(); }
    
    @Override
    public boolean deleteRecord() { return dbo.deleteRecord();}
    
    @Override
    public boolean updateRecord() { return dbo.updateRecord();}
}
