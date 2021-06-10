import java.math.BigInteger;
import java.sql.SQLOutput;
import java.util.Random;

public class RabinKarp {
    private String pat;
    private long patHash;
    private int M;
    private long Q;
    private int R = 256;
    private long RM;

    public RabinKarp() {
        this.pat = "FREE";
        this.M = pat.length();
        Q = longRandomPrime();
        RM = 1;
        for (int i = 1; i <= M - 1; i++) {
            RM = (R * RM) % Q;
        }
        patHash = hash(pat, M);
    }

    public long getQ (){return Q;};

    public boolean check(String txt, int i) {
        for (int j = 0; j < M; j++) {
                if (pat.charAt(j) != txt.charAt(i + j)) {
                return false;
            }
        }
        return true;

    }

    public boolean check(int i) {
        return true;
    }

    private static long longRandomPrime() {
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }

    private long hash(String key, int M) {
        long h = 0;
        for (int j = 0; j < M; j++) {
            h = (R * h + key.charAt(j)) % Q;
        }
        return h;
    }

    public int search(String txt) {
        int N = txt.length();
        long txtHash = hash(txt, M);
        //System.out.println("txtHash = " + txtHash);
        //System.out.println("patHash = " + patHash);
        if (patHash == txtHash) {
            System.out.println("Pattern found at index 0");
        }
        for (int i = M; i < N; i++) {
            txtHash = (Q + txtHash -RM*txt.charAt(i-M)%Q)%Q;
            txtHash=(txtHash*R+txt.charAt(i))%Q;
            if (patHash == txtHash) {
                if (check(txt,i - M+1)) {
                    System.out.println("Position: " + (i - M+1));
                }
            }
        }
        return N;
    }
}
