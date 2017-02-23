/**
数组配对:
给定两个数组表示的整数,比如 x = [1,2,3,4] , y = [2,4,1,0],返回第一个整数的重组后的值最接近第二个整数.
并且大于第二个整数,并且两个整数的数组大小相同,并且肯定能找出符合条件的数.
**/

int[] getClosestBigger(int[] x , int[] y)
{
      int len = x.length;
      int[] res = new int[len];  //返回结果
      boolean used = new boolean[len];  //记录数组中数字的使用情况
      Arrays.sort(x);
      int j = 0 , k = 0;
      for (int i=0 ; i<len ; i++)
      {
           j = 0;
           while(j<len && (used[j] || x[j])<y[i])  ++j;  //找到第一个不小于y[i]的数
           res[k++]  = x[j];
           used[j] = true;
           if(i == len-1)  break;
           if(x[j] > y[i])                 //大于的情况下复制剩下的数
           {
               for(i=0 ; i<len ; i++)
               {
                  if(!used[i])  res[k++] = x[i];
               }
               break;
           }
      }
      return res;
}
