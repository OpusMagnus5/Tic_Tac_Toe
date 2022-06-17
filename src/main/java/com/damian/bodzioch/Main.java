package com.damian.bodzioch;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int turn = 0;
        int win = 0;
        do {
            turn++;
            Board.getBoardInstance().showMenuBoard();
            if (turn % 2 == 0) {
                System.out.print("Podaj " + Marks.X.getSymbol() + ": ");
                Board.getBoardInstance().addMark(Marks.X, in.nextInt());
            } else {
                System.out.print("Podaj " + Marks.O.getSymbol() + ": ");
                Board.getBoardInstance().addMark(Marks.O, in.nextInt());
            }
            Board.getBoardInstance().showBoard();
            if (turn % 2 == 0){
                win = Board.getBoardInstance().checkWinning(Marks.X);
            } else{
                win = Board.getBoardInstance().checkWinning(Marks.O);
            }
        }while (win == 0);

        if (win == 2){
            System.out.println("REMIS");
        } else {
            if (turn % 2 == 0){
                System.out.println(Marks.X.getSymbol() + " wygrywa!");
            }else {
                System.out.println(Marks.O.getSymbol() + " wygrywa!");
            }
        }
    }
}
