package com.burra.practice.crackingCodingInterview.arraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class CheckTwoStringArePermutations {
    public static boolean checkStringsArePermutations(String s1, String s2) {
        if(s1.length() != s2.length())
            return false;
        int[] flag = new int[128];
        for(int i = 0; i <s1.length() ;i ++) {
            flag[s1.charAt(i)]++;
            flag[s2.charAt(i)]--;
        }
        for(int i : flag) {
            if(i != 0)
                return false;
        }
        return true;
    }
}
