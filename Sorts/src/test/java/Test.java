public class Test {

    public static void main(String[] args) {

        OneEditApart("cat", "dog") ;//= false
        OneEditApart("cat", "cats");// = true
        OneEditApart("cat", "cut") ;//= true
        OneEditApart("cat", "cast");// = true
        OneEditApart("cat", "at") ;//= true
        OneEditApart("cat", "act") ;//= false
    }

}

