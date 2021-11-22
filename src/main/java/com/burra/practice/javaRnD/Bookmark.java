package com.burra.practice.javaRnD;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class myList {

  String name;
  String url;

  myList(String name, String url) {
    this.name = name;
    this.url = url;
  }

  public String getName() {
    return name;
  }

  public String getUrl() {
    return url;
  }
}

public class Bookmark {

  public static void main(String args[]) {
    List<myList> currentList = new ArrayList<>();
    currentList.add(new myList("google", "google"));
    currentList.add(new myList("google1", "google1"));
    currentList.add(new myList("google2", "google2"));
    currentList.add(new myList("google3", "google3"));
    currentList.add(new myList("google4", "google4"));
    currentList.add(new myList("google1", "google1"));

//        String duplicateBookmarks = currentList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
//                .filter(e -> e.getValue() > 1L).map(e -> e.getKey().getName()).collect(Collectors.joining(","));
//        System.out.println(duplicateBookmarks + "aDASD");
//        for(myList m: currentList){
//            System.out.println(m.getName());
//            if(m.getName().equals("google2"))
//                return;
//        }
    Set<String> unique = new HashSet<>();
    for (myList b : currentList) {
      if (unique.contains(b.getName())) {
        System.out.println(b.getName());
        return;
      }
      unique.add(b.getName());
    }
    boolean flag = currentList.stream().anyMatch(o -> {
      if (unique.contains(o.getName())) {
        return true;
      }
      unique.add(o.getName());
      return false;
    });

    System.out.println(flag + " after loop");
  }
}
