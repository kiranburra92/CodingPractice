package com.burra.practice.javaRnD;

import java.nio.charset.StandardCharsets;

public class ByteCodeString {
    public static void main(String[] args){
      byte[] b = new byte[] {0x66};
      String s = new String(b, StandardCharsets.UTF_8);
      System.out.println(s);
      for (byte aByte : s.getBytes(StandardCharsets.US_ASCII)) {
          System.out.println(aByte);
      }
    }
}
