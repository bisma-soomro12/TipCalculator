package com.example.tiptimecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tiptimecalculator.databinding.ActivityMainBinding
import kotlin.math.ceil


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //here binding is used for directly accessing UI elements with id no
        // there is no need to used findViewById
        // and there is no need to decleare separate varibale for storing the reference of View

    binding.button.setOnClickListener { 
        calculateTip()
    }

    }

    fun calculateTip(){
        val txt_str= binding.costOfServiceEditText.text.toString()
        val cost=txt_str.toDouble()
        val selectedId= binding.radioGroup.checkedRadioButtonId
        val tipPrcentage=when(selectedId){
            R.id.rd1 -> 0.20
            R.id.rd2 -> 0.18
            else -> 0.15
        }
        var tip= tipPrcentage*cost
        val roundUp=binding.switch1.isChecked

        if(roundUp){
            tip= ceil(tip)
            binding.amount.text=tip.toString()
        }else{
            binding.amount.text=tip.toString()
        }

    }

}