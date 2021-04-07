package com.wz.week_1;

/**
 * 思路1：使用replace将.替换成[.]?
 * 思路2：使用额外的新字符串，对整个字符串进行遍历，遇到'.'就变成[.]追加在新串后面
 */
public class DefangIPaddr {

    /**
     * 思路1 无工作量
     * @param address
     * @return
     */
    public static String defangIPaddr(String address) {
        String s = address.replace(".","[.]");
        return s;
    }

    /**
     * 思路2
     * @param address
     * @return
     */
    public static String defangIPaddr2(String address) {
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            if(address.charAt(i) == '.'){
                strBuilder.append("[.]");
            }else {
                strBuilder.append(address.charAt(i));
            }
        }
        return strBuilder.toString();
    }

    public static void main(String[] args) {
        String address = "1.1.1.1";
        String address2 = "255.100.50.0";
        defangIPaddr(address2);
    }


}
