public class TestLinkedList {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        LinkedList.Node node1 = new LinkedList.Node(1);
        list.add(node1);
        LinkedList.Node node2 = new LinkedList.Node(2);
        list.add(node2);
        LinkedList.Node node3 = new LinkedList.Node(3);
        list.add(node3);
        LinkedList.Node node5 = new LinkedList.Node(5);
        list.add(node5);
        System.out.println(list.toString());
        LinkedList.Node node4 = new LinkedList.Node(4);
        list.insert(node4, 4);
        System.out.println(list.toString());
        LinkedList.Node node = list.remove();
        System.out.println(node.getNodeVal());
        list.insert(node, 1);
        System.out.println(list.toString());
        System.out.println(list.removeAt(2));
        System.out.println(list.toString());
        list.insert(node2, 2);
        System.out.println(list.toString());
        System.out.println(list.get(3));
        System.out.println(list.find(4));
    }
}
