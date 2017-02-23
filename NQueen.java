import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NQueen {

        public static List<List<String>> result = new ArrayList<List<String> >();

        public static boolean hang[] = new boolean[100];    //记录queen所在的行

        public static int path[] = new int[100];            //记录queen所在的列

        public static boolean zheng[] = new boolean[100];   //记录正向对角线

        public static boolean fan[] = new boolean[100];     //记录反向对角线

        public List<List<String>> solveNQueens(int n) {
            result.clear();
            dfs(0 , n);
            return result;
        }

        public static void dfs (int idx , int n)
        {
            if (idx >= n)
            {
                List<String> tmp = new ArrayList<String>();
                for (int i=0 ; i<n ; i++)
                {
                    String every = "";
                    for (int j=0 ; j<n ; j++)
                    {
                        if (path[i] == j)
                        {
                            every += "Q";
                        }else {
                            every += ".";
                        }
                    }
                    tmp.add(every);
                }
                result.add(tmp);
                return ;
            }

            for (int i=0 ; i<n ; i++)
            {
                if (!hang[i] && !zheng[idx + i] && !fan[idx - i + n - 1])
                {
                    path[idx] = i;
                    hang[i] = true;
                    zheng[idx + i] = true;
                    fan[idx - i + n - 1] = true;

                    dfs(idx+1 , n);

                    hang[i] = false;
                    zheng[idx + i] = false;
                    fan[idx - i + n - 1] = false;
                }
            }
        }

        public static void main(String[] args)
        {
            Scanner input = new Scanner(System.in);
            int n = input.nextInt();
            NQueen nq = new NQueen();
            //System.out.println(nq.solveNQueens(n));\
            List<List<String> > re = new ArrayList<List<String> >();
            re = nq.solveNQueens(n);
            for (List i : re)
            {
                System.out.println(i);
            }
        }
}
