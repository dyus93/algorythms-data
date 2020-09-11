package Graph;


import Queue.Queue;
import Stack.StackX;

public class Graph {
    private class Vertex{
        char label;
        boolean wasVisited;
        Vertex parent;

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

    public void showVertex(int vertex){
        System.out.println(vertexList[vertex] + "-> ");
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

    public Queue widthTraversPath(char from, char to){
        int start = getIndex(from);
        int stop = getIndex(to);

        Queue queue = new Queue(MAX_VERTICES);
        vertexList[start].wasVisited = true;
        queue.insert(start);
        boolean done = false;
        while (!queue.isEmpty()){
            int v1 =queue.remove();
            int v2;
            while ((v2 = getUnvisitedVertex(v1)) != 1){
                vertexList[v2].wasVisited = true;

                if (v2 == stop){
                    done = true;
                    break;
                }
                queue.insert(v2);
            }
        }
        resetFlags();
        if (done)
            return queue;
        else
            return null;
    }

    private int getIndex(char c){
        for (int i = 0; i < vertexList.length ; i++) {
            if (vertexList[i].label == c)
                return i;
        }
        return -1;
    }

    StackX shortWay(char from, char to){                // граф не взвешен
        StackX result = new StackX(MAX_VERTICES);
        Queue queue = new Queue(MAX_VERTICES);

        int start = getIndex(from);
        int stop = getIndex(to);
        if (start == -1 || stop == -1 || start == stop)
            return null;

        vertexList[start].wasVisited = true;
        queue.insert(start);
        while (!queue.isEmpty()){                        // ищем узел, помечаем родителя
            int vCur = queue.remove();
            int vNxt;
            while ((vNxt = getUnvisitedVertex(vCur)) != 1){
                vertexList[vNxt].parent = vertexList[vCur];
                vertexList[vNxt].wasVisited = true;
                if (vNxt == stop) break;
                queue.insert(vNxt);
            }
            if (vNxt == stop) break;
        }
        if (!vertexList[stop].wasVisited) return null;

        result.push(vertexList[stop].label);
        int current = stop;
        while (vertexList[current].parent != null)        // идем обратно к старту по родителям
            for (int i = 0; i <vertexList.length ; i++) {
                if (vertexList[current].parent == vertexList[i]){
                    result.push(vertexList[i].label);
                    current = i;
                    break;
                }
            }
        for (int i = 0; i < size; i++) {
            vertexList[i].wasVisited = false;
            vertexList[i].parent =null;
        }
            return null;
    }
}
