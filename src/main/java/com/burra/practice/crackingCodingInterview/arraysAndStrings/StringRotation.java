package com.burra.practice.crackingCodingInterview.arraysAndStrings;

// You can Perform only isSubString() operation on any string, find if string s1 is a rotated version of String s2
public class StringRotation {
    //
    public boolean isRotatedVersion(String s1, String s2) {
        if(s1.length() != s2.length())
            return false;
        return isSubString(s1+s1, s2);
    }

    private boolean isSubString(String s, String s2) {
        return s.contains(s2);
    }
}
