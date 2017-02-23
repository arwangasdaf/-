/**
给出一个整型数组,以及数组的最大值max和最小值min，写一个函数产生一个在［min , max］范围内的
随机数,该随机数并不在数组里.假设总能找到该随机数.

solution:
在[min , max]范围内产生一个随机数,判断该数是否在数组里,如果是,则重复上述过程,则产生一个随机数.
如果不在数组里，则返回该值，为了提高查找效率。我们可以对数组进行排序，然后使用二分查找,可以把
时间复杂度从O(n^2)降至O(nlgn).
**/

void numInRange(int[] intList , int min , int max)
{
  Arrays.sort(intList);   //对输入数组进行排序
  int range = max - min + 1;
  Random rand = new Random();
  int result = rand.nextInt(range) + min;
  //二分查找,直至该随机数不在数组里
  while( Arrays.binarySearch(intList , result)>=0 )
  {
    result = rand.nextInt(range) + min;
  }
  System.out.println(result);
}
