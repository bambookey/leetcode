package com.lxy.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lixiangyu on 2018/11/4.
 */
public class Q036 {

    public static void main(String[] args) {
        Q036 q036 = new Q036();
        char[][] xx = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.println(q036.isValidSudoku(xx));
    }

    public boolean isValidSudoku(char[][] board) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j] == '.' ? 0 : board[i][j] - '0';
                int k1 = 100 + 10 * i + num;
                int k2 = 200 + 10 * j + num;
                int k3 = 300 + 10 * (3 * (i / 3) + (j / 3)) + num;
                if (!set.add(k1) || !set.add(k2) || !set.add(k3)) {
                    return false;
                }
            }
        }
        return true;
    }
}
