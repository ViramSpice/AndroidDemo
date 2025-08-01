package com.example.walletapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.Nullable;

/**
 * Activity for displaying the Increase Limit request status screen.
 * This screen shows the user that their wallet limit increase request
 * has been submitted and is under review.
 */
public class IncreaseLimitActivity extends Activity {

    private ImageView btnBack;
    private Button btnBackToHome;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_increase_limit);
        
        initializeViews();
        setupClickListeners();
    }

    /**
     * Initialize all view components
     */
    private void initializeViews() {
        btnBack = findViewById(R.id.btn_back);
        btnBackToHome = findViewById(R.id.btn_back_to_home);
    }

    /**
     * Set up click listeners for interactive elements
     */
    private void setupClickListeners() {
        // Back button in toolbar
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // Back to Home button
        btnBackToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToHome();
            }
        });
    }

    /**
     * Navigate back to the home screen
     */
    private void navigateToHome() {
        // Clear the back stack and navigate to home activity
        Intent homeIntent = new Intent(this, MainActivity.class);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(homeIntent);
        finish();
    }

    /**
     * Handle back button press
     */
    @Override
    public void onBackPressed() {
        // Navigate back to the previous screen
        super.onBackPressed();
    }

    /**
     * Static method to start this activity from other activities
     * 
     * @param activity The calling activity
     */
    public static void start(Activity activity) {
        Intent intent = new Intent(activity, IncreaseLimitActivity.class);
        activity.startActivity(intent);
    }

    /**
     * Static method to start this activity with request details
     * 
     * @param activity The calling activity
     * @param requestId The ID of the submitted request
     * @param submissionDate The date when the request was submitted
     */
    public static void start(Activity activity, String requestId, String submissionDate) {
        Intent intent = new Intent(activity, IncreaseLimitActivity.class);
        intent.putExtra("request_id", requestId);
        intent.putExtra("submission_date", submissionDate);
        activity.startActivity(intent);
    }

    /**
     * Handle the intent extras if any were passed
     */
    private void handleIntentExtras() {
        Intent intent = getIntent();
        if (intent != null) {
            String requestId = intent.getStringExtra("request_id");
            String submissionDate = intent.getStringExtra("submission_date");
            
            // You can use these values to customize the display
            // For example, update the submission date in the timeline
            if (submissionDate != null) {
                // Update the date displays in your timeline
                // This would require additional TextViews with IDs to reference
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        handleIntentExtras();
    }
}