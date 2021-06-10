public class Main2 {
    public static void main(String[] args) {
        String txt = "LELU FOR FREE HALLELUJAH";
        String pat = "LELU";

        RabinKarp rabinKarp = new RabinKarp();
        rabinKarp.search(txt);

        Primitiv p = new Primitiv();
        p.findAll(pat, txt);

        KMP kmp = new KMP();
        kmp.findAll(pat.toCharArray(),txt.toCharArray());

        BM BM = new BM();
        BM.findAll(pat.toCharArray(),txt.toCharArray());

        Main lv = new Main();
        lv.findAll(pat, txt);
    }
}