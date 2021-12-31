import java.util.Scanner;

public class Fibonacci {
    static int fibonacci(int n){
        int[] data=new int[n+1];
        data[0]=0; data[1]=1;
        for(int i=2;i<=n;i++){
            data[i]=data[i-1]+data[i-2];
        }
        return data[n];
    }
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int getNum=scanner.nextInt();


        if(getNum==1 || getNum==0){
            System.out.println(getNum);
            return;
        }
        else{
            System.out.println(fibonacci(getNum));
        }
    }
}
