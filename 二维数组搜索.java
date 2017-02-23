/**
设计一个算法对 m*n 矩阵进行搜索,这个矩阵拥有如下属性：
1.每行的数都是从左到右排序好的
2.每行的首数大于上行的尾数

KEY:
对于排序好的数组我们可以使用二分搜索法，以获取 O(logn)的时间复杂度
如何将一个二维数组映射为一维数组
假设映射到一维数组 A，A有 m*n个元素，那么 A[k] = matrix[i][j],
当 k = i*n + j即 i=k/n , j=k%n , 有了映射关系以后，我们可以对展开后的
一维数组进行二分查找，时间复杂度为 O(log(m*n))
**/

boolean searchMatrix(int[][] matrix , int target)
{
     int m = matrix.length;
     int n = matrix[0].length;

     int low = 0;
     int high = m*n - 1;

     while(low < high)
     {
          int mid = (low + high) / 2;
          if(matrix[mid/n][mid%n] == target)
               return true;
          else if(matrix[mid/n][mid%n] < target)
               low = mid + 1;
          else if(matrix[mid/n][mid%n] > target)
               high = mid - 1;
     }
     return false;
}
