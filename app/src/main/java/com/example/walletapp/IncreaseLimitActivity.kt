package com.example.walletapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

/**
 * Activity for displaying the Increase Limit request status screen.
 * This screen shows the user that their wallet limit increase request
 * has been submitted and is under review.
 */
class IncreaseLimitActivity : Activity() {

    private lateinit var btnBack: ImageView
    private lateinit var btnBackToHome: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_increase_limit)
        
        initializeViews()
        setupClickListeners()
    }

    /**
     * Initialize all view components
     */
    private fun initializeViews() {
        btnBack = findViewById(R.id.btn_back)
        btnBackToHome = findViewById(R.id.btn_back_to_home)
    }

    /**
     * Set up click listeners for interactive elements
     */
    private fun setupClickListeners() {
        // Back button in toolbar
        btnBack.setOnClickListener {
            onBackPressed()
        }

        // Back to Home button
        btnBackToHome.setOnClickListener {
            navigateToHome()
        }
    }

    /**
     * Navigate back to the home screen
     */
    private fun navigateToHome() {
        // Clear the back stack and navigate to home activity
        val homeIntent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        }
        startActivity(homeIntent)
        finish()
    }

    /**
     * Handle back button press
     */
    override fun onBackPressed() {
        // Navigate back to the previous screen
        super.onBackPressed()
    }

    /**
     * Handle the intent extras if any were passed
     */
    private fun handleIntentExtras() {
        intent?.let {
            val requestId = it.getStringExtra(EXTRA_REQUEST_ID)
            val submissionDate = it.getStringExtra(EXTRA_SUBMISSION_DATE)
            
            // You can use these values to customize the display
            // For example, update the submission date in the timeline
            submissionDate?.let { date ->
                // Update the date displays in your timeline
                // This would require additional TextViews with IDs to reference
            }
        }
    }

    override fun onResume() {
        super.onResume()
        handleIntentExtras()
    }

    companion object {
        private const val EXTRA_REQUEST_ID = "request_id"
        private const val EXTRA_SUBMISSION_DATE = "submission_date"

        /**
         * Start this activity from other activities
         * 
         * @param activity The calling activity
         */
        fun start(activity: Activity) {
            val intent = Intent(activity, IncreaseLimitActivity::class.java)
            activity.startActivity(intent)
        }

        /**
         * Start this activity with request details
         * 
         * @param activity The calling activity
         * @param requestId The ID of the submitted request
         * @param submissionDate The date when the request was submitted
         */
        fun start(activity: Activity, requestId: String, submissionDate: String) {
            val intent = Intent(activity, IncreaseLimitActivity::class.java).apply {
                putExtra(EXTRA_REQUEST_ID, requestId)
                putExtra(EXTRA_SUBMISSION_DATE, submissionDate)
            }
            activity.startActivity(intent)
        }
    }
}