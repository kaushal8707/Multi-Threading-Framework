package balanced.paranthesis.demo;

import java.util.Stack;

public class BalancedParenthesesDemo {
    public static void main(String[] args) {
        String input="[()[]()]";
        boolean result=isBalanced(input);
        if(result)
            System.out.println("balanced");
        else
            System.out.println("not balanced");

    }

    public static boolean isBalanced(String input){
        Stack<Character> stack = new Stack<>();
        char []chArr=input.toCharArray();

        for(int i=0;i<chArr.length;i++){
            if(chArr[i]=='(' || chArr[i]=='{' || chArr[i]=='['){
                stack.push(chArr[i]);
                continue;
            }

            char current=chArr[i];
            char stackPopOut;
            switch(current){
                case ')':
                    stackPopOut=stack.pop();
                    if(stackPopOut=='{' || stackPopOut=='[')
                     return false;
                    break;
                case '}':
                    stackPopOut=stack.pop();
                    if(stackPopOut=='(' || stackPopOut=='[')
                     return false;
                    break;
                case ']':
                    stackPopOut=stack.pop();
                    if(stackPopOut=='{' || stackPopOut=='(')
                     return false;
                    break;
            }
        }
                return (stack.isEmpty());
    }
}
