package com.example.app_loans

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.app_loans.components.ApplicantDetailsView
import com.example.app_loans.components.BorrowerLocationView
import com.example.app_loans.components.LoanTermsView
import com.example.app_loans.components.RepaymentScheduleView
import java.io.IOException
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    private val gson = Gson()
    private lateinit var borrowerLocationView: BorrowerLocationView
    private lateinit var applicantDetailsView: ApplicantDetailsView
    private lateinit var loanTermsView: LoanTermsView
    private lateinit var repaymentScheduleView: RepaymentScheduleView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val loanDetails: LoanDetails = fetchLoanDetails()
        loadViews(loanDetails)
    }

    private fun loadViews(loanDetails: LoanDetails) {
        borrowerLocationView = findViewById(R.id.borrower_location_view)
        applicantDetailsView = findViewById(R.id.applicant_details_view)
        loanTermsView = findViewById(R.id.loan_terms_view)
        repaymentScheduleView = findViewById(R.id.repayment_schedule_view)
        borrowerLocationView.setViewData(loanDetails.borrowerLocation,loanDetails.image)
        applicantDetailsView.setViewData(loanDetails.applicantDetails)
        loanTermsView.setViewData(loanDetails.loanTerms)
    }

    private fun fetchLoanDetails(): LoanDetails {
        val loanDetailsJson = loadJSONFromAsset()
        return gson.fromJson(loanDetailsJson, LoanDetails::class.java)

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
