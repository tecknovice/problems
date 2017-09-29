package mygraphdemo;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class MyThread extends Thread {

    BlockingQueue<Object> q;

    public void run() {
        System.out.println("Hello from a thread!");
        MyGraphic mainPanel = new MyGraphic();
        mainPanel.setPreferredSize(new Dimension(800, 600));
        JFrame frame = new JFrame("DrawGraph");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        while (true) {
            try {
                mainPanel.o = q.take();
                Graphics g = mainPanel.getGraphics();
                mainPanel.update(g);
//                mainPanel.repaint();                
            } catch (InterruptedException ex) {
                Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public MyThread(BlockingQueue<Object> q) {
        this.q = q;
    }
    public MyThread() {
    	
    }

}
