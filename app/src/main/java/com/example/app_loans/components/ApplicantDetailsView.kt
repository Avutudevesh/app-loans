package com.example.app_loans.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.app_loans.ApplicantDetails
import com.example.app_loans.R

class ApplicantDetailsView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.view_applicant_details, this, true)
        orientation = VERTICAL
    }

    fun setViewData(applicantDetails: ApplicantDetails) {
        val applicantNameField = findViewById<FieldView>(R.id.applicant_name)
        val applicantDOBField = findViewById<FieldView>(R.id.applicant_dob)
        val applicantMobileField = findViewById<FieldView>(R.id.applicant_mobile)
        applicantNameField.apply {
            setFieldLabel("Name")
            setFieldValue(applicantDetails.name)
        }
        applicantDOBField.apply {
            setFieldLabel("Date of Birth")
            setFieldValue(applicantDetails.dob)
        }
        applicantMobileField.apply {
            setFieldLabel("Phone number")
            setFieldValue(applicantDetails.phoneNumber[0])
        }
    }
}