package com.geek._07;

import java.util.List;

/**
 * 思路：
 * 1.构造所有组合
 * 2.过滤不合法的组合
 *      合法组合
 *          1.左括号个数小于n的话，就添加左括号
 *          2.左括号大于右括号的时候，就添加右括号
 */
public class GenerateParenthesis {

    private List<String> result;

    public List<String> generateParenthesis(int n) {
        generate(0, 0, n, "");
        return result;
    }

    private void generate(int left, int right, int n, String s) {
        if (left == n && right == n) {
            result.add(s);
            return;
        }
        if (left < n) generate(left + 1, right, n, s + "(");
        if (left > right) generate(left, right + 1, n, s + ")");
    }
}
