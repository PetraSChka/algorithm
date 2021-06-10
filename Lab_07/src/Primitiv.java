import java.util.ArrayList;

public class Primitiv {
    public ArrayList<Integer> iterable = new ArrayList<Integer>();

    public int search(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        for (int i=0;i<=N-M;i++){
            int j;
            for(j=0;j<M;j++){
                if(txt.charAt(i+j)!=pat.charAt(j))
                    break;
            }
            if(j==M) iterable.add(i);
        }
        return N;
    }

    public void findAll(String pat, String txt){
        this.search(pat, txt);
        System.out.println(iterable);
    }
}
