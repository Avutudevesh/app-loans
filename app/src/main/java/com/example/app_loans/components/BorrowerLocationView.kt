package com.example.app_loans.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import com.example.app_loans.BorrowerLocation
import com.example.app_loans.CoverImage
import com.example.app_loans.R

class BorrowerLocationView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    init {
        LayoutInflater.from(context).inflate(R.layout.view_borrower_location, this, true)
        orientation = VERTICAL
    }

    fun setViewData(locationData: BorrowerLocation, coverImage: CoverImage) {
        val borrowerNameTextView = findViewById<TextView>(R.id.borrower_name)
        val borrowerAddressTextView = findViewById<TextView>(R.id.borrower_address)
        borrowerNameTextView.text = coverImage.label
        borrowerAddressTextView.text = locationData.address

    }
}