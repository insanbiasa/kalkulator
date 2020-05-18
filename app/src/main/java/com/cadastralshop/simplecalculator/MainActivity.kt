package com.cadastralshop.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvSatu.setOnClickListener { appendOnExpresstion("1", true) }
        tvDua.setOnClickListener { appendOnExpresstion("2", true) }
        tvTiga.setOnClickListener { appendOnExpresstion("3", true) }
        tvEmpat.setOnClickListener { appendOnExpresstion("4", true) }
        tvLima.setOnClickListener { appendOnExpresstion("5", true) }
        tvEnam.setOnClickListener { appendOnExpresstion("6", true) }
        tvTujuh.setOnClickListener { appendOnExpresstion("7", true) }
        tvDelapan.setOnClickListener { appendOnExpresstion("8", true) }
        tvSembilan.setOnClickListener { appendOnExpresstion("9", true) }
        tvNol.setOnClickListener { appendOnExpresstion("0", true) }
        tvDot.setOnClickListener { appendOnExpresstion(".", true) }

        tvPlus.setOnClickListener { appendOnExpresstion("+", false) }
        tvMinus.setOnClickListener { appendOnExpresstion("-", false) }
        tvKali.setOnClickListener { appendOnExpresstion("*", false) }
        tvBagi.setOnClickListener { appendOnExpresstion("/", false) }

        tvAC.setOnClickListener {
            tvExpression.text = ""
            tvResult.text = ""
        }

        tvDel.setOnClickListener {
            val string = tvExpression.text.toString()
            if (string.isNotEmpty()) {
                tvExpression.text = string.substring(0, string.length - 1)
            }
            tvResult.text = ""
        }

        tvEqual.setOnClickListener {
            try {

                val expression = ExpressionBuilder(tvExpression.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble())
                    tvResult.text = longResult.toString()
                else
                    tvResult.text = result.toString()

            } catch (e: Exception) {
                Log.d("Exception", " message : " + e.message)
            }
        }

    }

    fun appendOnExpresstion(string: String, canClear: Boolean) {

        if (tvResult.text.isNotEmpty()) {
            tvExpression.text = ""
        }

        if (canClear) {
            tvResult.text = ""
            tvExpression.append(string)
        } else {
            tvExpression.append(tvResult.text)
            tvExpression.append(string)
            tvResult.text = ""
        }


    }


}




