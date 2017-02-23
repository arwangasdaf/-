/**
给定一个无序整型数组，找出第一个不在数组里的正整数，要求时间复杂度为 O(n),
空间复杂度为 O(1)

KEY:
借用哈希算法的思路，使用数组下标来存储相应的值，比如第 K 个元素(对应的下标为 K - 1)，
存储数组 K ，也就是说 A[k-1] = k,对于大于数组长度的的数字或者小于1的数字采用抛弃的办法，
因为他们对我们找第一个不在数组里的整数并没有帮助，一旦有了新数组从前开始扫描，遇到第一个
A[k-1]不等于k时，输出k，如果没有遇到那结果就是数组长度的下一个数，比如{1,2,3,4},返回 5
**/


int firstMissingPositive(int[] A)
{
    int n = A.length;
    for(int i=0 ; i<n ; i++)
    {
        if(A[i]>0 && A[i]<=n)
        {
            if(A[i]-1 != i && A[A[i] - 1] != A[i])
            {
                //交换相应的值的大小
                int temp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = temp;
                //交换之后，还需要对新的 A[i] 值进行判断
                i--;
            }
        }
    }
    for(int i=0 ; i<n ; i++)
    {
        //输出第一个不匹配的数字
        if(A[i]-1 != i)  return i + 1;
    }
    return n + 1;
}
