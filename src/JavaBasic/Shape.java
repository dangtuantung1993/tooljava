/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaBasic;
/**
 *
 * @author TDG
 */
public abstract class Shape{
      int a =7; int b =7 ;int c =10;
    abstract void drow();
    void messeage()
    {
        System.out.println("leu leu kute phomai que");
        
    }
    
    public static void main(String[] args) {
      
        TG tg = new TG();
        HCN hcn = new HCN();
        tg.drow();
        hcn.drow();
        
        
    }
    
}
class TG extends Shape{
    void drow(){
        int d =a +b +c;
      
        System.out.println( "Chu vi hinh tam giac : = " + d );
        
    }
}
class HCN extends Shape{
    void drow(){
        int h = (a+b) *2;
        System.out.println("chu vi hinh chu nhat : =" +h);
    }
}

        

