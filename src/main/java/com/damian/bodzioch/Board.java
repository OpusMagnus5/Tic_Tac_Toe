package com.damian.bodzioch;

import java.util.Arrays;

public class Board {
   public char[][] board = new char[3][3];

   private static final Board boardInstance = new Board();

   private Board(){
      for (int i = 0; i < this.board.length; i++){
         Arrays.fill(this.board[i], Marks.VOID.getSymbol());
      }

   }

   public static Board getBoardInstance(){
      return boardInstance;
   }

   public void showMenuBoard(){
      for (int i = 0; i < this.board.length; i++){
         for (int j = 1; j <= this.board[i].length; j++){
            System.out.print(i * this.board.length + j);
            if (j < this.board.length) {
               System.out.print("|");
            }
         }
         System.out.println();
      }
      System.out.println();
   }

   public void showBoard(){
      for (int i = 0; i < this.board.length; i++){
         for (int j = 0; j < this.board[i].length; j++){
            System.out.print(board[i][j]);
            if (j < this.board.length - 1) {
               System.out.print("|");
            }
         }
         System.out.println();
      }
      System.out.println();
   }

   public void addMark(Marks mark, int field){
      if (field >= 1 && field <= 3){
         this.board[0][field - 1] = mark.getSymbol();
      }else if (field >= 4 && field <= 6){
         this.board[1][field - 4] = mark.getSymbol();
      }else {
         this.board[2][field - 7] = mark.getSymbol();
      }
   }

   public int checkWinning (Marks mark){
      int count1 = 0;
      int count2 = 0;
      int count3 = 0;
      for (int i = 0; i < this.board.length; i++){
         for (int j = 0; j < this.board[i].length; j++){
            if (this.board[i][j] == mark.getSymbol()){
               count1++;
            }
            if (count1 == this.board.length){
               return 1;
            }
            if (this.board[j][i] == mark.getSymbol()){
               count2++;
            }
            if (count2 == this.board.length) {
               return 1;
            }
            if (this.board[i][j] != Marks.VOID.getSymbol()){
               count3++;
            }
            if (count3 == 9){
               return 2;
            }
         }
         count1 = 0;
         count2 = 0;
      }
      count1 = 0;
      count2 = 0;
      for (int i = 0; i < this.board.length; i++){
         if (this.board[i][i] == mark.getSymbol()){
            count1++;
         }
         if (count1 == this.board.length){
            return 1;
         }
         if (this.board[i][this.board.length - i - 1] == mark.getSymbol()){
            count2++;
         }
         if (count2 == this.board.length){
            return 1;
         }
      }
      return 0;
   }


}
