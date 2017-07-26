
import java.util.*;
import mygraphdemo.MyThread;
public class XTotalShapes {

    static Character[][] graph;
    static Boolean[][] visited;
    static int counter;
    static int rows;
    static int columns;

    public static void main(String[] args) {
        MyThread m = new MyThread();
        m.start();
        Scanner in = new Scanner(System.in);
        int T = new Integer(in.nextLine());
        for (int index = 1; index <= T; index++) {
            String[] dimensions = in.nextLine().split(" ");
            rows = Integer.valueOf(dimensions[0]);
            columns = Integer.valueOf(dimensions[1]);
            String str = in.nextLine();
            String[] strArray = str.split(" ");
            graph = new Character[rows][columns];
            visited = new Boolean[rows][columns];
            for (int row = 0; row < rows; row++) {
                String currentRow = strArray[row];
                for (int column = 0; column < columns; column++) {
                    graph[row][column] = currentRow.charAt(column);
                    visited[row][column] = Boolean.FALSE;
                }
            }
//            display(graph);
//            display(visited);
            //reset counter
            counter = 0;
            //find all vertices (dinh)
            for (int row = 0; row < rows; row++) {
                for (int column = 0; column < columns; column++) {
                    boolean v = visited[row][column];
                    char c = graph[row][column];
                    if (v == false && c == 'X') {
                        BFS(row, column);
                        counter += 1;
                    }
                }
            }
            System.out.println(counter);
//            display(visited);
        }
    }

    static void BFS(int row, int column) {
        if (0 <= row & row < rows & 0 <= column & column < columns) {
            boolean v = visited[row][column];
            char c = graph[row][column];
            if (v == false && c == 'X') {
                visited[row][column] = true;
                BFS(row - 1, column);
                BFS(row + 1, column);
                BFS(row, column - 1);
                BFS(row, column + 1);
            }
        }
    }

    static void display(Object[][] graph) {
        int rows = graph.length;
        int columns = graph[0].length;
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                Object point = graph[row][column];
                System.out.print(point + " ");
            }
            System.out.println("");
        }
    }
}
