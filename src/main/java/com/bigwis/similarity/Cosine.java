package com.bigwis.similarity;

/**
 * Created by Administrator on 2017/4/13.
 */

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Cosine {

    Map<Character, int[]> vectorMap = new HashMap<Character, int[]>();

    int[] tempArray = null;

    public Cosine(String string1, String string2) {
        if (string1 != null && string1.trim().length() > 0 && string2 != null && string2.trim().length() > 0) {
            for (Character character1 : string1.toCharArray()) {
                if (vectorMap.containsKey(character1)) {
                    vectorMap.get(character1)[0]++;
                } else {
                    tempArray = new int[2];
                    tempArray[0] = 1;
                    tempArray[1] = 0;
                    vectorMap.put(character1, tempArray);
                }
            }
            for (Character character2 : string2.toCharArray()) {
                if (vectorMap.containsKey(character2)) {
                    vectorMap.get(character2)[1]++;
                } else {
                    tempArray = new int[2];
                    tempArray[0] = 0;
                    tempArray[1] = 1;
                    vectorMap.put(character2, tempArray);
                }
            }
        }
    }

    // 求余弦相似度
    public double getConsin() {
        double result = 0;
        result = pointMulti(vectorMap) / sqrtMulti(vectorMap);
        return result;
    }

    private double sqrtMulti(Map<Character, int[]> paramMap) {
        double result = 0;
        result = squares(paramMap);
        result = Math.sqrt(result);
        return result;
    }

    // 求平方和
    private double squares(Map<Character, int[]> paramMap) {
        double result1 = 0;
        double result2 = 0;
        Set<Character> keySet = paramMap.keySet();
        for (Character character : keySet) {
            int temp[] = paramMap.get(character);
            result1 += (temp[0] * temp[0]);
            result2 += (temp[1] * temp[1]);
        }
        return result1 * result2;
    }

    // 点乘法
    private double pointMulti(Map<Character, int[]> paramMap) {
        double result = 0;
        Set<Character> keySet = paramMap.keySet();
        for (Character character : keySet) {
            int temp[] = paramMap.get(character);
            result += (temp[0] * temp[1]);
        }
        return result;
    }

//    public static void main(String[] args) {
//        String s1 = "我是一个帅哥";
//        String s2 = "帅哥是我";
//        Cosine cosine = new Cosine(s1, s2);
//        System.out.println(cosine.getConsin());
//    }

}