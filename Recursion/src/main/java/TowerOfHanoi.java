public class TowerOfHanoi {
    public static void toh(int n, char rodFrom, char midRod, char rodTo){
        if(n==1){
            System.out.println("Move 1 from "+ rodFrom+" to "+rodTo);
            return;
        }
        toh(n-1, rodFrom, rodTo, midRod);
        System.out.println("Move "+n+" from "+ rodFrom+" to "+rodTo);
        toh(n-1, midRod, rodFrom , rodTo);
    }

    public static void main(String[] args) {
        toh(5,'a', 'b', 'c');
    }
}
