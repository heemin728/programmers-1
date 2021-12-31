import java.util.Scanner;

public class Fraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        int mul = 0;
        int check = 1;
        int count = 1;
        int bb = 0;
        while (target >= check) {
            check += 1 + 4 * mul;
            count += 2;
            bb = 1 + 4 * mul;
            mul++;
        }
        check -= bb;
        if(target==1) count=1; else count -= 2;
        int getIndex;

        if ((check + check + 4 * (mul - 1)) / 2 <= target) {
            getIndex = check + 4 * (mul - 1);
        } else {
            getIndex = check;
            count--;
        }
        int down = count;
        int up = 1;

        int dif = Math.abs(target - getIndex);
        for (int i = 0; i < dif; i++) {
            up++;
            down--;
        }
        System.out.println(up + "/" + down);
    }
}