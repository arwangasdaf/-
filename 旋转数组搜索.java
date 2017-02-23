/**
给定一个有序数组的旋转和一个target，返回该target在该数组的下标，
如果不存在则返回 -1 ，该数组没有重复的值

key:
同前一道题"旋转数组最小值",只要是局部有序，哪怕是旋转的，我们依然可以
利用二分查找法,通过中间元素和左右两端元素相比较,判断哪一部分是有序的
1）如果左半部分是有序的，目标落在有序区间里，那么移动右指针，因为无序的
部分要么比中间的元素答，要么比左端的元素小，如果目标值不在有序区间里，则
移动左指针

2)如果右半部分是有序的，目标值落在有序区间里，那么移动左指针，抛弃右边部分，
如果目标值不在有序区间里，抛弃右半部分，则移动右指针
**/


int searchRotatedArray(int[] A , int target)
{
  int left = 0 , right = A.length - 1;
  //二分查找
  while(left < right)
  {
     int mid = left +　(right - left)/2;
     if(A[mid] == target)  return mid;
      //左半部分是有序的
      if(A[left] <= A[mid])
      {
        if(A[left] <= target && target < A[mid])
        {
          right = mid - 1;
        }else{
          left = mid + 1;
        }
      }else{
        //右半部分是有序的
        if(A[mid] < target && target <= A[right])
        {
          left = mid + 1;
        }else{
          right = mid - 1;
        }
      }
  }
  return -  1;
}
