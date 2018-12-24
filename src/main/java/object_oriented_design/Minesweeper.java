package object_oriented_design;

import java.util.Arrays;

/**
 * Design and implement a Minesweeper game for a single-player with a size of NxN grid that has B mines (bombs).
 * When a player uncover a cell,
 * - if is a bomb, the player loses,
 * - if it is a number, the number is exposed.
 * - if it is a blank cell, this cell and all adjacent blank cells (up to and including the surrounding numeric cells)
 * are exposed.
 * The player wins when all non-bomb cells are exposed.
 * ***
 * - Cracking the coding interview, a book by Gayle Mcdowell (6th ed., q 7.10) - question edited
 * ***
 * Disclaimer: This is a very basic prototype with no OOD!
 * OOD = Object Oriented Design
 * TODO Rebuild this using better OOD.
 */
public class Minesweeper {
    private char[][] cells;
    private char[][] board;
    private boolean lost = false;

    public Minesweeper(char[][] cells) {
        if (cells.length < 1 || cells[0].length < 1 || cells.length != cells[0].length) {
            System.err.println("The board must be squared and with a minimal size of 1x1");
        }
        this.cells = cells;
        this.board = new char[cells.length][cells[0].length];
        for (char[] chars : board) Arrays.fill(chars, 'X');
    }

    void showBoard() {
        for (char[] chars : board) {
            for (char c : chars) {
                if (c == ' ') c = '_';
                System.out.print(c + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    void click(int row, int col) {
        clickHelper(row, col);
        if (lost) {
            System.out.println(">>>>> YOU LOST <<<<<\n");
            return;
        }

        checkIfWin();
    }

    // TODO: this info should be updated while playing and not checked every time!
    private void checkIfWin() {
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++)
                if (board[i][j] == 'X' && cells[i][j] != '*') return;
        System.out.println(">>>>> YOU WON <<<<<\n");
    }

    private void clickHelper(int row, int col) {
        if (!inBounds(row, col) || board[row][col] != 'X') return;
        char c = cells[row][col];
        board[row][col] = c;
        if (c == '*') {
            lost = true;
            return;
        }

        if (c == ' ') {
            for (int i = row - 1; i <= row + 1; i++) {
                for (int j = col - 1; j <= col + 1; j++) {
                    if (inBounds(i, j) && (i != row || j != col))
                        click(i, j);
                }
            }
        }
    }

    private boolean inBounds(int row, int col) {
        return row >= 0 && row < cells.length && col >= 0 && col < cells[row].length;
    }

}

class TestMinesweeper {

    public static void main(String[] args) {
        win();
        System.out.println("###################################");
        lose();
    }

    @SuppressWarnings("Duplicates")
    private static void lose() {
        Minesweeper minesweeper = init();
        minesweeper.showBoard();
        minesweeper.click(3, 0);
        minesweeper.click(3, 1);
        minesweeper.showBoard();

        minesweeper.click(1, 1);
        minesweeper.showBoard();
    }

    @SuppressWarnings("Duplicates")
    private static void win() {
        Minesweeper minesweeper = init();
        minesweeper.showBoard();
        minesweeper.click(3, 0);
        minesweeper.click(3, 1);
        minesweeper.showBoard();

        minesweeper.click(0, 1);
        minesweeper.showBoard();

        minesweeper.click(1, 0);
        minesweeper.showBoard();
    }

    private static Minesweeper init() {
        char[][] game = {{'*', '2', '1', ' '}, {'2', '*', '1', ' '}, {'1', '1', '1', ' '}, {' ', ' ', ' ', ' '}};
        return new Minesweeper(game);
    }
}