package org.acme.graph.model;

import java.util.ArrayList;
import java.util.List;

import com.vividsolutions.jts.geom.Coordinate;

/**
 * 
 * Un graphe matérialisé par une liste de sommets et d'arcs
 * 
 * @author MBorne
 *
 */
public class Graph {
	/**
	 * Liste des sommets
	 */
	private List<Vertex> vertices = new ArrayList<Vertex>();

	/**
	 * Liste des arcs
	 */
	private List<Edge> edges = new ArrayList<Edge>();
	
	/**
	 * Fabrique de Vertex
	 * 
	 * @return
	 */
	public Vertex createVertex(Coordinate coordinate, String id) {
		assert(coordinate != null);
		Vertex vertice = new Vertex();
		vertice.setId(id);
		vertice.setCoordinate(coordinate);
		this.vertices.add(vertice);
		return vertice;
	}
	
	/**
	 * Fabrique d'Edge
	 * 
	 * @return
	 */
	public Edge createEdge(Vertex source, Vertex target, String id) {
		assert(source != null && target != null);
		Edge edge = new Edge(source, target);
		edge.setId(id);
		this.edges.add(edge);
		return edge;
	}
	
	/**
	 * Récupération de la liste sommets
	 * 
	 * @return
	 */
	public List<Vertex> getVertices() {
		return vertices;
	}

	/**
	 * Recherche d'un sommet par identifiant
	 * 
	 * @param id
	 * @return
	 */
	public Vertex findVertex(String id) {
		for (Vertex vertex : vertices) {
			if (vertex.getId().equals(id)) {
				return vertex;
			}
		}
		return null;
	}

	/**
	 * Recherche d'un sommet par coordonnées
	 * 
	 * @param coordinate
	 * @return
	 */
	public Vertex findVertex(Coordinate coordinate) {
		for (Vertex vertex : vertices) {
			Coordinate candidate = vertex.getCoordinate();
			if (candidate != null && candidate.equals(coordinate)) {
				return vertex;
			}
		}
		return null;
	}

	/**
	 * Récupération de la liste des arcs
	 * 
	 * @return
	 */
	public List<Edge> getEdges() {
		return edges;
	}

}
