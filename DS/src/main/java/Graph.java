import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
public class Graph {

    private HashMap<Integer, Node> nodeLookup = new HashMap<>();

    private Node getNode(int n){
        return nodeLookup.get(n);
    }

    public void addEdge(int source, int destination){
        Node sourceNode = nodeLookup.get(source);
        Node destinationNode = nodeLookup.get(destination);
        sourceNode.children.add(destinationNode);
    }

    public boolean hasPathDFS(int source, int destination){
        Node s = getNode(source);
        Node d = getNode(destination);
        HashSet<Integer> visited = new HashSet<>();
        return hasPathDFS(s, d, visited);
    }

    private boolean hasPathDFS(Node s, Node d, HashSet<Integer> visited) {
        if(visited.contains(s.id)){
            return false;
        }
        visited.add(s.id);
        if(s == d){
            return true;
        }
        for(Node node:s.children){
            if(hasPathDFS(node,d, visited))
                return true ;
        }

        return false;
    }

    public boolean hasPathBFS(int source, int destination){
        Node s = getNode(source);
        Node d = getNode(destination);
        LinkedList<Node> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.add(s);
        while(!queue.isEmpty()){
            Node node= queue.remove();
            if(node == d){
                return true;
            }
            if(visited.contains(node.id)){
                continue;
            }

            visited.add(node.id);
            for(Node child:node.children){
                queue.add(child);
            }
        }
        return false;
    }

    private class Node{
        int id;
        LinkedList<Node> children= new LinkedList<>();
        private Node(int id){
            this.id = id;
        }
    }

}
