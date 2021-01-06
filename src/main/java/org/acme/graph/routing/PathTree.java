package org.acme.graph.routing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.acme.graph.model.Edge;
import org.acme.graph.model.Graph;
import org.acme.graph.model.Path;
import org.acme.graph.model.Vertex;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PathTree {
	
	private static final Logger log = LogManager.getLogger(PathTree.class);

	private Map <Vertex, PathNode> nodes = new HashMap<Vertex, PathNode>();
	
	/**
	 * Prépare le graphe pour le calcul du plus court chemin
	 * 
	 * @param source
	 */
	public PathTree(Graph graph, Vertex source) {
		log.trace("initGraph({})", source);
		for (Vertex vertex : graph.getVertices()) {
			
			PathNode pathNode = new PathNode();
			pathNode.setCost(source == vertex ? 0.0 : Double.POSITIVE_INFINITY);
			pathNode.setReachingEdge(null);
			pathNode.setVisited(false);
			nodes.put(vertex, pathNode);
		}
	};
	
	/**
	 * Construit le chemin en remontant les relations incoming edge
	 * 
	 * @param target
	 * @return
	 */
	Path getPath(Vertex target) {
		List<Edge> result = new ArrayList<Edge>();

		Edge current = getNode(target).getReachingEdge();
		do {
			result.add(current);
			current = getNode(current.getSource()).getReachingEdge();
		} while (current != null);

		Collections.reverse(result);
		Path path = new Path(result);
		return path;
	}
	
	public PathNode getNode(Vertex vertex) {
		return nodes.get(vertex);
	};

}
