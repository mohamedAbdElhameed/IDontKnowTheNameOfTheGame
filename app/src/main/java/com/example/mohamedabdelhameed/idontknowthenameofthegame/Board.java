package com.example.mohamedabdelhameed.idontknowthenameofthegame;

/**
 * Created by MohamedAbdElhameed on 9/4/2016.
 */
public class Board {
    public Card[] cardsOnBorad ;
    private int size;
    public Board(Card[] cardsOnBorad, int size){
        this.size = size;
        this.cardsOnBorad = new Card[size];
        this.cardsOnBorad = cardsOnBorad;
    }


}
