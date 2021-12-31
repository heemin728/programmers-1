import java.util.Scanner;

public class Bee {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        for(int i=0;i<100;i++){
            My my=new My();
            BeeAnswer beeAnswer=new BeeAnswer();
            if(my.MyFunc(i)==beeAnswer.BeeAnswerFunc(i)){
                System.out.println(i+" => "+my.MyFunc(i)+" 로 같음");
            }
            else{
                System.out.println("****"+ i+" =>  my.MyFunc(i)은 "+my.MyFunc(i)+", beeAnswerFunk은 "+beeAnswer.BeeAnswerFunc(i));
            }
        }
    }
}

class My{
    int MyFunc(int N){
        int start=2;
        int multiple=1;
        while(start<=N)
            start+=6*(multiple++);
        if(N==2) return 2;
        else return multiple;
    }
}

class BeeAnswer{
    int BeeAnswerFunc(int n){
        int count = 2;
        int num = 2;
        int num2 = 7;

        if(n == 1)
            return 1;
        else {
            for(int i = 1; ; i++) {
                if(num<=n && n<=num2) {
                    return count;
                }
                else {
                    num += i*6;
                    num2 += (i+1)*6;
                    count++;
                }
            }
        }
    }
}
