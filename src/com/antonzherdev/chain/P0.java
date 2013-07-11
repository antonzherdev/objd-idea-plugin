package com.antonzherdev.chain;

public interface P0 {
    void p();

    public static P0 EMPTY = new P0() {
        @Override
        public void p() {
        }
    };
}
