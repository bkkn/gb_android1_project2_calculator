package me.bkkn.gb_android1_project2_calculator;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import me.bkkn.gb_android1_project2_calculator.model.Expression;

public class LookupActivity extends AppCompatActivity {
    private static final String TAG = "@@@ Lookup";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lookup_activity);
        ((TextView) findViewById(R.id.lookup_edit_text))
                .setText(((Expression) getIntent()
                        .getSerializableExtra(Expression.KEY)).toString());
    }
}
