package org.mrstm;

import org.mrstm.factories.piece.Piece;
import org.mrstm.models.Board;

import java.util.Objects;


public class GameManager {
    private final Board board;

    public GameManager(Board board) {
        this.board = board;
    }

    public void draw(Piece piece, int row, int col) {
        if(Objects.nonNull(board.getLastPlayer()) && board.getLastPlayer().equals(piece)){
            System.out.println("It's not your turn.");
        }else{
            if(Objects.nonNull(board.getPlayground()[row][col])){
//                System.out.println("Invalid move, this position is already filled.");
                throw new IllegalArgumentException("Invalid move, this position is already filled");
            }

            System.out.println("Placing your move... Please wait...");
            board.setLastPlayer(piece);
            assert piece != null;
            board.getPlayground()[row][col] = piece.getInstance();
            System.out.println("Printing current board... Please wait...");
            if(checkWinner(board , row, col)){
                System.out.println("Winner found: " + piece.getInstance() + " is winner.");
            }
            printBoard(board);
        }
    }

    private void printBoard(Board board){
        for(int i = 0; i < board.getSize(); i++){
            for(int j = 0; j < board.getSize(); j++){
                System.out.print(board.getPlayground()[i][j] + " ");
            }
            System.out.println();
        }
    }
    static int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            { 0, -1},          { 0, 1},
            { 1, -1}, { 1, 0}, { 1, 1}
    };

    private boolean checkWinner(Board board, int row, int col){
        int maxSize = board.getSize();

        //in row
        int sum = 0;
        for(int i = 0; i < maxSize; i++){
            sum += (board.getLastPlayer().getInstance().equals(board.getPlayground()[row][i])) ? 1 : 0;
        }
        if(sum == maxSize){
            return true;
        }

        //in col
        sum = 0;
        for(int i = 0; i < maxSize; i++){
            sum += (board.getLastPlayer().getInstance().equals(board.getPlayground()[i][col])) ? 1 : 0;
        }
        if(sum == maxSize){
            return true;
        }

        // left diag from top
        sum = 0;
        int i = 0;
        while(i < maxSize){
            sum += (board.getLastPlayer().getInstance().equals(board.getPlayground()[i][i])) ? 1 : 0;
            i++;
        }
        if(sum == maxSize){
            return true;
        }

        // right diag from top
        sum = 0;
        i = maxSize - 1;
        int j = 0;
        while(i >= 0 && j < maxSize){
            sum += (board.getLastPlayer().getInstance().equals(board.getPlayground()[j][i])) ? 1 : 0;
            i--;
            j++;
        }
        if(sum == maxSize){
            return true;
        }

        return false;
    }
}
