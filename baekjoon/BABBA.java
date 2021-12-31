import java.util.Scanner;

public class BABBA {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int k=scanner.nextInt();
        int A=0;
        int B=0;
        int[] Adata=new int[k+1];
        int[] Bdata=new int[k+1];
        Adata[0]=1;
        Bdata[0]=0;

        for(int i=1;i<=k;i++){
            Adata[i]=Adata[i-1];
            Bdata[i]=Bdata[i-1];
            Bdata[i]+=Adata[i-1]; // A->B
            Adata[i]-=Adata[i-1]; // A->B
            Adata[i]+=Bdata[i-1]; // B->BA
        }
        A=Adata[k]; B=Bdata[k];
        System.out.println(A+" "+B);
    }
}
/*
A -> B -> BA -> BAB -> BABBA -> BABBABAB
10  01    11    21
 */