/**
求一维数组中最小的K个数

方案一:排序
先把数组从小到大进行排序,取前K个数.时间复杂度为O(nlogn),如果数组过大，机器
内存无法同时容纳整个数组,则需要使用外部排序.

方案二:使用堆
1.创建一个最小堆,初始大小为 K，堆顶为堆的最大元素
2.扫描一遍数组,往最小堆插入数据，如果堆的元素个数已经达到 K，那么新元素需要和
堆顶进行比较，如果小于堆顶，则移除堆顶，插入新元素。

方案三:快排分区函数
快排的分区函数：选择一个数，把数组的数分为两部分，把比选中的数小或者相等的数移到数组的左边
把比选中的数大的数移到数组的右边，返回分区后的选中数所在的下标。
**/

int partition(int[] data , int start , int end)
{
    if(start > end)  return -1;
    int index = start;  //可以随机选择pivot，不一定是第一个元素
    //第一次交换
    int tmp = data[index];
    data[index] = data[end];
    data[end] = tmp;
    //进行partition过程
    for(int i=start ; i<end ;i++)
    {
        if(data[i]<data[end])
        {
          if(i!=index)
          {
            //第二次交换
            tmp = data[index];
            data[index] = data[i];
            data[i] = tmp;

          }
          index++;
        }
    }
    //第三次交换
    tmp = data[end];
    data[end] = data[index];
    data[index] = tmp;
    return index;
}

/**
对数组调用分区函数之后,如果返回的下标为 K-1 ,那么数组左边的 K 个数就是最小的 K 个数，问题转化为不断的
调用partition函数,直到返回的下标为 K-1 , 这种方法的平均时间复杂度为 O(n),因为并未实现真正的快速排序算法
**/

void getTopK(int[] data , int k)
{
     int start = 0 , end = data.length - 1;
     int index = partition(data , start , end);
     while(index != k-1)
     {
       if( index > k-1 )
       {
         //从index前面找
         end = index - 1;
         index = partition(data , start , end);
       }else{
         //从index后面找
         start = index + 1;
         index = partition(data , start , end);
       }
     }
     //输出最小的 K 个数
    for(int i=0 ; i<k ; i++)
    {
      System.out.println( data[i] + "\t" );
    }
}


/**
扩展问题:
一个直角坐标系有 N 个点，找出离原点最近的 K 个点，请设计数据结构和时间复杂度.
**/

class Point
{
      double x ;
      double y;
      double distance;
      Point(double x , double y)
      {
        this.x = x;
        this.y = y;
        this.distance = Math.sqrt( x*x + y*y);
      }
}

/**
对于这些点的集合,调用分区函数(排序依据是点的distance大小)，如果返回的下标是 K-1 ，那么前 K 个点就是离原点最近的 K
个点，把问题转化为"Top K",因此时间复杂度为 O(n)
**/
