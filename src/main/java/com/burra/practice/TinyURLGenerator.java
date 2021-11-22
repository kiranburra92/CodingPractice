package com.burra.practice;

/**
 * Assuming all the big urls are uniquely identified by Unique ID (Integer) from database. Tiny URL contains
 * [a-z|A-Z|0-9].
 * <p>
 * NOTE: Not using hash function  to convert large string to small string because it leads to collision i.e., tiny url
 * will give more than one big url when expanded.
 */
public class TinyURLGenerator {

  /**
   * Given an integer unique ID from database, converting to tiny string using log(62) since a-z, A-Z, 0-9 combined is
   * 62.
   */

  public static String idToShortURL(long n) {
    String tinyURL = "";
    String allCharacter = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    while (n > 0) {
      tinyURL = tinyURL + allCharacter.charAt((int) (n % 62));
      n = n / 62;
    }
    StringBuilder sb = new StringBuilder(tinyURL);
    return sb.reverse().toString();
  }

  /**
   * Given a tiny url, converting back to unqiue ID.
   */
  public static long urlToID(String s) {
    long n = 0;

    for (char c : s.toCharArray()) {
      if (c >= 'a' && c <= 'z') {
        n = n * 62 + (int) c - (int) 'a';
      }
      if (c >= 'A' && c <= 'Z') {
        n = n * 62 + (int) c - (int) 'A' + 26;
      }
      if (c >= '0' && c <= '9') {
        n = n * 62 + (int) c - (int) '9' + 52;
      }
    }
    return n;
  }

  public static void main(String args[]) {
    int n = 123456789;
    System.out.println(idToShortURL(n));
    System.out.println(urlToID(idToShortURL(n)));

  }

}
