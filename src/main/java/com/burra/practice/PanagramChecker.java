package com.burra.practice;

import java.util.Arrays;

public class PanagramChecker {
    public static boolean check(String s) {
        boolean[] hash = new boolean[26];
        Arrays.fill(hash, false);
        for(char c: s.toCharArray())
        {
            if(c >= 'a' && c <= 'z'){
                if(hash[c-'a'] == false)
                    hash[c-'a'] = true;
            }
            else if(c >= 'A' && c<= 'Z') {
                if(hash[c-'A'] == false)
                    hash[c-'A'] = true;
            }
        }

        for(boolean b: hash)
        {
            if(b == false)
                return false;
        }
        return true;
    }

    public static String charsRequired(String s)
    {
        String required = "";
        boolean[] hash = new boolean[26];
        Arrays.fill(hash, false);
        for(char c: s.toCharArray())
        {
            if(c >= 'a' && c <= 'z'){
                if(hash[c-'a'] == false)
                    hash[c-'a'] = true;
            }
            else if(c >= 'A' && c<= 'Z') {
                if(hash[c-'A'] == false)
                    hash[c-'A'] = true;
            }
        }
        for(int i=0;i<hash.length;i++)
        {
            if(hash[i] == false){
                char c = (char)(i+'a');
                required = c+required;
            }
        }
        return required;
    }
    public static void main(String[] args) {
        String s = "abcdefghijklmnopqrstuvwxyz";
        String s1 = "abcdefghijlmnopqstuvwxyz";
        String s2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String s3 = "ABCDEFGHIJLMNOPQRSTUWXYZ";
        System.out.println(check(s));
        System.out.println(check(s1));
        System.out.println(check(s2));
        System.out.println(check(s3));
        System.out.println(charsRequired(s1));
        System.out.println(charsRequired(s3));
    }
}
