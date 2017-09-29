package mygraphdemo;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	private List<PointNo> lp;
	private List<LineNo> ll;
	public Graph() {
		lp=new ArrayList<>();
		ll=new ArrayList<>();
	}
	public boolean validateEdge(LineNo l) {
		PointNo p1=l.p1;
		PointNo p2=l.p2;
		if(!lp.contains(p1)||!(lp.contains(p2))) {
			return false;
		}
		for (LineNo lineNo : ll) {
			if(lineNo.p1==l.p1&&lineNo.p2==l.p2) {
				return false;
			}
		}
		return true;
	}
	public boolean validateVertice(PointNo p) {
		if(lp.contains(p)) {
			return false;
		}
		return true;
	}
	public boolean addVertice(PointNo p) {
		if(validateVertice(p)==false)return false;
		lp.add(p);
		return true;
	}
	public boolean addEdge(LineNo l) {
		if(validateEdge(l)==false) return false;
		ll.add(l);
		return true;
	}
	public PointNo getVertice(String name) {
		for (PointNo p : lp) {
			if(p.name.equals(name)) {
				return p;
			}
		}
		return null;
	}
}
