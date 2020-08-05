package com.algorithm.array;

import java.util.HashMap;

public class GetHint {

    public static String getHint(String secret, String guess) {

        int sizeA = 0;
        int sizeB = 0;
        HashMap<Character,Character> map = new HashMap();
        //1.大致的思路，将secret和guess的每一位进行比较
        char[] secretArray = secret.toCharArray();
        char[] guessArray = guess.toCharArray();
        for (int i = 0; i < secretArray.length; i++) {
            if(secretArray[i]==(guessArray[i])){
                sizeA ++;
                map.put(secretArray[i], '1');
            }else {
                map.put(secretArray[i], '1');
                Character guessChar = map.put(guessArray[i], '1');
                if(guessChar!=null&&guessChar.equals('1')){
                    sizeB++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(sizeA).append('A').append(sizeB).append('B');
        return sb.toString();
            //1.1如果相等A前面的数字就+1
            //1.2如果不相等

    }

    public static void main(String[] args) {

        String secret = "1807";
        String guess = "7810";
        getHint(secret,guess);

    }

}
