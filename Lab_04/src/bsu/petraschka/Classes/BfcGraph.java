package bsu.petraschka.Classes;

import java.util.PriorityQueue;
import java.util.Queue;

public class BfcGraph {
    private final int MAX_VERTS = 10;
    private Vertex2 vertexList[]; //массив вершин
    private int adjMat[][]; // матрица смежности
    private int nVerts; // текущее количество вершин
    private Queue<Integer> queue;

    public BfcGraph() {
        vertexList = new Vertex2[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int j = 0; j < MAX_VERTS; j++) {
            for (int k = 0; k < MAX_VERTS; k++) {  // заполнение матрицы смежности нулями
                adjMat[j][k] = 0;
            }
        }
        queue = new PriorityQueue<>();
    }

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex2(lab);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.println(vertexList[v].getLabel());
    }

    public void bfc() { // обход в глубину
        vertexList[0].setWasVisited(true);
        displayVertex(0);
        queue.add(0);
        int v2;

        while (!queue.isEmpty()) {
            int v = queue.remove();

            while((v2 = getAdjUnvisitedVertex(v))!=-1) {// цикл будет работать, пока все смежные вершины не будут найденны, и не будут добавлены в очередь
                vertexList[v2].wasVisited =true;
                displayVertex(v2);
                queue.add(v2);
            }
        }

        for (int j = 0; j < nVerts; j++) {  // сброс флагов
            vertexList[j].wasVisited = false;
        }

    }

    private int getAdjUnvisitedVertex(int v) {
        for (int j = 0; j < nVerts; j++) {
            if (adjMat[v][j] == 1 && vertexList[j].wasVisited == false) {
                return j; //возвращает первую найденную вершину
            }
        }
        return -1;
    }
}