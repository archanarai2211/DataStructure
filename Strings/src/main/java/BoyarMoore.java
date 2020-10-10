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
        for(int i = 0; i< text.length();){
            if(bt.get(text.charAt(i))!=null){
                i = i+bt.get(text.charAt(i);
            }
            i = i+pattern.length();
        }


    }

    private static HashMap<Character, Integer> generateBadTable(String pattern) {
        HashMap<Character, Integer> bt =new HashMap<Character, Integer>();
        for(int i = 0; i< pattern.length();i++){
            int max = Math.max(1, pattern.length()-i-1);
            bt.put(pattern.charAt(i), max);
        }
    }
}
