package org.acme.graph.model;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import com.vividsolutions.jts.geom.Coordinate;

public class EdgesTest {

	@Test
	public void testInOutEdges() {
		Graph graph = new Graph();
		
		Vertex a = graph.createVertex(new Coordinate(0.0, 0.0), "a");
		Vertex b = graph.createVertex(new Coordinate(1.0, 0.0), "b");
		Edge ab = graph.createEdge(a, b, "ab");
		
		Collection<Edge> outEdge = a.getOutEdges();
		Collection<Edge> inEdge = b.getInEdges();
		
		Object[] outEdges = outEdge.toArray();
		Object[] inEdges = inEdge.toArray();

		Assert.assertEquals(outEdges[0], ab);
		Assert.assertEquals(inEdges[0], ab);
	}

}
