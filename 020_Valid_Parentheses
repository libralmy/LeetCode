    /**use stack to be the temp storage
     * all the parenthess should show up as couple, meet left, stack need to push right
     * else if statck is empty or ch != stack.pop() return false
     * return value need to make sure stack is empty()
     **/


public class Solution {

    public static boolean isValid(String s) {
        Stack<Character> stackParen = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char tempStr = s.charAt(i);
            if(tempStr == '('){
                stackParen.push(')');
            }else if(tempStr == '['){
                stackParen.push(']');
            }else if(tempStr == '{'){
                stackParen.push('}');
            }else if(stackParen.isEmpty() || tempStr != stackParen.pop()){
                return false;
            }
        }
        return stackParen.isEmpty();
    }
        /*
        Map<Character, Character> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();

        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        if(s.length() == 0) return false;
        for(char ch : s.toCharArray()){
            if(map.containsKey(ch)){
                stack.push(map.get(ch));
            }else{
                if(stack.isEmpty() || ch != stack.pop()){ return false;}
            }
        }
        return stack.isEmpty();
        */
    }
}
