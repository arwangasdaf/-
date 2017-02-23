public class Solution {
    public int numIslands(char[][] grid) {

         if (grid.length == 0 || grid[0].length == 0)
        {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        int answer = 0;

        for (int i=0 ; i<m ; i++)
        {
            for (int j=0 ; j<n ; j++)
            {
               if (grid[i][j] == '1')
               {
                   bfs (i , j , grid , m , n);
                   answer++;
               }
            }
        }
        return answer;
    }

    public static int[] qx = new int[1000];
    public static int[] qy = new int[1000];

    public static void bfs (int x , int y , char[][] grid , int m , int n)
    {
        int h = 0;
        int r = 1;
        qx[0] = x;
        qy[0] = y;
        grid[x][y] = '0';
        while (h < r)
        {
            r = check (qx[h] - 1 , qy[h] , grid , r , m , n);
            r = check (qx[h] + 1 , qy[h] , grid , r , m , n);
            r = check (qx[h] , qy[h] + 1 , grid , r , m , n);
            r = check (qx[h] , qy[h] - 1 , grid , r , m , n);
            ++h;
        }
    }

    public static int check (int x , int y , char[][] grid , int r , int m  , int n)
    {
        if (x < m && x >= 0 && y >= 0 && y < n && grid[x][y] == '1')
        {
            qx[r] = x;
            qy[r] = y;
            grid[x][y] = '0';
            r++;
        }
        return r;
    }
}



以下为 Bfs 和 Dfs 两种解法
dfs:
public int numIslands(char[][] grid) {
    int count=0;
    for(int i=0;i<grid.length;i++)
        for(int j=0;j<grid[0].length;j++){
            if(grid[i][j]=='1'){
                dfsFill(grid,i,j);
                count++;
            }
        }
    return count;
}
private void dfsFill(char[][] grid,int i, int j){
    if(i>=0 && j>=0 && i<grid.length && j<grid[0].length&&grid[i][j]=='1'){
        grid[i][j]='0';
        dfsFill(grid, i + 1, j);
        dfsFill(grid, i - 1, j);
        dfsFill(grid, i, j + 1);
        dfsFill(grid, i, j - 1);
    }
}

bfs:
public int numIslands(char[][] grid) {
    int count=0;
    for(int i=0;i<grid.length;i++)
        for(int j=0;j<grid[0].length;j++){
            if(grid[i][j]=='1'){
                bfsFill(grid,i,j);
                count++;
            }
        }
    return count;
}
private void bfsFill(char[][] grid,int x, int y){
    grid[x][y]='0';
    int n = grid.length;
    int m = grid[0].length;
    LinkedList<Integer> queue = new LinkedList<Integer>();
    int code = x*m+y;
    queue.offer(code);
    while(!queue.isEmpty())
    {
        code = queue.poll();
        int i = code/m;
        int j = code%m;
        if(i>0 && grid[i-1][j]=='1')    //search upward and mark adjacent '1's as '0'.
        {
            queue.offer((i-1)*m+j);
            grid[i-1][j]='0';
        }
        if(i<n-1 && grid[i+1][j]=='1')  //down
        {
            queue.offer((i+1)*m+j);
            grid[i+1][j]='0';
        }
        if(j>0 && grid[i][j-1]=='1')  //left
        {
            queue.offer(i*m+j-1);
            grid[i][j-1]='0';
        }
        if(j<m-1 && grid[i][j+1]=='1')  //right
        {
            queue.offer(i*m+j+1);
            grid[i][j+1]='0';
        }
    }
}
