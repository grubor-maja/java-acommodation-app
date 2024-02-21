/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mediator;

import DomainClasses.GeneralDObject;

/**
 *
 * @author Sinisa
 */
public interface Mediator {
   void neuspesnaDBOperacija(String poruka);
   void neuspesnaDBOperacija1(String poruka); 
   void neuspesnaDBOperacija2(String poruka); 
   void makeConnection();
   void uspesnaDBOperacija(String poruka); 
   void uspesnaDBOperacija1(String poruka,GeneralDObject gdo);
   void uspesnaDBOperacija2(String poruka);
   void uspesnaDBOperacija3(String poruka,GeneralDObject gdo);
   void closeConnection();
   boolean insertRecord();
   GeneralDObject findRecord();
   boolean deleteRecord();
   boolean updateRecord();
}
