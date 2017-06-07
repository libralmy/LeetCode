



public class Solution {
    public static void main(String [ ] args){

        String test = "dir\n\tsubdir1\n\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        System.out.print(lengthLongestPath(test));
    }
    public static int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<>();

        int len = 0;
        int result = 0;

        for(String s : input.split("\n")){
            int level = getcurlevel(s);

            while(stack.size() > level){
                len -= stack.pop();
            }
            int curlen = s.replaceAll("\t","").length()+1;
            len += curlen;

            //only update result when meet file name
            if(s.contains(".")){
                result = len-1 > result? len-1 : result;
            }


            stack.push(curlen);
        }


        return result;
    }

    public static int getcurlevel(String s){
        int len = s.length();
        int ablen = s.replaceAll("\t","").length();

        return len-ablen;
    }
}
