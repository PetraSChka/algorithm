import java.util.ArrayList;

public class BM {
    public ArrayList<Integer> iterable = new ArrayList<Integer>();
    static int NO_OF_CHARS = 256;
    private static int i;


    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    static void badCharHeuristic(char[] str, int size, int badchar[]) {
        for (int i = 0; i < NO_OF_CHARS; i++)
            badchar[i] = -1;

        for (i = 0; i < size; i++)
            badchar[(int) str[i]] = i;
    }

    public void search(char pat[], char txt[]) {
        int m = pat.length;
        int n = txt.length;

        int badchar[] = new int[NO_OF_CHARS];

        badCharHeuristic(pat, m, badchar);

        int s = 0;
        while (s <= (n - m)) {
            int j = m - 1;

            while (j >= 0 && pat[j] == txt[s + j])
                j--;

            if (j < 0) {
                iterable.add(s);
                s += (s + m < n) ? m - badchar[txt[s + m]] : 1;

            } else
                s += max(1, j - badchar[txt[s + j]]);
        }
    }

    public void findAll(char pat[], char txt[]){
        this.search(pat, txt);
        System.out.println(iterable);
    }


    public static void main(String []args) {

        char txt[] = "LELU FOR FREE HALLELUJAH".toCharArray();
        char pat[] = "LELU".toCharArray();
    }
}
