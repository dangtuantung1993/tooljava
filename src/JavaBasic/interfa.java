/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaBasic;

import static JavaBasic.ParentOne.pOne;
import static JavaBasic.ParentTwo.pTwo;

/**
 *
 * @author TDG
 */
public class interfa {
    public static void main(String[] args) {
        InheritClass ic = new InheritClass();
        ic.printParentOne();
        ic.printParentTwo();
        ic.printChild();
        ic.printall();
    }

    
}
class InheritClass implements Child{
    public void printParentOne(){
        System.out.println(pOne);
        
    }
    public void printParentTwo(){
        System.out.println(pTwo);
        
    }
    public void printChild(){
        
        System.out.println(child);
        
    }
    public void printall(){
        System.out.println(pTwo*child);
}
}
interface ParentOne{
    int pOne = 1;
    void printParentOne();
        }
interface ParentTwo{
    int pTwo = 100;
    void printParentTwo();
        }
interface Child{
    int child =101;
    void printChild();
        }