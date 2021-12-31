import java.util.Scanner;


public class Main{
    public static void main(String[] args) {
        Answer answer=new Answer();
        My1 my=new My1();

        for(int i=1;i<=170*120;i++){
            String a=answer.answerFunc(170,120,i);
            String b=my.myFunc(170,120,i);
            System.out.println(a+", " +b+"  => "+ a.equals(b) +" , "+i);
        }

    }


}
 class Answer {

        String answerFunc(int H,int W, int N) {

            if (N % H == 0) {
                return Integer.toString((H * 100) + (N / H));
            } else {
                return Integer.toString(((N % H) * 100) + ((N / H) + 1));
            }
        }

}

class My1{

    String myFunc(int H,int W,int N){
        String room="";
        if(N%H==0) room=room.concat(Integer.toString(H));
        else room=room.concat(Integer.toString(N%H));
        if(N/H+1<10) room=room.concat("0");
        if(N%H==0) {
            if(N/H<10) room=room.concat("0");
            room = room.concat(Integer.toString(N / H));
        }

        else room=room.concat(Integer.toString(N/H+1));
        return room;

        /*
        N/H=9
        6 * 12
        10/6= 1 ... 4 -> 402
         */
    }
}

