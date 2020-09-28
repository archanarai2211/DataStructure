import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Set;

public class TestCode {
    public static void main(String[] args) {
//        System.out.println(OneEditApart("cat", "dog")) ;//= false
//        System.out.println(OneEditApart("cat", "cats"));// = true
//        System.out.println(OneEditApart("cat", "cut")) ;//= true
//        System.out.println(OneEditApart("cat", "cast"));// = true
//        System.out.println(OneEditApart("cat", "at") );//= true
//        System.out.println(OneEditApart("cat", "act")) ;//= false


        Set<String> set1 = new HashSet<String>();
        set1.add("a");
        set1.add("b");
        set1.add("c");

        Set<String> set2 = new HashSet<String>();
        set2.add("d");
        set2.add("b");
        set2.add("c");
        Set<String> union = new HashSet<>();
        union.addAll(set1);   union.addAll(set2);
        Set<String> intersaction = new HashSet<>();
        intersaction.addAll(set1);   intersaction.retainAll(set2);
        Set<String> diffSet = new HashSet<>();
        diffSet.addAll(set1);
//        Array s2 = set2.toArray();
//        for(int i=0; i<set2.size();i++){
//            if(diffSet.contains(set2.))
//        }
        Set<String> symetricDiff = new HashSet<>();
        symetricDiff.addAll(union);
        symetricDiff.removeAll(intersaction);

        System.out.println(set1);
        System.out.println(union);
        System.out.println(intersaction);
        System.out.println(symetricDiff);


    }

    static Boolean OneEditApart(String s1, String s2){
        if(s1.length()>s2.length()+1 ||s2.length()>s1.length()+1 ){
            return false;
        }
        int count = 0;
        int l = Math.min(s1.length(), s2.length());
        int j = 0;
        boolean th = false;
        for(int i = 0; i< l; i++){
            j = i;
            if(count>0){
              j=i-1;
            }
            if( s1.charAt(i) != s2.charAt(i) ){
                if( s1.charAt(i) != s2.charAt(j) ){
                    count++;
                    if(count>1){
                        return false;
                    }
                }else{
                    th = true;
                }

            }else if(th){
                if(s1.charAt(i) != s2.charAt(j)){
                    count++;
                    if(count>1){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
