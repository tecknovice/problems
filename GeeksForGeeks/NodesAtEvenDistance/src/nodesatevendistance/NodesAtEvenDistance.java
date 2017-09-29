/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodesatevendistance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import mygraphdemo.*;
/**
 *
 * @author hungnv
 */
public class NodesAtEvenDistance {

    static BlockingQueue<Object> q = new LinkedBlockingQueue<>();
    static Graph g = new Graph();
    public static void main(String[] args) {
    	MyThread thread = new MyThread(q);
    	thread.start();
        Scanner in = new Scanner(System.in);
        int T = new Integer(in.nextLine());
        int N;
        
        for (int index = 1; index <= T; index++) {
            N = new Integer(in.nextLine());
            for(int j =1;j<=N;j++) {
            	
            		PointNo p = new PointNo(Integer.toString(j));
					g.addVertice(p);
				
            }
            String[] p = in.nextLine().split(" ");
            int i = -1;
            while (i<p.length) {
                i += 1;
                String v1=null;
                String v2 =null;
                if (i < p.length) {
                    v1 =p[i];
                }

                i += 1;
                if (i < p.length) {
                    v2 = p[i];
                }
                if(v1!=null&&v2!=null){
                    LineNo line = new LineNo(g.getVertice(v1),g.getVertice(v2));
                    g.addEdge(line);
                }
            }
            try {
				q.put(g);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }

}
