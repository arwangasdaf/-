/**
两个有序数组 A 和 B，分别拥有 m 和 n 的长度,求其合并后的中值

对于长度为 m 的 A 和长度为 n 的 B ，合并后长度为 m + n ,假设 k = (n+m-1)/2 + 1,如果 n+m 为奇数，
则中值为第 K 个元素,如果 n + m为偶数，则中值为第 K 个元素和第 K+1 个元素的平均值，中值得问题可以转
化为两数组第 K 个值得问题，对于偶数的情况，当我们找到第 K 个值后，不需要再次调用函数，而是从 A[i]
和 B[j+1] 中挑选一个较小的数，即为第 K + 1个数
**/

public double findMedianSortedArrays(int[] A , int[] B)
{
  if( (A == null || A.length == 0) || (B == null || B.length == 0) )  return 0;
  int m = A.length;
  int n = B.length;
  int k = (n + m -1)/2 + 1;
  return findKthSortedArrays(A , B , k);
}

double findKthSortedArrays(int[] A , int[] B , int k)
{
  int m = A.length;
  int n = B.length;
  if(m > n)  return findKthSortedArrays(B , A , k);
  int left = 0;
  int right = 0;
  while(left < right)
  {
    int mid = left + (right - left)/2;
    int j = k - 1 - mid;
    if(j >= n || A[mid] < B[j]){
      left = mid + 1;
    }else{
      right = mid;
    }
  }
  int Aiminus1 = left - 1 >= 0 ? A[left - 1] : Integer.MIN_VALUE;
  int Bj = k - 1 - left >= 0 ? B[k - 1 - left] ：Integer.MIN_VALUE;
  int valK = Math.max(Aiminus1 , Bj);
  if( (n + m) % 2 == 1 )
     return valK;
  int Bjplus1 = k - left >= n ? Integer.MAX_VALUE : B[k - left];
  int Ai = left >= m ? Integer.MAX_VALUE : A[left];
  return  ( (double) (valK + Math.min(Bjplus1 , Ai)) ) / 2.0;
}
