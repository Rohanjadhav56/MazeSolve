import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Dfs {

    public static boolean dfs(int[][]grid, boolean [][]vis, List<Integer> path,int i,int j)
    {
        if(grid[i][j] != 0 && grid[i][j] != 1 )
        {
            path.add(i);
            path.add(j);
            return true;
        }
        if(grid[i][j]==0)
        {
            vis[i][j] = true;

            if(i>1  && !vis[i-1][j] && dfs(grid,vis,path,i-1,j))
            {
                path.add(i);
                path.add(j);
                return true;
            }
            if(i+1<grid.length  && !vis[i+1][j] && dfs(grid,vis,path,i+1,j))
            {
                path.add(i);
                path.add(j);
                return true;
            }
            if(j>1  && !vis[i][j-1] && dfs(grid,vis,path,i,j-1))
            {
                path.add(i);
                path.add(j);
                return true;
            }
            if(j+1<grid[0].length  && !vis[i][j+1] && dfs(grid,vis,path,i,j+1))
            {
                path.add(i);
                path.add(j);
                return true;
            }
        }
        return false;
    }
}