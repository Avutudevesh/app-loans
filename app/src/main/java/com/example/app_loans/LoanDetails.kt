package com.example.app_loans

import com.google.gson.annotations.SerializedName


data class LoanDetails(
    val type: String,
    val title: String,
    val image: CoverImage,
    @SerializedName("Borrower Location")
    val borrowerLocation: BorrowerLocation,
    @SerializedName("Applicant Details")
    val applicantDetails: ApplicantDetails,
    @SerializedName("Loan Terms")
    val loanTerms: LoanTerms,
    @SerializedName("Repayment Schedule")
    val repaymentSchedule: List<RepaymentSchedule>
)

data class CoverImage(
    val url: String,
    val label: String
)

data class BorrowerLocation(
    val lat: Double,
    val lng: Double,
    val address: String
)

data class ApplicantDetails(
    @SerializedName("Name")
    val name: String,
    @SerializedName("Date of Birth")
    val dob: String,
    @SerializedName("Phone Number")
    val phoneNumber: List<String>,
    @SerializedName("Marital Status")
    val maritalStatus: String,
    @SerializedName("No of Dependents")
    val dependents: Int
)

data class LoanTerms(
    @SerializedName("Duration")
    val duration: String,
    @SerializedName("Interest Rate")
    val interestRate: String,
    @SerializedName("Loan Amount")
    val amount: Int,
    @SerializedName("Loan Product")
    val loanProduct: String
)

data class RepaymentSchedule(
    @SerializedName("Date")
    val date: String,
    @SerializedName("Amount")
    val amount: Int
)

