package com.example.mohamedabdelhameed.idontknowthenameofthegame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Card[] cards = new Card[9]; // to loop easy over all cards
    boolean[] places = new boolean[9];// to prevent repeat
    Button[] cardsBtns = new Button[9]; // holds all buttons in the screen
    int flagOfWhiteCard = 0;
    Card whiteCard = new Card(); // this moves with the clicked card
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i = 0; i < cards.length; i++){
            cards[i] = new Card();
        }

        cardsBtns[0] = (Button) findViewById(R.id.a);
        cardsBtns[1] = (Button) findViewById(R.id.b);
        cardsBtns[2] = (Button) findViewById(R.id.c);
        cardsBtns[3] = (Button) findViewById(R.id.a1);
        cardsBtns[4] = (Button) findViewById(R.id.b1);
        cardsBtns[5] = (Button) findViewById(R.id.c1);
        cardsBtns[6] = (Button) findViewById(R.id.a2);
        cardsBtns[7] = (Button) findViewById(R.id.b2);
        cardsBtns[8] = (Button) findViewById(R.id.c2);


        Random o = new Random();
        int j;
        int k = 0;
        for (Card i : cards){
            while(true){
                if(places[j=o.nextInt(9)] == false){
                    i.setValue(j);
                    i.setPlaceOnTable(k);
                    cardsBtns[k].setText(""+j+"");
                    cardsBtns[k].setOnClickListener(this);
                    k++;
                    k++;
                    k--;
                    places[j] = true;
                    break;
                }
            }
            if(i.getValue() == 0){
                whiteCard = i;
                flagOfWhiteCard = k - 1;
            }
        }
        cardsBtns[flagOfWhiteCard].setVisibility(View.INVISIBLE);

    }



    @Override
    public void onClick(View v) {
        int place = cards[flagOfWhiteCard].getPlaceOnTable();
        int row = place / 3;
        int column = place % 3;
        //Down Right Top Left
        int firstNeighbourPalce = (row + 1) * 3 + (column);
        int secondNeighbourPalce = (row) * 3 + (column + 1);
        int thirdNeighbourPalce = (row - 1) * 3 + (column);
        int fourthNeighbourPalce = (row) * 3 + (column - 1);
        if(row == 0){
            thirdNeighbourPalce = 100;
        }
        if(row == 2){
            firstNeighbourPalce = 100;
        }
        if(column == 0){
            fourthNeighbourPalce = 100;
        }
        if(column == 2){
            secondNeighbourPalce = 100;
        }
        Card cardClicked = cards[(Integer.parseInt(v.getTag().toString()))];
        if(cardClicked.getPlaceOnTable() == firstNeighbourPalce ||
                cardClicked.getPlaceOnTable() == secondNeighbourPalce ||
                cardClicked.getPlaceOnTable() == thirdNeighbourPalce ||
                cardClicked.getPlaceOnTable() == fourthNeighbourPalce){
            int value = Integer.parseInt(cardsBtns[Integer.parseInt(v.getTag().toString())].getText().toString());
            whiteCard.setValue(value);
            Button cardsBtn = cardsBtns[Integer.parseInt(v.getTag().toString())];
            cardsBtn.setText(""+0+"");
            cards[Integer.parseInt(v.getTag().toString())].setValue(0);
            cardsBtn.setVisibility(View.INVISIBLE);
            cardsBtns[flagOfWhiteCard].setText(""+value+"");
            cards[flagOfWhiteCard].setValue(value);
            cardsBtns[flagOfWhiteCard].setVisibility(View.VISIBLE);
            flagOfWhiteCard = Integer.parseInt(cardsBtn.getTag().toString());

        }

    }
}