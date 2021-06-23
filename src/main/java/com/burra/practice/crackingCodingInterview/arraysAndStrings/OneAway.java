package com.burra.practice.crackingCodingInterview.arraysAndStrings;

//There are 3 types of operations you can perform on two string, to make them identical which are insert, replace, remove
// check if string can equal with only one operation.
public class OneAway {
    public boolean canMakeEqualWithOneOperation(String s1, String s2) {
        int abs = Math.abs(s1.length() - s2.length());
        if(abs > 1)
            return false;
        if(abs == 1) {
            return isInsertOrRemovePossible(s1, s2);
        }
        return isReplacePossible(s1,s2);
    }

    private boolean isReplacePossible(String s1, String s2) {
        int i1 = 0;
        int i2 = 0;
        boolean flag= false;
        while (i1 < s1.length() && i2 < s2.length()) {
            if(s1.charAt(i1) != s2.charAt(i2)) {
                if(!flag)
                    flag = true;
                else
                    return false;
            }
            i1++;
            i2++;
        }
        return true;
    }

    private boolean isInsertOrRemovePossible(String s1, String s2) {
        String small = s1.length() > s2.length() ? s2 : s1;
        String large = s1.length() > s2.length() ? s1 : s2;
        int i1 = 0;
        int i2 = 0;
        while(i1 < small.length() && i2 < large.length()) {
            if(small.charAt(i1) != large.charAt(i2)) {
                if(i1 != i2){
                    return false;
                }
            }
            else {
                i1++;
            }
            i2++;
        }
        return true;
    }

}
