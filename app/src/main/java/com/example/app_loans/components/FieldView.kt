package com.example.app_loans.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import com.example.app_loans.R

class FieldView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private var labelText: TextView
    private var valueText: TextView

    init {
        LayoutInflater.from(context).inflate(R.layout.view_label_with_value, this, true)
        orientation = VERTICAL
        labelText = findViewById(R.id.label)
        valueText = findViewById(R.id.value)
        val attributes = context.obtainStyledAttributes(attrs,R.styleable.FieldView)
        labelText.text = attributes.getString(R.styleable.FieldView_field_label)
        valueText.text = attributes.getString(R.styleable.FieldView_field_value)
        attributes.recycle()
    }


}