/**
两个有序数组 A 和 B，分别拥有 m 和 n 的长度，求其合并后的第 k 个值

1.归并排序
把数组 A 和 B 分别看做排序数组的左半部分和右半部分，然后进行归并操作，
从两个数组的头部开始取出第 K 个值，只移动元素较少的数组，总共移动了 K
步，因此时间复杂度为 O(K)

2.归并和二分查找
与其按顺序挑出下一个排序的数组,我们不如考虑通过二分查找，同时在 A 和 B里找，时间复杂度
为 O(log(m+n))

3.
1) 分别在数组 A 和 B 找出 i 和 j，使得 i+j+1=k
2) 满足 max(A[i-1] , B[j-1]) < B[j] < A[i],我们不能保证找到第二个不等式，因为
不能保证 A 和 B 是交错的，如果找不到相应的 A[i]，则说明 A 数组的元素过小 ，这时候
在满足第一个不等式的情况下，如果 j>=0 ,则取 B[j] 的值，否则取 A[i-1]的值得大小
**/
int Search(int[] A , int[] B)
 {
  int m = A.length;
  int n = B.length;
  if( m > n)   return findKthSortedArrays(B , A , k);
  int left = 0;
  int right = m;
  while( left < right)
  {
    //二分查找
    int mid = left + (right - left)/2 ;
    int j = k - 1 - mid;
    if( j >= n || A[mid] < B[j])
    {
      //下标i尽可能往前移动，找到比B[j]大的第一个A[i]
        left = mid + 1;
    }else{
        right = mid;
    }
  }

  int Aiminus1 = left - 1 >=0 ? A[ left - 1 ] : Integer.MIN_VALUE;
  int Bj = k - 1 - left >=0 ? B[ k - 1 - left ] : Integer.MIN_VALUE;
  //取B[j]和A[i-1]中较小的那一个
  return Math.max( Aiminus1 , Bj );
}

//时间复杂度为 O(log(min(m,n)))
