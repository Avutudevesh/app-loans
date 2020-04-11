package com.example.app_loans.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.app_loans.LoanTerms
import com.example.app_loans.R

class LoanTermsView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.view_loan_terms, this, true)
        orientation = VERTICAL
    }

    fun setViewData(loanTerms: LoanTerms) {
        val loanDuration = findViewById<FieldView>(R.id.loan_duration)
        val loanInterestRate = findViewById<FieldView>(R.id.loan_interest_rate)
        val loanAmount = findViewById<FieldView>(R.id.loan_amount)
        val loanProduct = findViewById<FieldView>(R.id.loan_product)
        loanDuration.apply {
            setFieldLabel("Duration")
            setFieldValue(loanTerms.duration)
        }
        loanInterestRate.apply {
            setFieldLabel("Interest Rate")
            setFieldValue(loanTerms.interestRate)
        }
        loanAmount.apply {
            setFieldLabel("Loan Amount")
            setFieldValue(loanTerms.amount.toString())
        }
        loanProduct.apply {
            setFieldLabel("Loan Product")
            setFieldValue(loanTerms.loanProduct)
        }
    }
}