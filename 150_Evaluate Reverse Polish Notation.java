
    /**
    * @param tokens an string array that contains revers polish notation
    * @return int is the calculation of given array
    * 
    * stack<numbers>
    * evalRPN() for push Integer.parseInt(str) to stack if isOperator(), call calculation() 
    *                                                   else push number to stack
    * 
    * if meet operator, pop recent two int
    * (if operator is "-" or "/" need to record the order of pop)
    * 
    * int calculation(num1, num2, op) four conditions and return result
    * boolean isOperator()  
    * 
    **/
public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        if(tokens.length == 0) return 0;
        int result = 0;
        for(String str : tokens){
            if(isOperator(str)){
                int n2 = stack.pop();
                int n1 = stack.pop();
                result = calculation(n1, n2, str);
                stack.push(result);
            }else{
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }
    
    public boolean isOperator(String str){
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
    }
    
    public int calculation(int n1, int n2, String op){
        int result = 0;
        switch(op){
            case "+":
                result = n1 + n2;
                break;
            case "-":
                result = n1 - n2;
                break;
            case "*":
                result = n1 * n2;
                break;
            case "/" :
                result = n1 / n2;
                break;
        }
        
        return result;
    }
}
