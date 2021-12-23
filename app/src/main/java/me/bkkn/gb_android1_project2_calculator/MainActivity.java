package me.bkkn.gb_android1_project2_calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.bkkn.gb_android1_project2_calculator.model.Expression;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "@@@";
    private List<Button> digitButtonList;
    private ArrayList<Integer> digitButtonResourceList;
    private TextView output;
    private Button lookupButton;

    void appendToOutputOnButtonPressed(Button button) {
        output.setText(output.getText().toString() + button.getText());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]");
        initDigitButtons();
        output = findViewById(R.id.output_text_view);
        initOperations();
        initSpecialButtons();

        if(savedInstanceState != null && savedInstanceState.containsKey(Expression.KEY))
            output.setText(((Expression)savedInstanceState.get(Expression.KEY)).toString());
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        Log.d(TAG, "onConfigurationChanged() called with: newConfig = [" + newConfig + "]");
        super.onConfigurationChanged(newConfig);
        // WHY HAS IT NEVER BEEN CALLED ?
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d(TAG, "onSaveInstanceState() called with: outState = [" + outState + "]");
        outState.putParcelable(Expression.KEY, new Expression(output.getText()));
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        Log.d(TAG, "onRestoreInstanceState() called with: savedInstanceState = [" + savedInstanceState + "]");
        super.onRestoreInstanceState(savedInstanceState);
        String str = ((Expression) savedInstanceState.getParcelable(Expression.KEY)).toString();
        output.setText(str);
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
        lookupButton = findViewById(R.id.lookup_button);
        lookupButton.setOnClickListener(view -> {
            startActivity(new Intent().setClass(this,LookupActivity.class).putExtra(Expression.KEY, new Expression(output.getText())));
        });
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