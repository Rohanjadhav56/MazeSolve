import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;


public class MazeSolve extends JFrame {

   static int [][]grid;
   static boolean [][]vis;
    MazeSolve(){
        setTitle("Maze Solve");
        setSize(400,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dfs.dfs(grid,vis,path,1,1);
        System.out.print(path);

    }
    public static List<Integer> path = new ArrayList<>();

    @Override
    public void paint(Graphics g)
    {
        for(int i =1;i<grid.length;i++)
        {
            for(int j= 1;j<grid[0].length;j++)
            {
                Color color;
                if(i==1 && j==1)
                {
                    color = Color.RED;
                }
                else {
                    switch (grid[i][j]) {
                        case 1:
                            color = Color.BLACK;
                            break;
                        case 0:
                            color = Color.WHITE;
                            break;
                        default:
                            color = Color.RED;
                            break;
                    }
                }
                g.setColor(color);
                g.fillRect(50*j,50*i,40,40);
                g.setColor(Color.GREEN);
                g.drawRect(50*j,50*i,40,40);
            }

        }
        for(int k= 0;k<path.size();k+=2)
        {
            int ix = path.get(k);
            int iy = path.get(k+1);
            g.setColor(Color.BLUE);
            g.fillRect(50*iy,50*ix,30,30);
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        grid = new int[n+1][m+1];
        vis = new boolean[n+1][m+1];
        for(int i = 1;i<n+1;i++)
        {
            for(int j=1;j<m+1;j++)
            {
                grid[i][j] = sc.nextInt();
            }
        }

      MazeSolve view = new MazeSolve();
        view.setVisible(true);

    }
}
