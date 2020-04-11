package com.example.app_loans.components

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.app_loans.R
import com.example.app_loans.RepaymentSchedule

class RepaymentScheduleView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.view_repayment_schedule, this, true)
        orientation = VERTICAL
    }

    @SuppressLint("InflateParams")
    fun setViewData(repaymentScheduleList: List<RepaymentSchedule>) {
        val repaymentScheduleListContainer =
            findViewById<LinearLayout>(R.id.repayment_schedule_list)
        repaymentScheduleListContainer.removeAllViews()
        repaymentScheduleList.forEach {
            val view = LayoutInflater.from(context)
                .inflate(R.layout.view_repayment_schedule_list, null)
            val repaymentScheduleDate = view.findViewById<FieldView>(R.id.repayment_date_field)
            val repaymentScheduleAmount = view.findViewById<FieldView>(R.id.repayment_amount_field)
            repaymentScheduleDate.apply {
                setFieldLabel("Date")
                setFieldValue(it.date)
            }
            repaymentScheduleAmount.apply {
                setFieldLabel("Amount")
                setFieldValue(it.amount.toString())
            }
            repaymentScheduleListContainer.addView(view)
        }

    }
}