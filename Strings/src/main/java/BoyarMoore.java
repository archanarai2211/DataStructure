import java.util.HashMap;

public class BoyarMoore {

    public static void main(String[] args) {
        String text = "archanarai";
        String pattern = "rai";
        System.out.println(bm(text, pattern));
    }

    private static int bm(String text, String pattern) {
        //bad table
        HashMap<Character, Integer> bt = generateBadTable(pattern);
        //text length
        int tl = text.length();
        //pattern length
        int pl = pattern.length();
        int noOfSkips;
        for(int i = 0; i< tl-pl;i=i+noOfSkips){
            noOfSkips = 0;
            //start comparing from end of pattern
            for(int j = pl-1; j>=0; j--){
                if(pattern.charAt(j) != text.charAt(i+j)) {
                    if (bt.get(pattern.charAt(j)) != null) {
                        noOfSkips = bt.get(pattern.charAt(j));
                    }else{
                        noOfSkips=pl;
                    }
                    break;
                }
            }
            if(noOfSkips==0)
                return i;
        }
        return tl;

    }

    private static HashMap<Character, Integer> generateBadTable(String pattern) {
        HashMap<Character, Integer> bt =new HashMap<Character, Integer>();
        for(int i = 0; i< pattern.length();i++){
            int max = Math.max(1, pattern.length()-i-1);
            bt.put(pattern.charAt(i), max);
        }
        return bt;
    }
}
