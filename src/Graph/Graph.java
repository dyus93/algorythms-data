package Graph;


import Queue.Queue;
import Stack.StackX;

public class Graph {
    private class Vertex{
        char label;
        boolean wasVisited;

        public Vertex(char label){
            this.label = label;
            this.wasVisited = false;
        }

        @Override
        public String toString(){
            return "Vertex{" +
                    "label=" + label +
                    '}';
        }
    }

    private final int MAX_VERTICES = 32;
    private Vertex[] vertexList;
    private int[][] adjMatrix;
    private int size;

    public Graph(){
        this.vertexList = new Vertex[MAX_VERTICES];
        this.adjMatrix = new int[MAX_VERTICES][MAX_VERTICES];
        this.size = 0;
    }

    public void addVertex(char label){
        vertexList[size++] = new Vertex(label);
    }

    public void addEdge(int start, int end){
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }

    public void displayVertex(int vertex){
        System.out.println(vertexList[vertex]);
    }

    private int getUnvisitedVertex(int ver){
        for (int i = 0; i < size; i++) {
            if (adjMatrix[ver][i] == 1 && !vertexList[i].wasVisited)
                return i;
        }
        return -1;
    }

//  Обход в глубину

    public void depthTraverse(){
        StackX stack = new StackX(MAX_VERTICES);
        vertexList[0].wasVisited = true;
        displayVertex(0);
        stack.push(0);
        while (!stack.isEmpty()){
            int v = getUnvisitedVertex(stack.peek());
            if (v == 1)
                stack.pop();
            else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                stack.push(v);
            }
        }
        resetFlags();
    }

    private void resetFlags(){
        for (int i = 0; i < size; i++) {
            vertexList[i].wasVisited = false;
        }
    }
//      Обход в ширину

    public void widthTravers(){
        Queue queue = new Queue(MAX_VERTICES);
        vertexList[0].wasVisited = true;
        displayVertex(0);
        queue.insert(0);
        while (!queue.isEmpty()){
            int vNext;
            int vCurrent = queue.remove();
            displayVertex(vCurrent);
            while (( vNext =  getUnvisitedVertex(vCurrent)) != -1){
                vertexList[vNext].wasVisited = true;
                displayVertex(vNext);
                queue.insert(vNext);
            }
        }
    }
}
