package me.bkkn.gb_android1_project2_calculator;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import me.bkkn.gb_android1_project2_calculator.model.Expression;

public class LookupActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lookup_activity);

        final WebView webView = (WebView) findViewById(R.id.web_view);
        Intent intent = getIntent();
        Expression expression = ((Expression) getIntent().getParcelableExtra(Expression.KEY));
        String input = expression.toString();
        double result = expression.evaluate();

        String query = expression.toString();
        if (!query.contains("="))
            query += "=";
        query.replace("+", "%2B");
        String url = "https://www.google.com/search?q=" + query;
        webView.loadUrl(url);
    }
}
