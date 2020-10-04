package com.yibo.datastructure.stack;

import java.util.Stack;

/**
 * @Author: huangyibo
 * @Date: 2020/9/2015:43
 * @Description:
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class LeetCodeQuestion {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else {
                if(stack.isEmpty()){
                    return false;
                }
                char topChar = stack.pop();
                if(c == ')' && topChar != '('){
                    return false;
                }
                if(c == ']' && topChar != '['){
                    return false;
                }
                if(c == '}' && topChar != '{'){
                    return false;
                }
            }
        }
        //如果栈里面还有字符的话，那么也不行，因为意味着还有字符没办法匹配
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        LeetCodeQuestion leetCode = new LeetCodeQuestion();
        System.out.println(leetCode.isValid("()[]{}"));
        System.out.println(leetCode.isValid("()[}[}"));
    }
}
