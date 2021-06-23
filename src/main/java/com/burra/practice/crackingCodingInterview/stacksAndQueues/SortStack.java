package com.burra.practice.crackingCodingInterview.stacksAndQueues;

import java.util.Stack;

public class SortStack {
    private Stack<Integer> bufferStack = new Stack<>();

    public Stack<Integer> sort(Stack<Integer> s) {

        while (!s.isEmpty()){
            int temp = s.pop();
            while (!bufferStack.isEmpty() && bufferStack.peek() > temp) {
                s.push(bufferStack.pop());
            }
            bufferStack.push(temp);
        }

        while (!bufferStack.isEmpty()) {
            s.push(bufferStack.pop());
        }
        return s;
    }
}
