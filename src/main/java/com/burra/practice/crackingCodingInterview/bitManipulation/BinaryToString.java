package com.burra.practice.crackingCodingInterview.bitManipulation;

// Given a real number from 0 to 1 eg) 0.72 convert to binary number, if cannot represent in 32 characters return error
public class BinaryToString {
    public String convert(double n) {
        StringBuilder sb = new StringBuilder();
        sb.append(".");
        while (n != 0) {
            if(sb.length() > 32)
                return "ERROR";
            double tmp = n*2;
            if(tmp >= 1) {
                sb.append("1");
                n = n-tmp;
            }
            else {
                sb.append("0");
                n = tmp;
            }
        }
        return sb.toString();
    }
}
