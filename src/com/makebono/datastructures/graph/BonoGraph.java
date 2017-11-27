package com.makebono.datastructures.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import com.makebono.datastructures.graph.graphInterface.Graph;
import com.makebono.datastructures.tools.graphcomparator.GraphComparator;

/** 
 * @ClassName: BonoGraph 
 * @Description: Graph implementation. Normally, this would be a undirected graph, which means Edge(v1,v2) is considered same as Edge(v2,v1).
 * But if it is used as a flow network. This become directed. This is for Ford-Fulkerson method uses.
 * Minimum spanning tree generation is applying Kruskal's algorithm. Which is a straight forward greedy algorithm.
 * @author makebono
 * @date 2017年11月10日 上午11:34:29 
 *  
 */
public class BonoGraph<T> implements Graph<T> {
    private final ArrayList<Vertex<T>> vertices;

    // A record for edges may seems redundant but, it is easier to generate a minimum spanning tree by directly
    // pop next choice greedily from a priority queue of edges.
    // What I've done in the A* graph only used nodes to collect edges. Because in that situation, we don't need to
    // compare weights through all the data structure.
    private final Queue<Edge<T>> edges;
    private final Comparator<Edge<T>> sideKick = new GraphComparator<T>();
    private boolean isMST;
    private Vertex<T> source;
    private Vertex<T> sink;

    public BonoGraph() {
        this.vertices = new ArrayList<Vertex<T>>();
        this.edges = new PriorityQueue<Edge<T>>(this.sideKick);
        this.isMST = false;
        this.source = null;
        this.sink = null;
    }

    @Override
    public int size() {
        return this.vertices.size();
    }

    private void setMST() {
        this.isMST = true;
    }

    // Simply add vertex into graph.
    @Override
    public void add(final Vertex<T> vertex) {
        boolean vertexFlag = false;
        for (final Vertex<T> temp : this.getVertices()) {
            if (vertex.getIndex() == temp.getIndex()) {
                vertexFlag = true;
            }
        }

        if (!vertexFlag) {
            this.vertices.add(vertex);
        }
    }

    // Add edge into graph.
    @Override
    public void add(final Vertex<T> v1, final Vertex<T> v2) {
        final Edge<T> edge = new Edge<T>(v1, v2);
        boolean v1Flag = false;
        boolean v2Flag = false;

        // Scan through the record of vertices to see if need to add v1 and v2 in the graph.
        for (final Vertex<T> temp : this.getVertices()) {
            if (temp.getIndex() == v1.getIndex()) {
                v1Flag = true;
            }
            if (temp.getIndex() == v2.getIndex()) {
                v2Flag = true;
            }
        }

        if (!v1Flag) {
            this.vertices.add(v1);
        }

        if (!v2Flag) {
            this.vertices.add(v2);
        }

        boolean edgeExist = false;

        // Treat Edge(v1,v2) and Edge(v2,v1) as the same in undirected graph.
        for (final Edge<T> temp : this.getEdges()) {
            if ((temp.getV1().getIndex() == edge.getV1().getIndex()
                    && temp.getV2().getIndex() == edge.getV2().getIndex())
                    || (temp.getV1().getIndex() == edge.getV2().getIndex()
                            && temp.getV2().getIndex() == edge.getV1().getIndex())) {
                edgeExist = true;
            }
        }

        if (!edgeExist) {
            this.edges.add(edge);
            v1.addEdge(edge);
        }
    }

    // Add edge into flow network
    @Override
    public void add(final Vertex<T> v1, final Vertex<T> v2, final int capacity, final int flow) {
        final Edge<T> edge = new Edge<T>(v1, v2, capacity, flow);
        boolean v1Flag = false;
        boolean v2Flag = false;

        // Scan through the record of vertices to see if need to add v1 and v2 in the graph.
        for (final Vertex<T> temp : this.getVertices()) {
            if (temp.getIndex() == v1.getIndex()) {
                v1Flag = true;
            }
            if (temp.getIndex() == v2.getIndex()) {
                v2Flag = true;
            }
        }

        if (!v1Flag) {
            this.vertices.add(v1);
        }

        if (!v2Flag) {
            this.vertices.add(v2);
        }

        boolean edgeExist = false;

        // Directed graph for Ford-Fulkerson method.
        for (final Edge<T> temp : this.getEdges()) {
            if ((temp.getV1().getIndex() == edge.getV1().getIndex()
                    && temp.getV2().getIndex() == edge.getV2().getIndex())) {
                edgeExist = true;
            }
        }

        if (!edgeExist) {
            this.edges.add(edge);
            v1.addEdge(edge);
        }
    }

