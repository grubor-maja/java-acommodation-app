/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RefinedAbstraction;

/**
 *
 * @author Maja
 */
public class test { public static void main(String[] args) {
       A a;
       A a1 = new A();
       B b = new B();
       a=a1;
       a.prikazi();
       a=b;
       a.prikazi();
    }
    
}

class A {void prikazi(){System.out.println("A");}}

class B extends A
{
    @Override
    void prikazi(){System.out.println("B");}
}
