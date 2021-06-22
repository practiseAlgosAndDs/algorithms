package com.practise.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class PractiseGraph {

    private int V;
    private LinkedList<Integer> adjList[];
    boolean visitedArr[]=new boolean[V];

    PractiseGraph(int v) {
        V=v;
        adjList = new LinkedList[v];
        for(int i=0;i<v;i++){
            adjList[i] = new LinkedList<>();
        }
    }

    private void addEdge(int src,int dest) {
        adjList[src].add(dest);
    }

    public void bfs(int s){
        boolean visited[]=new boolean[V];
        LinkedList<Integer> queue = new LinkedList();
        visited[s]=true;
        queue.add(s);
        while(queue.size()!=0){
            s=queue.poll();
            System.out.print(s + " ");
            Iterator<Integer> i = adjList[s].iterator();
            while(i.hasNext()) {
                int n = i.next();
                if(!visited[n]) {
                    visited[n]=true;
                    queue.add(n);
                }
            }
        }
    }

    public void dfs(int vertex){
        visitedArr[vertex]=true;
        System.out.println(vertex + " ");

        Iterator<Integer> ite= adjList[vertex].iterator();
        while(ite.hasNext()) {
            int n = ite.next();
            if(!visitedArr[n]){
                dfs(n);
            }
        }
    }

    void DFSUtil(int v, boolean visited[])
    {
        visited[v] = true;
        System.out.print(v + " ");

        Iterator<Integer> i = adjList[v].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    void DFS(int v)
    {
        boolean visited[] = new boolean[V];
        DFSUtil(v, visited);
    }

    public static void main(String[] args) {
       PractiseGraph graph = new PractiseGraph(4);
       graph.addEdge(0,1);
       graph.addEdge(0,2);
       graph.addEdge(1,2);
       graph.addEdge(2,0);
       graph.addEdge(2,3);
      // graph.addEdge(3,3);

       System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");
       graph.bfs(2);
        System.out.println(" ");
       System.out.println("Following is Depth First Traversal " + "(starting from vertex 2)");
       //graph.dfs(2);
        graph.DFS(0);
    }
}
