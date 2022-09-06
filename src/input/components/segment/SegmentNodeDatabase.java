package input.components.segment;

import input.components.point.PointNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/**
 * Stores line segments as an adjacency list.
 * 
 * @author brycenaddison
 * @date Wed Aug 31 2022
 */
public class SegmentNodeDatabase {
    protected Map<PointNode, Set<PointNode>> _adjLists;

    public SegmentNodeDatabase() {
        this._adjLists = new HashMap<>();
    }

    public SegmentNodeDatabase(Map<PointNode, Set<PointNode>> adjLists) {
        this._adjLists = adjLists;
    }

    public int numUndirectedEdges() {
        int count = 0;
        for (Set<PointNode> adjList : this._adjLists.values()) {
            count += adjList.size();
        }
        return count / 2;
    }

    private void addDirectedEdge(PointNode a, PointNode b) {
        Set<PointNode> adjList = this._adjLists.computeIfAbsent(a, k -> new HashSet<>());
        adjList.add(b);
    }

    public void addUndirectedEdge(PointNode a, PointNode b) {
        this.addDirectedEdge(a, b);
        this.addDirectedEdge(b, a);
    }

    public void addAdjacencyList(PointNode p, List<PointNode> list) {
        for (PointNode q : list) {
            this.addUndirectedEdge(p, q);
        }
    }

    public List<SegmentNode> asSegmentList() {
        ArrayList<SegmentNode> list = new ArrayList<>();
        for (Entry<PointNode, Set<PointNode>> entry : this._adjLists.entrySet()) {
            PointNode a = entry.getKey();
            for (PointNode b : entry.getValue()) {
                list.add(new SegmentNode(a, b));

            }
        }
        return list;
    }

    public List<SegmentNode> asUniqueSegmentList() {
        Set<SegmentNode> set = new HashSet<>(this.asSegmentList());
        return new ArrayList<>(set);
    }
}
