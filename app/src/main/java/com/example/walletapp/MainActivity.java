package com.example.walletapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.Nullable;

/**
 * Main Activity - Home screen of the wallet application
 */
public class MainActivity extends Activity {

    private Button btnIncreaseLimitDemo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // For demo purposes, create a simple layout with a button
        // to navigate to the Increase Limit screen
        setupDemoLayout();
    }

    /**
     * Create a simple demo layout to test the Increase Limit screen
     */
    private void setupDemoLayout() {
        // Create a simple button programmatically for demo
        btnIncreaseLimitDemo = new Button(this);
        btnIncreaseLimitDemo.setText("View Increase Limit Status");
        btnIncreaseLimitDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Increase Limit Activity
                IncreaseLimitActivity.start(MainActivity.this, "REQ123456", "13 Mar 2025");
            }
        });
        
        setContentView(btnIncreaseLimitDemo);
    }
}