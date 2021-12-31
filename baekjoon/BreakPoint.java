import java.util.Scanner;

public class BreakPoint {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int A,B,C;
        A=scanner.nextInt();
        B=scanner.nextInt();
        C=scanner.nextInt();

        int n= B>=C ? -2 : A/(C-B);
        System.out.println((int)n+1);

        scanner.close();
    }
}
