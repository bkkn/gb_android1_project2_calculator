package me.bkkn.gb_android1_project2_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Button> digitButtonList;
    private ArrayList<Integer> digitButtonResourceList;
    private TextView output;

    void appendToOutputOnButtonPressed(Button button) {
        output.setText(output.getText().toString() + button.getText());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDigitButtons();
        output = findViewById(R.id.screen_edit_text);
        initOperations();
    }

    private void initDigitButtons() {
        initResourceList();
        initDigitButtonList();
    }

    private void initOperations() {
        findViewById(R.id.plus_button).setOnClickListener(v -> appendToOutputOnButtonPressed((Button) v));
        findViewById(R.id.minus_button).setOnClickListener(v -> appendToOutputOnButtonPressed((Button) v));
        findViewById(R.id.multiply_button).setOnClickListener(v -> appendToOutputOnButtonPressed((Button) v));
        findViewById(R.id.divide_button).setOnClickListener(v -> appendToOutputOnButtonPressed((Button) v));
        findViewById(R.id.equals_button).setOnClickListener(v -> {
            appendToOutputOnButtonPressed((Button) v);
            appendResultOfCalculation();
        });

        findViewById(R.id.clear_button).setOnClickListener(v -> output.setText(""));
        findViewById(R.id.backspace_button).setOnClickListener(v -> {
            String text = (String) output.getText();
            if (!text.isEmpty())
                output.setText(text.subSequence(0, text.length() - 1));
        });
    }

    private void appendResultOfCalculation() {

    }

    private void initSpecialButtons() {
        findViewById(R.id.dot_button).setOnClickListener(v -> appendToOutputOnButtonPressed((Button) v));
        findViewById(R.id.sign_button).setOnClickListener(v -> doComplicatedStuffOnButtonPressed((Button) v));
    }

    private void doComplicatedStuffOnButtonPressed(Button v) {
        //TODO: insert '-' before or multiply the answer by -1
    }

    void initResourceList() {
        digitButtonResourceList = new ArrayList<Integer>(Arrays.asList(
                R.id.digit_zero_button,
                R.id.digit_one_button,
                R.id.digit_two_button,
                R.id.digit_three_button,
                R.id.digit_four_button,
                R.id.digit_five_button,
                R.id.digit_six_button,
                R.id.digit_seven_button,
                R.id.digit_eight_button,
                R.id.digit_nine_button));
    }

    void initDigitButtonList() {
        digitButtonList = new ArrayList<>();
        for (int resourceId : digitButtonResourceList) {
            final Button[] button = {findViewById(resourceId)};
            button[0].setOnClickListener(v -> appendToOutputOnButtonPressed(button[0]));
            digitButtonList.add(button[0]);
        }
    }

}