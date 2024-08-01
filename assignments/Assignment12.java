package assignments;

public class Assignment12 {
 
  public void driver(){
    Recursion_2 Rec2Obj=new Recursion_2();

    System.out.println(Rec2Obj.SumDigits(112));


  }
}

class Recursion_2{

    int Sum_N(int n){
        if(n==0)  //or if(n==1)  return n;
        return n;
        else
        return n + Sum_N(n-1);    
    }

    int Sum_EvenN(int n){
        if(n==0)
        return n;
        else
        return 2*n + Sum_EvenN(n-1);    
    }

    int Sum_OddN(int n){
        if(n==0)
        return n;
        else
        return (2*n-1) + Sum_OddN(n-1);    
    }

    int FactorialOf(int n){
        if (n>0){
           return FactorialOf(n-1)*n;
        }
        else return 1;
        
    }

    int SumDigits(int n){
        if(n>0)
         return SumDigits(n/10) + (n%10) ;
         else 
         return 0;
    }

    


}




