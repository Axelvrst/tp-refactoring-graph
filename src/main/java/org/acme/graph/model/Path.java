package org.acme.graph.model;

import java.util.ArrayList;
import java.util.List;

public class Path {
	
	private List<Edge> edges = new ArrayList<>();
	
	public Path() {
		this.edges = new ArrayList<Edge>();
	}
	
	public Path(List<Edge> edges) {
		this.edges = edges;
	}
	
	public List<Edge> getEdges(){
		return edges;
	}
	
	public int getPathSize() {
		return this.edges.size();
	}
	
	public Edge getEdgeIndex(int n) {
		return this.getEdges().get(n);
	}

}
