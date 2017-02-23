/**
Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
**/


public class Solution {

    public static String a[] = {"" , "" , "abc" , "def" , "ghi" , "jkl" , "mno" , "pqrs" , "tuv" , "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        dfs (0 , digits , result , "");
        return result;
    }

    public static void dfs (int idx , String digits , List<String> result , String pre)
    {
        if (idx >= digits.length())
        {
            if (pre != "")
            {
               result.add(pre);
            }
            return ;
        }

        String text = a[ digits.charAt(idx) - '0'];

        for (int i=0 ; i<text.length() ; i++)
        {
            dfs (idx + 1 , digits , result , pre + text.charAt(i));
        }
    }
}
