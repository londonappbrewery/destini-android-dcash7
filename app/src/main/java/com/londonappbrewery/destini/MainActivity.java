package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    Button mOne;
    Button mTwo;
    TextView Texty;
    int state;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mOne = (Button) findViewById(R.id.buttonTop);
        mTwo = (Button) findViewById(R.id.buttonBottom);
        Texty = (TextView) findViewById(R.id.storyTextView);

        if (savedInstanceState != null) {
            state = savedInstanceState.getInt("StateKey");
            if (state == 1) {
                Texty.setText(R.string.T1_Story);
                mOne.setText(R.string.T1_Ans1);
                mTwo.setText(R.string.T1_Ans2);
            } else if (state == 2) {
                Texty.setText(R.string.T2_Story);
                mOne.setText(R.string.T2_Ans1);
                mTwo.setText(R.string.T2_Ans2);
            }
            else if (state == 4) {
                Texty.setText(R.string.T4_End);
                mOne.setVisibility(View.GONE);
                mTwo.setVisibility(View.GONE);
            }
            else if (state == 5) {
                Texty.setText(R.string.T5_End);
                mOne.setVisibility(View.GONE);
                mTwo.setVisibility(View.GONE);
            }
            else if (state == 6) {
                Texty.setText(R.string.T6_End);
                mOne.setVisibility(View.GONE);
                mTwo.setVisibility(View.GONE);
            }
            else {
                Texty.setText(R.string.T3_Story);
                mOne.setText(R.string.T3_Ans1);
                mTwo.setText(R.string.T3_Ans2);
            }
        } else {
            state = 1;
        }


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mOne.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (state == 1) {
                    Texty.setText(R.string.T3_Story);
                    mOne.setText(R.string.T3_Ans1);
                    mTwo.setText(R.string.T3_Ans2);
                    state = 3;
                }
                else if (state == 2){
                    Texty.setText(R.string.T3_Story);
                    mOne.setText(R.string.T3_Ans1);
                    mTwo.setText(R.string.T3_Ans2);
                    state = 3;
                }else {
                    Texty.setText(R.string.T6_End);
                    mOne.setVisibility(View.GONE);
                    mTwo.setVisibility(View.GONE);
                    state = 6;
                }
        }

    });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (state == 1) {
                    Texty.setText(R.string.T2_Story);
                    mOne.setText(R.string.T2_Ans1);
                    mTwo.setText(R.string.T2_Ans2);
                    state = 2;
                }
                else if (state == 2){
                    Texty.setText(R.string.T4_End);
                    mOne.setVisibility(View.GONE);
                    mTwo.setVisibility(View.GONE);
                    state = 4;
                }else {
                    Texty.setText(R.string.T5_End);
                    mOne.setVisibility(View.GONE);
                    mTwo.setVisibility(View.GONE);
                    state = 5;
                }
            }
        });

    }
    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        outState.putInt("StateKey", state);
    }
}
