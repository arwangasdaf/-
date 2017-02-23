public class Solution{

    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<String>();
        dfs (new int[10] , 0 , 0 , result , num);
        return result;
    }

    public static void dfs (int[] time  , int i , int k , List<String> result , int num)
    {

      if (k == num)
      {
          //getTime
          String res = getTime (time);
          if (res != null)
          {
              result.add (res);
          }

          return ;
      }
        if (i == time.length)
        {
            return ;
        }



        time[i] = 0;
        dfs (time , i + 1 , k , result , num);

        time[i] = 1;
        dfs (time , i + 1 , k + 1 , result , num);

        time[i] = 0;
    }

    public static String getTime (int[] time)
    {
        int hours = 0;
        for (int i=0 ; i<4 ; i++)
        {
            if (time[i] == 1)
            {
                hours += (int) Math.pow (2 , i);
            }
        }

        int minute = 0;
        for (int i=4 ; i<10 ; i++)
        {
            if (time[i] == 1)
            {
                minute += (int) Math.pow (2 , i - 4);
            }
        }

        String min = "" + minute;
        if (minute < 10)
        {
            min = "0" + min;
        }

        if (hours >= 12 || minute >= 60)
        {
            return null;
        }

        String res = hours + ":" + min;
        return res;
    }
}
