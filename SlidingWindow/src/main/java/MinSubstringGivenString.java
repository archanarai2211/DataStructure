import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class MinSubstringGivenString {

    public static void main(String[] args) {
        String a = "aarchanaraai";
        System.out.println(minWindow(a, "ari"));

    }

    public static String minWindow(String s, String t) {
        if(s.length()==0 || t.length()==0)
            return "";

        Map<Character, Integer> dictT = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count + 1);
        }
       // System.out.println(dictT.entrySet());

        int min = Integer.MAX_VALUE;
        int startWindow = 0;
        int count = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        TreeMap<Integer, String> result = new TreeMap<>();
       // System.out.println(t.length());

        for(int endWindow =0; endWindow< s.length(); endWindow++){
                int cou = map.getOrDefault(s.charAt(endWindow), 0);
                map.put(s.charAt(endWindow), ++cou);
                if(dictT.containsKey(s.charAt(endWindow)) && dictT.get(s.charAt(endWindow))>=cou){
                    count ++;
                }
          //  System.out.println("map:"+map);
          //  System.out.println("count:"+ count);
            while(count >= t.length()){
                int window = endWindow - startWindow +1;
                if(min >window) {
                    min = window;
                   // System.out.println(start + ":" + (endWindow + 1));
                    result.put(min, s.substring(startWindow, endWindow + 1));
                   // System.out.println("resultMap:" + result);
                }
                Character c = s.charAt(startWindow);
                int cnt = map.get(c);
                if(dictT.containsKey(c) && dictT.get(c)>--cnt){
                    count--;
                }
                if(cnt == 0){
                    map.remove(c);
                }else{
                    map.put(c, cnt);
                }


                startWindow++;

            }

        }
        System.out.println("resultMap:"+result);
        return result.get(min);
    }

}
