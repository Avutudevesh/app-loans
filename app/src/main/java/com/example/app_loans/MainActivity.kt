package com.example.app_loans

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.io.IOException
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    private val gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun fetchLoanDetails() {
        val loanDetailsJson = loadJSONFromAsset()
        val loanDetails: LoanDetails = gson.fromJson(loanDetailsJson, LoanDetails::class.java)

    }

    private fun loadJSONFromAsset(): String? {
        val jsonString: String
        try {
            jsonString = assets.open("loan_details.json").bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }
}
