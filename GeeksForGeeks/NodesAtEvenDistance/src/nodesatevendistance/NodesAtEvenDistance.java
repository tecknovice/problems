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
    public static void main(String[] args) {
    	MyThread thread = new MyThread(q);
    	thread.start();
        Scanner in = new Scanner(System.in);
        int T = new Integer(in.nextLine());
        int N;
        
        for (int index = 1; index <= T; index++) {
            N = new Integer(in.nextLine());
            List<PointNo> list = new ArrayList<>(N+1);
            for(int j =1;j<=N;j++) {
            	try {
            		PointNo p = new PointNo(Integer.toString(j));
            		list.add(j, p);
					q.put(p);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            String[] p = in.nextLine().split(" ");
            int i = -1;
            while (true) {
                i += 1;
                Integer v1=null;
                Integer v2 =null;
                if (i < p.length) {
                    v1 = Integer.valueOf(p[i]);
                }

                i += 1;
                if (i < p.length) {
                    v2 = Integer.valueOf(p[i]);
                }
                if(v1!=null&&v2!=null){
//                    LineNo line = new LineNo(list.get(v1), list.get(v2));
//                    try {
//						q.put(line);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
                }
            }
        }
    }

}
