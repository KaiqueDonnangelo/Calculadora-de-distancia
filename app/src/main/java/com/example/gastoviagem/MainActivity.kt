package com.example.gastoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.example.gastoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        calculate()
    }

    private fun isValid(): Boolean {
        return (binding.distance.text.toString() != ""
                && binding.priceLts.text.toString() != ""
                && binding.autonomy.text.toString() != ""
                && binding.autonomy.text.toString().toFloat() != 0f)

    }


    private fun calculate() {
        if (isValid()) {
            val distance = binding.distance.text.toString().toFloat()
            val price = binding.priceLts.text.toString().toFloat()
            val autonomy = binding.autonomy.text.toString().toFloat()

            val totalvalue = (distance * price) / autonomy
            binding.valueTotal.text = "R$ ${"%.2f".format(totalvalue)}"
        } else {
            Toast.makeText(this, R.string.validation_fill_all_fields, Toast.LENGTH_SHORT).show()
        }
    }

}
