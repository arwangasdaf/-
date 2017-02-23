/**
Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
**/

public List<List<Integer>> subsets(int[] S) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    if(S.length == 0){
        return result;
    }

    Arrays.sort(S);
    dfs(S, 0, new ArrayList<Integer>(), result);
    return result;
}

public void dfs(int[] s, int index, List<Integer> path, List<List<Integer>> result){
    result.add(new ArrayList<Integer>(path));

    for(int i = index; i < s.length; i++){
        path.add(s[i]);
        dfs(s, i+1, path, result);
        path.remove(path.size()-1);
    }
}
//简单的递归解法
public class Solution {
    public static boolean v[] = new boolean[100];
    public static List<List<Integer> > ans = new ArrayList<List<Integer> >();

    public List<List<Integer>> subsets(int[] nums) {
        ans.clear();
        robot(0 , nums);
        return ans;
    }
    //递归函数
    public static void robot (int idx , int[] nums)
    {
        //递归边界函数
        if (idx >= nums.length){
            List<Integer> tmp = new ArrayList();
            for(int i=0 ; i<nums.length ; i++)
            {
                if(v[i])
                {
                    tmp.add(nums[i]);
                }
            }
            ans.add(tmp);
            return;
        }
        //将v[i]加入到集合里
        v[idx] = true;
        robot(idx+1 , nums);
        //不将v[i]加入到集合里
        v[idx] = false;
        robot(idx+1 , nums);
    }
}
