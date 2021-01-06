package org.acme.graph;

import org.acme.graph.model.Graph;
import org.acme.graph.model.Vertex;

import com.vividsolutions.jts.geom.Coordinate;

public class TestGraphFactory {

	/**   
	 *    d
	 *   / 
	 *  / 
	 * a--b--c
	 * 
	 * @return
	 */
	public static Graph createGraph01(){
		Graph graph = new Graph();
		
		Vertex a = graph.createVertex(new Coordinate(0.0, 0.0),"a");
		Vertex b = graph.createVertex(new Coordinate(1.0, 0.0),"b");
		graph.createEdge(a,b,"ab");
		
		Vertex c = graph.createVertex(new Coordinate(2.0, 0.0),"c");
		graph.createEdge(b,c,"ab");
		
		Vertex d = graph.createVertex(new Coordinate(1.0, 1.0),"d");
		graph.createEdge(a,d,"ab");
		
		return graph;
	}

	
}
