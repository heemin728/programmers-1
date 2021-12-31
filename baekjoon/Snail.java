import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;




public class Snail {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        double A=Integer.parseInt(st.nextToken());
        int B=Integer.parseInt(st.nextToken());
        int V=Integer.parseInt(st.nextToken());

        System.out.println((int)Math.ceil((V-A)/(A-B))+1);
    }
}
