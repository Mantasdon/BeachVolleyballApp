package com.example.naujasprojektas

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout


class QuantityCounterView : ConstraintLayout {
    private var mQuantityTextView: TextView? = null
    private var mQuantity = 1

    constructor(context: Context?) : super(context!!) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(
        context!!, attrs
    ) {
        init()
    }

    private fun init() {
        inflate(context, R.layout.quantity_counter_layout, this)

        mQuantityTextView = findViewById(R.id.tv_quantity)
        initQuantityText()

        val btnPlus = findViewById<ImageButton>(R.id.btn_plus)
        btnPlus.setOnClickListener { v: View? ->
            mQuantity = parseQuantity()
            mQuantity++
            initQuantityText()
        }

        val btnMinus = findViewById<ImageButton>(R.id.btn_minus)
        btnMinus.setOnClickListener { v: View? ->
            mQuantity = parseQuantity()
            mQuantity--
            initQuantityText()
        }
    }

    private fun parseQuantity(): Int {
        val string = mQuantityTextView!!.text.toString()

        var quantity = 0
        try {
            quantity = string.toInt()
        } catch (e: NumberFormatException) {
            e.printStackTrace()
        }

        return quantity
    }

    private fun initQuantityText() {
        mQuantityTextView!!.text = mQuantity.toString()
    }

    fun getQuantity(): Int {
        return mQuantity
    }
}
