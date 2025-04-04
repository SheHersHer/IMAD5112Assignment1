package com.example.phummyeats


import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var timeInput: EditText
    private lateinit var suggestButton: Button
    private lateinit var mealSuggestion: TextView
    private lateinit var resetButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the UI elements
        timeInput = findViewById(R.id.timeInput)
        suggestButton = findViewById(R.id.suggestButton)
        mealSuggestion = findViewById(R.id.mealSuggestion)
        resetButton = findViewById(R.id.resetButton)

        // Set up the button click listener for suggestion
        suggestButton.setOnClickListener {
            val timeOfDay = timeInput.text.toString().trim().toLowerCase()

            // Handle empty or invalid input
            if (timeOfDay.isEmpty()) {
                showToast("Please enter a time of day.")
                mealSuggestion.text = ""
                return@setOnClickListener
            }

            // Determine meal suggestion based on time of day
            val suggestion = when (timeOfDay) {
                "morning" -> "Breakfast: moesli and yogurt , full cream"
                "afternoon" -> "Lunch: Chicken mayo Sandwich ,fruit juice"
                "dinner" -> "Main Course: Pasta and chicken, feta Cheese salad"
                else -> {
                    mealSuggestion.text = ""
                    showToast("Invalid input. Please enter a valid time of day (e.g., Morning, Afternoon, Dinner).")
                    return@setOnClickListener
                }
            }

            // Display the meal suggestion
            mealSuggestion.text = suggestion
        }

        // Set up the reset button
        resetButton.setOnClickListener {
            timeInput.text.clear()
            mealSuggestion.text = ""
        }
    }

    // Helper function to show toast messages
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}