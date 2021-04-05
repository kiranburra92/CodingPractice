package com.burra.practice.javaRnD;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamMap {
    public static void getGadgetDescriptors() {
        List<String> myList = Arrays.asList("A", "B", "C");
        Function<String, String> dp = s -> doProcess(s);
        myList.stream().map(dp).collect(Collectors.toList()).forEach(System.out::println);

    }

    public static String doProcess(String s) {
        return s+"12";
    }
    public static void main(String[] args) {
    getGadgetDescriptors();
    }
}
