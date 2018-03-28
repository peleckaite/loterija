package ems.vtvpmc.loterija;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    private TextView luckyNumbersTextView;
    private Button luckyNumbersButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        luckyNumbersTextView = (TextView) findViewById(R.id.luckyNumbersTextView);
        luckyNumbersButton = (Button) findViewById(R.id.luckyNumbersButton);

        luckyNumbersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Integer> allNumbers = new ArrayList<>();
                for (int i = 1 ; i <= 75; i++) {
                    allNumbers.add(i);
                }
                Collections.shuffle(allNumbers);

                ArrayList<Integer> luckyNumbers = new ArrayList<>();
                for (int i = 0 ; i < 5; i++){
                    luckyNumbers.add(allNumbers.get(i));
                }
                Collections.sort(luckyNumbers);

//                luckyNumbersTextView.setText(luckyNumbers.toString());
                StringBuilder sb = new StringBuilder();
                for (int element:luckyNumbers) {
                    sb.append(String.valueOf(element));
                    sb.append(", ");
                }
                luckyNumbersTextView.setText(sb.toString().replaceAll(", $",""));
            }
        });

    }
}
