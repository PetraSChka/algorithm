import java.util.ArrayList;
import java.util.Arrays;

public class KMP {

    public ArrayList<Integer> iterable = new ArrayList<Integer>();
    int Size = 0;

    public static int[] indexesOf(char[] pattern, char[] text)
    {
        int[] pfl = pfl(pattern);
        int[] indexes = new int[text.length];
        int size = 0;
        int k = 0;
        for (int i = 0; i < text.length; ++i)
        {
            while (pattern[k] != text[i] && k > 0)
            {
                k = pfl[k - 1];
            }
            if (pattern[k] == text[i])
            {
                k = k + 1;
                if (k == pattern.length)
                {
                    indexes[size] = i + 1 - k;
                    size += 1;
                    k = pfl[k - 1];
                }
            }
            else
            {
                k = 0;
            }
        }
        return indexes;
    }

    public void findAll(char[] pattern, char[] text){
        for(int i = 0;i< indexesOf(pattern, text).length;i++){
            if(indexesOf(pattern, text)[i]!=0)
                iterable.add(indexesOf(pattern, text)[i]);
            if(indexesOf(pattern, text)[i]==0)
                if(i!=0){
                    if(indexesOf(pattern, text)[i-1]!=0)
                        break;}
                else  iterable.add(indexesOf(pattern, text)[i]);
        }
        System.out.println(iterable);
    }

    public static int[] pfl(char[] text)
    {
        int[] pfl = new int[text.length];
        pfl[0] = 0;

        for (int i = 1; i < text.length; ++i)
        {
            int k = pfl[i - 1];
            while (text[k] != text[i] && k > 0)
            {
                k = pfl[k - 1];
            }
            if (text[k] == text[i])
            {
                pfl[i] = k + 1;
            }
            else
            {
                pfl[i] = 0;
            }
        }

        return pfl;
    }
}
