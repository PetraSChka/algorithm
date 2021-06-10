package bsu.petraschka;

import bsu.petraschka.Classes.BfcGraph;
import bsu.petraschka.Classes.Graph;
import bsu.petraschka.printer.MatrixPrinter;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main extends JPanel {
    public static Graph graph;
    public static int[][] matrix = new int[0][0];

    public Main() {
        JFrame jFrame = new JFrame("Graphics");

        jFrame.setLocation(750, 150);
        jFrame.setMinimumSize(new Dimension(600, 600));
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jFrame.getContentPane().add(this);

        jFrame.pack();
        jFrame.setVisible(true);
    }

    public static void main(String[] args) throws InterruptedException {
//http://graphonline.ru/?graph=hEmbeYQfSlBKIHQm
        int[][] adjOne = {
                //1 2  3  4  5  6  7
                {0, 0, 1, 1, 1, 0, 0}, // 1
                {0, 0, 0, 0, 0, 1, 1}, // 2
                {1, 0, 0, 0, 0, 0, 1}, // 3
                {1, 0, 0, 0, 1, 1, 0}, // 4
                {1, 0, 0, 1, 0, 0, 1}, // 5
                {0, 1, 0, 1, 0, 0, 0}, // 6
                {0, 1, 1, 0, 1, 0, 0}  // 7
        };
        System.out.println("\n111111111111111111111111:");
        Graph graph = new Graph(adjOne, adjOne.length);
        graph.printGraph();
        System.out.println("\nIncidence matrix:");
        MatrixPrinter.printMatrix(graph.writeIncidenceMatrix());
        System.out.println("\nAdjacency matrix:");
        MatrixPrinter.printMatrix(graph.writeAdjacencyMatrix());
        System.out.println("\nAdjacency list:");
        MatrixPrinter.printMatrix(graph.writeAdjacencyList());

        System.out.println("\nGreedy coloring");
        graph.greedyColoring(graph.writeAdjacencyList());

        System.out.println("\nColoring by manipulating rows in adjacency list");
        graph.coloringByManipulatingRows(graph.writeAdjacencyMatrix());


        int[][] adjTwo = {
//http://http://graphonline.ru/?graph=GfEMeQtLErywjtYj
                //1 2  3  4  5  6  7
                {0, 0, 1, 1, 1, 0, 0}, // 1
                {0, 0, 0, 0, 0, 1, 1}, // 2
                {1, 0, 0, 0, 0, 0, 1}, // 3
                {1, 0, 0, 0, 1, 1, 0}, // 4
                {1, 0, 0, 1, 0, 0, 1}, // 5
                {0, 1, 0, 1, 0, 0, 0}, // 6
                {0, 1, 1, 0, 1, 0, 0}  // 7
        };
        System.out.println("\n2222222222222222222222222222:");
        Graph graphTwo = new Graph(adjTwo, adjTwo.length);
        graphTwo.printGraph();
        System.out.println("Incidence matrix:");
        MatrixPrinter.printMatrix(graphTwo.writeIncidenceMatrix());
        System.out.println("\nAdjacency matrix:");
        MatrixPrinter.printMatrix(graphTwo.writeAdjacencyMatrix());
        System.out.println("\nAdjacency list:");
        MatrixPrinter.printMatrix(graphTwo.writeAdjacencyList());

        BfcGraph bfcGraph = new BfcGraph();
        bfcGraph.addVertex('0');bfcGraph.addVertex('1');bfcGraph.addVertex('2');bfcGraph.addVertex('3');bfcGraph.addVertex('4');bfcGraph.addVertex('5');bfcGraph.addVertex('6');bfcGraph.addEdge(0,2);bfcGraph.addEdge(0,3);bfcGraph.addEdge(0,4);bfcGraph.addEdge(1,5);bfcGraph.addEdge(1,6);bfcGraph.addEdge(2,6);bfcGraph.addEdge(3,4);bfcGraph.addEdge(3,5);bfcGraph.addEdge(4,6);

        System.out.println("\nDepth first search");
        int indexVertexDFS = 2;
        graphTwo.depthFirstSearch(graphTwo.writeAdjacencyList(), indexVertexDFS);


        System.out.println("\nBreadth first search");
        int indexVertexBFS = 0;
        bfcGraph.bfc();
        graphTwo.breadthFirstSearch(graphTwo.writeAdjacencyList(), indexVertexBFS);

//http://graphonline.ru/?graph=SlGhpQXBFwgJxmHZ
        int[][] adjThree = {
                //a b  c  d
                {0, 1, 1, 1}, // a
                {1, 0, 1, 0}, // b
                {1, 1, 0, 1}, // c
                {1, 0, 1, 0}  // d
        };
        System.out.println("\n33333333333333333333333333333333:");
        Graph graphThree = new Graph(adjThree, adjThree.length);

        System.out.println("Edge coloring");
        graphThree.edgeColoring(graphThree.getEdges());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int[] coordsX = new int[matrix.length];
        int[] coordsY = new int[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            coordsX[i] = new Random().nextInt(300);
            coordsY[i] = new Random().nextInt(300);
        }

        for (int i = 0; i < matrix.length; i++) {
            g.setColor(Color.BLACK);
            g.drawString(Character.toString(graph.getVertices()[i].getName()), coordsX[i] + 20, coordsY[i] + 20);
            g.fillOval(coordsX[i], coordsY[i], 10, 10);
        }

        g.setColor(Color.RED);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 1) {
                    g.drawLine(coordsX[i] + 5, coordsY[i] + 5, coordsX[j] + 5, coordsY[j] + 5);
                }
            }
        }
    }
}

