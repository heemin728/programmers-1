
//2839
import java.util.Scanner;

public class Candy {
   public static void main(String[] args) {
      Scanner scanner=new Scanner(System.in);
        int N=scanner.nextInt();
        //3kg, 5kg
        int result=-1;
        int rest=0;
        //18
        if(N%5==0){
            result=N/5;
        }
        else{
            rest=N/5; // 3
            for(int i=rest;i>=0;i--){
                int rest5=N-5*i;
                if(rest5%3==0){
                    result=i+rest5/3;
                    break;
                }
                else continue;
            }
        }
        System.out.println(result);
    }
}

