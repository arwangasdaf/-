public class Solution
{
   public int maxSubArray(int[] nums)
   {
         int len = nums.length;
         int ans = -100000;
         int sum = 0;
         for (int i=0 ; i<len ; i++)
         {
             sum += num[i];
             if(sum > ans)
                 ans = sum;
             if(sum < 0)
                 sum = 0;    //小于则将sum=0
         }
        return ans;
   }
}
