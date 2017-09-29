/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygraphdemo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import mygraphdemo.Line;
import mygraphdemo.Point;

/**
 *
 * @author hungnv
 */
class MyGraphic extends JPanel {

	volatile Object o;
	List<Object> objectList = new LinkedList<>();
	private int padding = 25;
	private int labelPadding = 25;
	private int radix;
	private Color lineColor = Color.CYAN;
	private Color pointColor = Color.GREEN;
	private Color textColor = Color.BLACK;
	private Color gridColor = new Color(200, 200, 200, 200);
	private static final Stroke GRAPH_STROKE = new BasicStroke(2f);

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int X = getWidth();
		int Y = getHeight();
		radix = 2/3*Math.min(X, Y);
		// draw white background
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, X, Y);
		g2.setColor(Color.BLACK);
		g2.translate(X / 2, Y / 2);
		// create x and y axes
		g2.drawLine(-X/2, 0, X/2, 0);
		g2.drawLine(0, -Y/2, 0, Y/2);
		Stroke oldStroke = g2.getStroke();
		Random r =new Random();
		Point p = null;
		Line l = null;
		PointNo pn =null;
		LineNo ln = null;
		Graph graph =null;
		if (o != null) {
			String classname = o.getClass().getSimpleName();
			switch (classname) {
			case "Point":
				p = (Point) o;
				objectList.add(p);
				break;
			case "Line":
				l = (Line) o;
				objectList.add(l);
				break;
			case "PointNo":
				pn =(PointNo) o;
				objectList.add(pn);
				break;
			case "LineNo":
				ln =(LineNo) o;
				objectList.add(ln);
				break;
			case "Graph":
				graph = (Graph)o;
				objectList.add(graph);
				break;
			default:
				break;
			}
		}

		for (Object object : objectList) {
			String myClass = object.getClass().getSimpleName();
			switch (myClass) {
			case "Point":
				p = (Point) object;
				g2.setStroke(oldStroke);
				g2.setColor(pointColor);
				g2.fillOval(p.x * 100, p.y * 100, 10, 10);
				break;
			case "PointNo":
				pn = (PointNo) object;
				g2.setStroke(oldStroke);
				g2.setColor(pointColor);
				 pn.x=r.nextInt();
				pn.y =r.nextInt();
				g2.fillOval(pn.x * 100, pn.y * 100, 10, 10);
				g2.setColor(textColor);
				g2.drawString(pn.name, pn.x, pn.y);
				break;
			case "Line":
				l = (Line) object;
				g2.setStroke(GRAPH_STROKE);
				g2.setColor(lineColor);
				g2.drawLine(100 * l.p1.x, 100 * l.p1.y, 100 * l.p2.x, 100 * l.p2.y);
				break;
			case "LineNo":
				ln=(LineNo) object;
				g2.setStroke(GRAPH_STROKE);
				g2.setColor(lineColor);
				g2.drawLine(100 * ln.p1.x, 100 * ln.p1.y, 100 * ln.p2.x, 100 * ln.p2.y);
				
			default:
				break;
			}
		}
		// g.dispose();

	}
}
