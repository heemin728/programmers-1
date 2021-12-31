import java.util.Scanner;

public class Hotel {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int repeat=scanner.nextInt();
        for(int i=0;i<repeat;i++){

            int H=scanner.nextInt();
            int W=scanner.nextInt();
            int N=scanner.nextInt();
            String room="";
            if(N%H==0) room=room.concat(Integer.toString(H));
            else room=room.concat(Integer.toString(N%H));
            if(N/H+1<10) room=room.concat("0");
            if(N%H==0)room=room.concat(Integer.toString(N/H));
            else room=room.concat(Integer.toString(N/H+1));
            System.out.println(room);
        }
    }
}
