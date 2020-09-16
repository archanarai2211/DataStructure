public class TestCode {
    public static void main(String[] args) {
        System.out.println(OneEditApart("cat", "dog")) ;//= false
        System.out.println(OneEditApart("cat", "cats"));// = true
        System.out.println(OneEditApart("cat", "cut")) ;//= true
        System.out.println(OneEditApart("cat", "cast"));// = true
        System.out.println(OneEditApart("cat", "at") );//= true
        System.out.println(OneEditApart("cat", "act")) ;//= false
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
