package com.antonzherdev.objd;

public class FlexState {
    private final int state;
    int stringBracketCounter;
    boolean stringIdent;

    public FlexState(int state) {
        this.state = state;
    }


    public int getState() {
        return state;
    }
}
