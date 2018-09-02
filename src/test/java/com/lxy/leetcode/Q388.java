package com.lxy.leetcode;

import java.util.Stack;

/**
 * 主要是stack的使用，性能不大好，有优化的空间
 *
 * Created by lixiangyu on 2018/9/2.
 */
public class Q388 {

    public static void main(String[] args) {
        String x = "a\n\tb1\n\t\tf1.txt\n\taaaaa\n\t\tf2.txt";
        System.out.println(lengthLongestPath(x));
    }
    public static int lengthLongestPath(String input) {
        int max = 0;
        Stack<String> stack = new Stack<>();
        String[] fileStructure = input.split("\n");
        stack.push(fileStructure[0]);
        if(fileStructure[0].contains(".")) {
            return fileStructure[0].length();
        }

        int currLen = fileStructure[0].length();

        for(int i = 1 ; i < fileStructure.length;i++) {

            String pathSeg = fileStructure[i];
            int curDepth = 1;
            while(pathSeg.startsWith("\t")) {
                curDepth++;
                pathSeg = pathSeg.substring(1);
            }
            if(curDepth > stack.size()) {
                stack.push(pathSeg);
            } else if(curDepth == stack.size()) {
                stack.pop();
                stack.push(pathSeg);
            } else {
                while(stack.size() > curDepth) {
                    stack.pop();
                }
                stack.pop();
                stack.push(pathSeg);
            }
            System.out.println(stack);

            if(pathSeg.contains(".")) {
                int length = 0;
                for(String path : stack) {
                    length += path.length();
                    length += 1;
                }
                length -=1;
                if(length>max) {
                    max = length;
                }
            }
        }
        return max;

    }
}
