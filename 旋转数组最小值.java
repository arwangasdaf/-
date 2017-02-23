/**
输入一个递增数组的一个旋转，输出旋转数组的最小值

key：
即便是旋转数组，只要局部有序，就可以使用二分查找。我们把数组一分为二之后,
需要判断排序部分在左半部分还是在右半部分。当数组出现有相同值得元素时，比如
{1,1,1,1,0,0,1}，我们无法区分哪个部分是已经排序的，这时候只能把首部指针，向前
移动一位，每次查找时，需要提取最小值。
**/

int getMinOfRotation(int[] A)
{
  int left = 0 , right = A.length - 1 , mid , min = A[left];
  //二分查找
  while(left < right)
  {
    mid = left + (right - left)/2;
    min = Math.min(A[left] , min);
    if(A[mid] == A[left] && A[mid] == A[right])
    {
      //不能确定最小值在哪一个部分,left向前移动一格
      left++;
    }else if(A[mid] >= A[left]){
      //在右半部分找
      left = mid + 1;
      min = Math.min(A[left] , min);
    }else{
      //在左半部分找
      min = Math.min(A[left] , min);
      right = mid - 1;
    }
  }
  return min;
}