    @Override
    public void del(final Vertex<T> v1, final Vertex<T> v2) {
        // Delete the record of edge hold in vertex first.
        for (final Edge<T> temp : v1.getEdges()) {
            if ((temp.getV1().getIndex() == v1.getIndex() && temp.getV2().getIndex() == v2.getIndex())
                    || (temp.getV1().getIndex() == v2.getIndex() && temp.getV2().getIndex() == v1.getIndex())) {
                v1.getEdges().remove(temp);
                break;
            }
        }

        for (final Edge<T> temp : v2.getEdges()) {
            if ((temp.getV1().getIndex() == v1.getIndex() && temp.getV2().getIndex() == v2.getIndex())
                    || (temp.getV1().getIndex() == v2.getIndex() && temp.getV2().getIndex() == v1.getIndex())) {
                v2.getEdges().remove(temp);
                break;
            }
        }

        // And then delete the record of edge hold in graph.
        // For convenience, clear the vertices record and then add them back when adding the edges. Because it's not
        // safe to directly remove the vertices since there maybe other edges contain them.
        this.vertices.clear();
        for (final Edge<T> temp : this.getEdges()) {
            if ((temp.getV1().getIndex() == v1.getIndex() && temp.getV2().getIndex() == v2.getIndex())
                    || (temp.getV1().getIndex() == v2.getIndex() && temp.getV2().getIndex() == v1.getIndex())) {
                // System.out.println("boo!");
                this.edges.remove(temp);
                break;
            }

            final Vertex<T> tempV1 = temp.getV1();
            final Vertex<T> tempV2 = temp.getV2();

            if (!this.vertices.contains(tempV1)) {
                this.vertices.add(tempV1);
            }
            if (!this.vertices.contains(tempV2)) {
                this.vertices.add(tempV2);
            }
        }
    }

    @Override
    public Queue<Edge<T>> getEdges() {
        return this.edges;
    }

    @Override
    public ArrayList<Vertex<T>> getVertices() {
        return this.vertices;
    }

    // DFS mainly for detecting cycle in graph. I create a side kicker container class for its return. Includes a
    // boolean flag indicating if it has cycle, and then array list for the vertices visited through the search.
    @Override
    public SearchResult<T> dfs() {
        final ArrayList<Vertex<T>> visited = new ArrayList<Vertex<T>>();
        boolean cycle = false;
        final Stack<Vertex<T>> temp = new Stack<Vertex<T>>();

        // Use the information holds in vertex to do the traversal. Because edge queue in graph is only for help
        // generating MST, it doesn't mean much for graph search.
        temp.add(this.getVertices().get(0));

        Vertex<T> buffer;

        while (!temp.isEmpty()) {
            buffer = temp.pop();
            // System.out.println(buffer);
            final int tempSize = visited.size();
            boolean contains = false;

            // See if this position is already visited.
            for (int i = 0; i < tempSize; i++) {
                if (buffer.getIndex() == visited.get(i).getIndex()) {
                    contains = true;
                    break;
                }
            }

            if (!contains) {
                // System.out.println("count");
                visited.add(buffer);

                for (int i = buffer.getEdges().size() - 1; i >= 0; i--) {
                    temp.add(buffer.getEdges().get(i).getV2());
                }

            } else {
                // System.out.println("don't count");
                cycle = true;
            }
        }

        return new SearchResult<T>(cycle, visited);
    }

    // BFS path search here is for Ford-Fulkerson method. Return the first legit path found, not looking for a specific
    // path like shortest path, etc.
    @Override
    public SearchResult<T> bfsPath() {
        // Table for mapping child vertex to parent vertex, help backtracking to generating path. I used parent Vertex
        // hold in vertices at first but if using it, everytime call a BFS needs to traverse all verices and reset their
        // parent to null. This will create unnecessary complexity, thus using a temporary hashmap seems more making
        // sense.
        final HashMap<Vertex<T>, Vertex<T>> parentMap = new HashMap<Vertex<T>, Vertex<T>>();
        // System.out.println("BFS called.");

        // For containing result. Will be in reverted order.
        final ArrayList<Vertex<T>> result = new ArrayList<Vertex<T>>();
        boolean cycle = false;
        final Queue<Vertex<T>> temp = new LinkedList<Vertex<T>>();
        temp.add(this.getSource());
        Vertex<T> buffer;

        while (!temp.isEmpty()) {
            buffer = temp.poll();
            for (final Edge<T> nextEdge : buffer.getEdges()) {
                final Vertex<T> nextVertex = nextEdge.getV2();

                // If residual capacity <= 0, this vertex is no more available. If parent of this vertex is already
                // assigned, it's been visited so a cycle is detected.
                if (nextEdge.getResidualCapacity() > 0 && parentMap.get(nextVertex) == null) {
                    parentMap.put(nextVertex, buffer);

                    if (nextVertex.getIndex() != this.sink.getIndex()) {
                        temp.add(nextVertex);
                    } else {
                        Vertex<T> backtrackCursor = parentMap.get(nextVertex);
                        result.add(nextVertex);
                        result.add(backtrackCursor);

                        while (parentMap.get(backtrackCursor) != null) {
                            backtrackCursor = parentMap.get(backtrackCursor);
                            result.add(backtrackCursor);
                        }
                    }
                } else {
                    cycle = true;
                }
            }
        }

        // Result is in reverted order because of the back tracking
        final ArrayList<Vertex<T>> resultByOrder = new ArrayList<Vertex<T>>();

        for (int i = result.size() - 1; i != -1; i--) {
            resultByOrder.add(result.get(i));
        }

        return new SearchResult<T>(cycle, resultByOrder);
    }

