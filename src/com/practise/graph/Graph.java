package com.practise.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    private ArrayList<String> vertexList; //store vertex collection
    private int[][] edges; //store adjacency matrix
    private int edgesNum; //Number of storage edges
    private boolean[] isVisited; //Whether the vertex has been visited

    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        edgesNum = 0;
    }

    public void insertEdges(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        edgesNum++;
    }

    public void showGraph() {
        for (int[] arr : edges) {
            System.out.println(Arrays.toString(arr));
        }
    }

    //Insert vertex
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    // Get the index of the first adjacent node
    public int getFirstNeighbor(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    // Get the next adjacent node according to the subscript of the previous adjacent node
    public int getNextNeighbor(int v1, int v2) {
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    //Return the data corresponding to vertex i
    public String getValue(int index) {
        return vertexList.get(index);
    }


    //Breadth first traversal
    public void bfs(boolean[] isVisited, int i) {
        int u; //Get the head node of the queue
        int w; //Get the adjacent node of the queue head node
        LinkedList<Integer> queue = new LinkedList<Integer>(); //Queue
        System.out.print(getValue(i) + " --> ");
        isVisited[i] = true;
        //Add the node to the queue
        queue.addLast(i);
        while (!queue.isEmpty()) {
            //When the queue is not empty, remove the head node of the queue
            u = queue.removeFirst();
            w = getFirstNeighbor(u);
            while (w != -1) {
                if (!isVisited[w]) {
                    //The node has not been visited
                    System.out.print(getValue(w) + " --> ");
                    isVisited[w] = true;
                    //Add adjacent nodes to the queue
                    queue.addLast(w);
                }
                //The adjacent node has been visited
                w = getNextNeighbor(u, w);
            }
        }
    }


    public static void main(String[] args) {
        int n = 5; //Number of vertices
        String[] Vertex = {"A", "B", "C", "D", "E"};
        Graph graph = new Graph(n);
        for (String vertex : Vertex) {
            graph.insertVertex(vertex);
        }
        //A-B A-C B-C B-E C-D D-E
        graph.insertEdges(0, 1, 1);
        graph.insertEdges(0, 2, 1);
        graph.insertEdges(1, 2, 1);
        graph.insertEdges(1, 4, 1);
        graph.insertEdges(2, 3, 1);
        graph.insertEdges(3, 4, 1);
        graph.showGraph();
        graph.bfs(graph.isVisited,0);
    }
}
