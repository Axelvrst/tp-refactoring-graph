package org.acme.graph.model;

import com.bedatadriven.jackson.datatype.jts.serialization.GeometrySerializer;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineString;

/**
 * 
 * Un arc matérialisé par un sommet source et un sommet cible
 * 
 * @author MBorne
 *
 */
public class Edge {
	/**
	 * Identifiant de l'arc
	 */
	private String id;

	/**
	 * Sommet initial
	 */
	private Vertex source;

	/**
	 * Sommet final
	 */
	private Vertex target;
	
	/**
	 * LineString
	 */
	private LineString lineString;
	/**
	 * @param source
	 * @param target
	 */
	
	Edge(Vertex source, Vertex target) {
		this.source = source;
		this.source.getOutEdges().add(this);
		this.target = target;
		this.target.getInEdges().add(this);
		this.lineString = this.getGeometry();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@JsonIdentityInfo(
	    generator=ObjectIdGenerators.PropertyGenerator.class, 
	    property="id"
	)
	
    @JsonIdentityReference(alwaysAsId=true)
	public Vertex getSource() {
		return source;
	}

    @JsonIdentityReference(alwaysAsId=true)
	public Vertex getTarget() {
		return target;
	}

	/**
	 * dijkstra - coût de parcours de l'arc (distance géométrique)
	 * 
	 * @return
	 */
	public double getCost() {
		return source.getCoordinate().distance(target.getCoordinate());
	}

	@Override
	public String toString() {
		return id + " (" + source + "->" + target + ")";
	}
	
	@JsonSerialize(using = GeometrySerializer.class)
	public LineString getGeometry() {
		GeometryFactory gf = new GeometryFactory();
        return (LineString)gf.createLineString(new Coordinate[] {
            getSource().getCoordinate(),
            getTarget().getCoordinate()
        });
	}

	public LineString getLineString() {
		return lineString;
	}

}
