package com.example.app_loans.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
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

    private lateinit var borrowerNameTextView: TextView
    private lateinit var borrowerAddressTextView: TextView
    private lateinit var coverImageView: ImageView
    private lateinit var borrowerLocationImage: ImageView

    fun setViewData(locationData: BorrowerLocation, coverImage: CoverImage) {
        borrowerNameTextView = findViewById(R.id.borrower_name)
        borrowerAddressTextView = findViewById(R.id.borrower_address)
        coverImageView = findViewById(R.id.cover_image)
        borrowerLocationImage = findViewById(R.id.borrower_location_image)

        borrowerNameTextView.text = coverImage.label
        borrowerAddressTextView.text = locationData.address
        Glide.with(this)
            .load(coverImage.url)
            .error(R.drawable.error_placeholder)
            .into(coverImageView)
        loadMapImage(locationData.lat, locationData.lng)
    }

    private fun loadMapImage(lat: Double, lng: Double) {
        val url =
            "https://maps.googleapis.com/maps/api/staticmap?center=$lat,$lng&zoom=16&size=400x400&key={GOOGLE_API_KEY}"
        Glide.with(this)
            .load(url)
            .error(R.drawable.error_placeholder)
            .into(borrowerLocationImage)
    }
}