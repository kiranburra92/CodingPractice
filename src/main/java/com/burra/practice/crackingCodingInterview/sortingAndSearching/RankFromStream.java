package com.burra.practice.crackingCodingInterview.sortingAndSearching;

// Reading a stream of integers, periodically you wish to look up the rank of a number x. Rank of number is no. of
// elements less that the current number.
public class RankFromStream {

  // binary tree with size of left subtree as rank.
  public int rank = 0;
  public RankFromStream left, right;
  public int data = 0;

  public RankFromStream(int d) {
    this.data = d;
  }

  public void insert(int d) {
    if (d < data) {
      if (left != null) {
        left.insert(d);
      } else {
        left = new RankFromStream(d);
      }
      rank++;
    } else {
      if (right != null) {
        right.insert(d);
      } else {
        right = new RankFromStream(d);
      }
    }
  }

  public int getRank(int d) {
    if (data == d) {
      return rank;
    } else if (d < data) {
      if (left == null) {
        return -1;
      }
      return left.getRank(d);
    }
    int right_rank = right == null ? -1 : right.getRank(d);
    if (right_rank == 1) {
      return -1;
    }
    return rank + 1 + right_rank;
  }

}
