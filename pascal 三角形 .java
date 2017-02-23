/**
给定一个正整数 n ，产生pascal 三角形的前 n行
**/

ArrayList< ArrayList<Integer> >   pascalTriangle(int n)
{
      ArrayList< ArrayList<Integer> > res = new ArrayList< ArrayList<Integer> >();

      if(n < 1)   return res;
      //初始化第一行
      ArrayList<Integer>  row1 = new ArrayList<Integer>();
      row1.add(1);
      res.add(row1);

      if(n == 1)  return res;

      for(int i=1 ; i<n ; i++)
      {
        ArrayList<Integer> row = new ArrayList<Integer>();
        row.add(1);

        for(int j=1 ; j<i ; j++)
        {
          //获取上一行相邻两个元素之和
          row.add( j , res.get(i-1).get(j-1) + res.get(i-1).get(j) );
        }n

        row.add(1);
        res.add(row);
      }

      return res;
}
