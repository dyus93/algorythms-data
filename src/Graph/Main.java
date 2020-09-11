package Graph;

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addVertex('a');
        g.addVertex('b');
        g.addVertex('c');
        g.addVertex('d');
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.depthTraverse();
    }
}
