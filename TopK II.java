/**
给定一个整形数组和一个整数 K ,找出和不小于 K 的数量最小的子数组

1.我们可以利用partition函数，把数组一分为二，并把问题转换为 "Top K" 的
问题，不过此时我们需要对partition函数进行修改，
1）对数组进行降序排列，即大的数在左边，小的数在数组的右边
2）分区的同时计算左边数的和

有了新的partition函数之后，我们可以循环调用该函数，把左半部分的和同 K 进行
比较，如果大于等于 K 则找到合适的分区，但不确定左半部分的子数组的元素的个数是否
是最少的，我们还需要继续调用partition函数，如果左半部分的和比 K 小，则相应的更新
K 的值， K = K -左半部分的和，因为下次调用partition函数时，忽略左半部分的元素了
**/

void getTopKII(int data[] , int k)
{
     int start = 0 , end = data.length - 1;
     int last = -1;  //记录上次的子数组和不小于 K 的尾部元素下标
     //记录分区后的左半部分的和，java无法传参，我们使用ArrayList来代替
     ArrayList<Integer> currSum = new ArrayList<Integer>();
     int index = partition(data , start , end , currSum);
     while(index >= 0)
     {
       if(currSum.get(0) >= k)
       {
         //记录当前下标，因为找到了 0 到 index 的子数组
         last = index;
         //从 index 前面继续找
         end = last - 1;
         index = partition(data , start , end , currSum);
       }else{
         //从 index 后面继续找
         start = index + 1;
         k = k - currSum.get(0);
         index = partition(data , start , end , currSum);
       }
     }
     for( int i=0 ; i<=last ; i++)
     {
       System.out.println( data[i] + "\t");
     }
}