    // Kruskal's algorithm, greedily pick next smallest weighted edges to complete a MST, ignore edges causing cycle.
    @Override
    public BonoGraph<T> MST() {
        final BonoGraph<T> mst = new BonoGraph<T>();
        final ArrayList<Edge<T>> temp = new ArrayList<Edge<T>>();

        // I used mst.add(new Vertex v1, new Vertex v2) here at first and messed up. You need to create new,
        // non-temporary vertices. If using the exsisting vertices in graph, edges information held by them will trigger
        // errors. And they cannot be cleared since you don't want a changing in the original data as side affect of
        // generating MST. And a new instance won't hold the edge information needed later for scanning cycle. So I
        // wrote a method doing "clean clone" (means only copy the basic informations except the edges) generating
        // a clean copy of vertices from original graph.
        final ArrayList<Vertex<T>> newVertices = this.cloneCleanVertices();

        Edge<T> buffer = this.edges.poll();

        Vertex<T> tempV1 = newVertices.get(buffer.getV1().getIndex() - 1);
        Vertex<T> tempV2 = newVertices.get(buffer.getV2().getIndex() - 1);

        mst.add(tempV1, tempV2);
        temp.add(buffer);

        while (mst.getEdges().size() != this.size() - 1) {
            buffer = this.edges.poll();
            // System.out.println("V1: " + buffer.getV1() + " V2: " + buffer.getV2());

            tempV1 = newVertices.get(buffer.getV1().getIndex() - 1);
            tempV2 = newVertices.get(buffer.getV2().getIndex() - 1);

            mst.add(tempV1, tempV2);
            temp.add(buffer);

            // Directly add new edge in the subgraph, then double check if this adding manipulation caused cycle. If
            // there is cycle, delete the new added edge.
            if (mst.cycleDetection()) {
                // System.out.println("boo!");
                mst.del(tempV1, tempV2);;
                // System.out.println("V1: " + buffer.getV1() + " V2: " + buffer.getV2());
            }

        }

        // Add polled edges back.
        this.edges.addAll(temp);
        mst.setMST();
        return mst;

    }

    @Override
    public boolean cycleDetection() {
        return this.dfs().cycle();
    }

    private ArrayList<Vertex<T>> cloneCleanVertices() {
        final ArrayList<Vertex<T>> temp = new ArrayList<Vertex<T>>();
        final ArrayList<Vertex<T>> result = new ArrayList<Vertex<T>>();

        // Order of vertices depends on when you inserted it. But I'm using ArrayList index to access them, so a
        // temporary ArrayList used here for map the vertices to right order.
        // What I want to see is result.get(1) = Vertex(1). And this means when deploying this graph, the input vertices
        // don't need to be in order but must be complete. For example v1 v2 v3 v4 v6 v5 is acceptable but v1 v2 v3 v5
        // is not acceptable.
        for (int i = 0; i < this.size(); i++) {
            temp.add(new Vertex<T>(this.getVertices().get(i)));
            result.add(new Vertex<T>(this.getVertices().get(i)));
        }

        for (final Vertex<T> vertex : temp) {
            result.set(vertex.getIndex() - 1, vertex);
        }

        return result;
    }

    @Override
    public void setSource(final Vertex<T> source) {
        this.source = source;
        final Vertex<T> temp = this.vertices.get(0);
        final int index = this.vertices.indexOf(source);
        this.vertices.set(0, this.source);
        this.vertices.set(index, temp);
    }

    @Override
    public void setSink(final Vertex<T> sink) {
        this.sink = sink;
        final Vertex<T> temp = this.vertices.get(this.vertices.size() - 1);
        final int index = this.vertices.indexOf(sink);
        this.vertices.set(this.vertices.size() - 1, this.sink);
        this.vertices.set(index, temp);
    }

    @Override
    public Vertex<T> getSource() {
        return this.source;
    }

    @Override
    public Vertex<T> getSink() {
        return this.sink;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        if (this.size() == 0) {
            sb.append("This is an empty graph.");
        } else {
            sb.append("This is a " + this.getClass().getName());
            if (this.isMST) {
                sb.append("\nThis is a minimum spanning tree");
            }
            sb.append(".\n\nIt has " + this.size() + " vertices, with " + this.getEdges().size()
                    + " edges.\nVertices:\n");

            for (final Vertex<T> temp : this.getVertices()) {
                sb.append("Vertex(" + temp.getIndex() + ", " + temp.getData() + ", " + temp.getX() + ", " + temp.getY()
                        + ") ");
            }
            sb.append("\n\nEdges:\n");
            for (final Edge<T> temp : this.getEdges()) {
                sb.append("Edge(V" + temp.getV1().getIndex() + ", V" + temp.getV2().getIndex() + ") ");
            }
        }

        return sb.toString();
    }
}