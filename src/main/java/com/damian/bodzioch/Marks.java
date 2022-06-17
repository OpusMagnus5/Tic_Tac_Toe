package com.damian.bodzioch;

public enum Marks {
    X('X'),
    O('O'),
    VOID(' ');

    private final char symbol;

    Marks(char symbol){
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}
