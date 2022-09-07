package input.components.segment;

import input.components.point.PointNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test SegmentNodeDatabase.
 *
 * @author brycenaddison
 * @date Wed Sep 7 2022
 */
class SegmentNodeDatabaseTest {
    public SegmentNodeDatabase build() {
        //      A
        //     / \
        //    B___C
        //   / \ / \
        //  /   X   \
        // D_________E
        //
        //
        PointNode a = new PointNode("A", 3, 6);
        PointNode b = new PointNode("B", 2, 4);
        PointNode c = new PointNode("C", 4, 4);

        PointNode d = new PointNode("D", 0, 0);
        PointNode e = new PointNode("E", 6, 0);
        PointNode x = new PointNode("X", 3, 3);

        SegmentNodeDatabase db = new SegmentNodeDatabase();

        db.addUndirectedEdge(a, b);
        db.addUndirectedEdge(a, c);
        db.addUndirectedEdge(b, c);
        db.addUndirectedEdge(b, x);
        db.addUndirectedEdge(b, d);
        db.addUndirectedEdge(c, x);
        db.addUndirectedEdge(c, e);
        db.addUndirectedEdge(x, d);
        db.addUndirectedEdge(x, e);
        db.addUndirectedEdge(d, e);

        return db;
    }

    @Test
    void testNumUndirectedEdges() {
        SegmentNodeDatabase db = build();

        assertEquals(10, db.numUndirectedEdges());
    }

    @Test
    void testAddAdjacencyList() {
        PointNode d = new PointNode("D", 0, 0);
        PointNode e = new PointNode("E", 6, 0);
        PointNode x = new PointNode("X", 3, 3);
        PointNode f = new PointNode("F", 5, 5);
        ArrayList<PointNode> adjList = new ArrayList<>();
        adjList.add(d);
        adjList.add(e);
        adjList.add(x);
        SegmentNodeDatabase db = build();
        db.addAdjacencyList(f, adjList);
        assertEquals(13, db.numUndirectedEdges());
        db.addAdjacencyList(f, adjList);
        assertEquals(13, db.numUndirectedEdges());
    }

    @Test
    void testAsSegmentList() {
        SegmentNodeDatabase db = build();
        ArrayList<SegmentNode> list = new ArrayList<>(db.asSegmentList());

        PointNode a = new PointNode("A", 3, 6);
        PointNode b = new PointNode("B", 2, 4);
        PointNode c = new PointNode("C", 4, 4);
        PointNode d = new PointNode("D", 0, 0);
        PointNode e = new PointNode("E", 6, 0);
        PointNode x = new PointNode("X", 3, 3);

        ArrayList<SegmentNode> testList = new ArrayList<>();
        testList.add(new SegmentNode(a, b));
        testList.add(new SegmentNode(a, c));
        testList.add(new SegmentNode(b, c));
        testList.add(new SegmentNode(b, x));
        testList.add(new SegmentNode(b, d));
        testList.add(new SegmentNode(c, x));
        testList.add(new SegmentNode(c, e));
        testList.add(new SegmentNode(x, d));
        testList.add(new SegmentNode(x, e));
        testList.add(new SegmentNode(d, e));

        assertEquals(testList.size() * 2, list.size());
        for (SegmentNode n : testList) {
            assertTrue(list.contains(n));
        }

        db.addUndirectedEdge(a, x);
        testList.add(new SegmentNode(x, a));

        list = new ArrayList<>(db.asSegmentList());

        assertEquals(testList.size() * 2, list.size());
        for (SegmentNode n : testList) {
            assertTrue(list.contains(n));
        }
    }

    @Test
    void testAsUniqueSegmentList() {
        SegmentNodeDatabase db = build();
        ArrayList<SegmentNode> list = new ArrayList<>(db.asUniqueSegmentList());

        PointNode a = new PointNode("A", 3, 6);
        PointNode b = new PointNode("B", 2, 4);
        PointNode c = new PointNode("C", 4, 4);
        PointNode d = new PointNode("D", 0, 0);
        PointNode e = new PointNode("E", 6, 0);
        PointNode x = new PointNode("X", 3, 3);

        ArrayList<SegmentNode> testList = new ArrayList<>();
        testList.add(new SegmentNode(a, b));
        testList.add(new SegmentNode(a, c));
        testList.add(new SegmentNode(b, c));
        testList.add(new SegmentNode(b, x));
        testList.add(new SegmentNode(b, d));
        testList.add(new SegmentNode(c, x));
        testList.add(new SegmentNode(c, e));
        testList.add(new SegmentNode(x, d));
        testList.add(new SegmentNode(x, e));
        testList.add(new SegmentNode(d, e));

        assertEquals(testList.size(), list.size());
        for (SegmentNode n : testList) {
            assertTrue(list.contains(n));
        }

        db.addUndirectedEdge(a, x);
        testList.add(new SegmentNode(x, a));

        list = new ArrayList<>(db.asUniqueSegmentList());

        assertEquals(testList.size(), list.size());
        for (SegmentNode n : testList) {
            assertTrue(list.contains(n));
        }
    }
}
