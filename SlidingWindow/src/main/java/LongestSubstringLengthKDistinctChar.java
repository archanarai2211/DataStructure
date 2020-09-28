import java.util.HashMap;
import java.util.Map;

public class LongestSubstringLengthKDistinctChar {

    public static void main(String[] args) {
            String a = "aarcacahhhhhakkkknaraaai";
        System.out.println(findLongestSubstringLengthKDistinctChar(a, 3));
    }

    public static int findLongestSubstringLengthKDistinctChar(String a, int k){

        Map<Character, Integer> dic = new HashMap<>();
        int windowStart = 0;
        int maxWindowSize = Integer.MIN_VALUE;

        for(int windowEnd =0; windowEnd< a.length(); windowEnd++){

                int count = dic.getOrDefault(a.charAt(windowEnd), 0);
                dic.put(a.charAt(windowEnd), ++count);

            while(dic.size() >= k+1 ) {

                maxWindowSize = Math.max(maxWindowSize, windowEnd-windowStart) ;

               // System.out.println(maxWindowSize+":"+(windowEnd-windowStart));


                Character c= a.charAt(windowStart);
                //System.out.println(c);
                //System.out.println(maxWindowSize);
                System.out.println(dic);
                int co = dic.get(c);
                --co;
                if(co == 0){
                    dic.remove(c);
                }else{
                    dic.put(c, co);
                }

                //System.out.println("new"+dic);
                windowStart++;
            }

        }
        return maxWindowSize;
    }

}
