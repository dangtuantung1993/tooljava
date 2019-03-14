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

 public class HinhHoc {
     
     public static void main(String[] args) {
         Hinhtron ht = new Hinhtron();
         HinhChuNhat hcn = new HinhChuNhat(5,6);
         
     }
    
    
    public HinhHoc(){
        System.out.println("Hinh hoc khong tham so :");
        
    }
    public HinhHoc(int giatri){
        System.out.println("hinh hoc co tham so : ");
    }
}    
class Hinhtron extends HinhHoc{
    double bankinh = 5;
    public Hinhtron(){
        System.out.println("hinh tron : ");
        
    }
}
class Hinhtamgiac extends HinhHoc{
    double a,b,c;
    public Hinhtamgiac(int a)
    {
        super (a);
        
    }
}
class HinhChuNhat extends HinhHoc{
    int dai,rong;
    public HinhChuNhat() {}
    public HinhChuNhat(int d, int r) {
       dai=d;
       rong=r;
        System.out.println("hinh chu nhat : "  + "(" + d +"," + r + ")"  );
    }
    public HinhChuNhat(int a) {
       dai=rong=a;
    }
}
