package com.example.walletapp

import android.app.Activity
import android.os.Bundle
import android.widget.Button

/**
 * Main Activity - Home screen of the wallet application
 */
class MainActivity : Activity() {

    private lateinit var btnIncreaseLimitDemo: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // For demo purposes, create a simple layout with a button
        // to navigate to the Increase Limit screen
        setupDemoLayout()
    }

    /**
     * Create a simple demo layout to test the Increase Limit screen
     */
    private fun setupDemoLayout() {
        // Create a simple button programmatically for demo
        btnIncreaseLimitDemo = Button(this).apply {
            text = "View Increase Limit Status"
            setOnClickListener {
                // Navigate to Increase Limit Activity
                IncreaseLimitActivity.start(this@MainActivity, "REQ123456", "13 Mar 2025")
            }
        }
        
        setContentView(btnIncreaseLimitDemo)
    }
}