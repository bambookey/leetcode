package com.lxy.leetcode;

/**
 * Created by lixiangyu on 2018/9/12.
 */
public class Q419 {
    public int countBattleships(char[][] board) {
        if(board.length == 0 || board[0].length == 0) {
            return 0;
        }
        int ret = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    ret++;
                    dig(board, i, j);
                }
            }
        }
        return ret;
    }

    public void dig(char[][] board, int i, int j) {
        if (i >= 0 && i < board.length && j >= 0 && j < board[0].length) {
            if(board[i][j] == 'x') {
                return;
            }
            if(board[i][j] == 'X') {
                board[i][j] = 'x';
                dig(board, i + 1, j);
                dig(board, i - 1, j);
                dig(board, i, j + 1);
                dig(board, i, j - 1);
            }
        }
    }
}
