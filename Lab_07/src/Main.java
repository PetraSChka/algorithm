import java.util.ArrayList;

public class Main
{
    public final static int d = 256;
    static ArrayList<Integer> search(String pat, String txt)
    {
        RabinKarp rk = new RabinKarp();
        int M = pat.length();
        int N = txt.length();
        int i, j;
        long p = 0;
        long t = 0;
        long h = 1;
        long q = rk.getQ();
        ArrayList<Integer> iterable = new ArrayList<Integer>();

        for (i = 0; i < M-1; i++)
            h = (h*d)%q;

        for (i = 0; i < M; i++)
        {
            p = (d*p + pat.charAt(i))%q;
            t = (d*t + txt.charAt(i))%q;}

        for (i = 0; i <= N - M; i++){
            if ( p == t ){
                if (check(pat, txt, i, M) == M){
                    iterable.add(i);
                }}

            if ( i < N-M ){
                t = (d*(t - txt.charAt(i)*h) + txt.charAt(i+M))%q;
                if (t < 0)
                    t = (t + q);}}
        return iterable; }

    static public int check(String pat, String txt, int i, int M) {
        int j = 0;
        for (; j < M; j++) {
            if (pat.charAt(j) != txt.charAt(i + j)) {
                return 0;
            }
        }
        return j;

    }

    public void findAll(String pat, String txt){
        System.out.println(search(pat, txt));
    }

    public static void main(String[] args)
    {
        String txt = "LELU FOR FREE HALLELUJAH";
        String pat = "LELU";
        System.out.println(search(pat, txt));
    }
}