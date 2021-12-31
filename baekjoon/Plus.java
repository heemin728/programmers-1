import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.List;
public class Plus {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int number=scanner.nextInt(); // 입력받은 숫자 개수
        int[] getN=new int[number+1]; // 개수만큼 입력받는 데이터

        List<Integer> listGetN= new ArrayList<>();
        for(int i=0;i<number;i++){
            getN[i]=scanner.nextInt();
            listGetN.add(getN[i]);
        }

        Collections.sort(listGetN);
        int max=listGetN.get(listGetN.size()-1);
        int[] n=new int[max+1];
        n[0]=0; n[1]=1; n[2]=2; n[3]=4;

        for(int i=4;i<=max;i++){
            n[i]=n[i-1]+n[i-2]+n[i-3];
        }
        for(int i=0;i<number;i++){
            System.out.println(n[getN[i]]);
        }

    }
}