package input.components.point;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class PointNodeDataBaseTest {



	@Test
	void testPointNodeDatabaseList() {
		ArrayList<PointNode> list = new ArrayList<>();
		for (int i =0; i < 500; i++ ) {
			PointNode node = new PointNode(i,i);
			list.add(node);
		}
		PointNodeDatabase testDB= new PointNodeDatabase(list);
		for (int i =0; i < 500; i++ ) {
			assertTrue(testDB.contains(i, i));
		}
	}
	@Test
	void testPut() {
		PointNodeDatabase testDB= new PointNodeDatabase();
		PointNode node = new PointNode(10,10);
		PointNode node2 = new PointNode(0,0);
		testDB.put(node);
		assertTrue(testDB.contains(node));
		assertTrue(testDB.contains(10, 10));
		assertFalse(testDB.contains(node2));
		assertFalse(testDB.contains(0, 0));


	}
	@Test
	void testGetName() {
		PointNodeDatabase testDB= new PointNodeDatabase();
		PointNode node = new PointNode("New Node",0,0);
		PointNode node2 = new PointNode(1,1);
		testDB.put(node);
		testDB.put(node2);

		assertEquals(testDB.getName(node), "New Node");
		assertEquals(testDB.getName(node2), "__UNNAMED");
		assertEquals(testDB.getName(0, 0), "New Node");
		assertEquals(testDB.getName(1, 1), "__UNNAMED");

	}
	@Test
	void testGetPoint() {
		PointNodeDatabase testDB= new PointNodeDatabase();
		PointNode node = new PointNode("New Node",0,0);
		PointNode node2 = new PointNode(1,1);
		testDB.put(node);
		testDB.put(node2);

		assertEquals(testDB.getPoint(node),node);
		assertEquals(testDB.getPoint(0, 0),node);
		assertEquals(testDB.getPoint(node2),node2);
		assertEquals(testDB.getPoint(1,1), node2);

	}

}
