package com.burra.practice.crackingCodingInterview.arraysAndStrings;

// insert %20 in all blank in string
public class URLifyCharArray {
    public static char[] urlify(char[] c, int length) {
        int spaceCount = 0;
        for(int i = 0 ; i < length ;i++) {
            if(c[i] == ' ')
                spaceCount++;
        }
        int futureLength = length + 2*spaceCount;
        if(length < c.length) c[length] = '\0';
        for(int i = length-1 ; i >=0 ; i--) {
            if (c[i] != ' '){
                c[futureLength-1] = c[i];
                futureLength--;
            }
            else {
                c[futureLength-1] = '0';
                c[futureLength-2] = '2';
                c[futureLength-3] = '%';
                futureLength = futureLength-3;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(urlify(new char[]{'a', ' ', 'b', ' ', ' ', ' '}, 3));
    }
}
