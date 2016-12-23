package com.example.mohamedabdelhameed.idontknowthenameofthegame;

import android.content.Context;
import android.widget.Button;

/**
 * Created by MohamedAbdElhameed on 9/4/2016.
 */
public class Card {
    private int value;
    private int placeOnTable;


    public void setValue(int value){ this.value = value; }

    public int getValue(){
        return this.value;
    }

    public void setPlaceOnTable(int placeOnTable) { this.placeOnTable = placeOnTable; }

    public int getPlaceOnTable() { return placeOnTable;}


}