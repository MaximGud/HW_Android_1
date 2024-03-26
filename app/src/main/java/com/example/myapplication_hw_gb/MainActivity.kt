package com.example.myapplication_hw_gb

import android.os.Bundle
import android.graphics.Color
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication_hw_gb.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var counter = 0

        binding.button.visibility = View.INVISIBLE
        binding.imageButton.isEnabled = false
        binding.schet.text = counter.toString()

        binding.imageButton.setOnClickListener {
            counter--
            binding.schet.text = counter.toString()

            if (counter == 0) {
                binding.imageButton.isEnabled = false
                binding.text1.setTextColor(Color.rgb(0, 153, 0))
                binding.text1.text = "Все места свободны"
            } else if (counter >= 50) {
                binding.button.visibility = View.VISIBLE
                binding.imageButton2.isEnabled = false
                binding.text1.setTextColor(Color.rgb(153, 0, 0))
                binding.text1.text = "Слишком много пассажиров!"
            } else {
                binding.imageButton.isEnabled = true
                binding.text1.setTextColor(Color.rgb(0, 0, 153))
                binding.text1.text = "Осталось свободных мест: " + (49 - counter)
            }
        }

        binding.imageButton2.setOnClickListener {
            counter++;
            binding.schet.text = counter.toString()
            if (counter in 1..49) {
                binding.imageButton.isEnabled = true
                binding.text1.setTextColor(Color.rgb(0, 0, 153))
                binding.text1.text = "Осталось свободных мест: " + (49 - counter)
            } else if (counter >= 50) {
                binding.button.visibility = View.VISIBLE
                binding.button.isEnabled = true
                binding.imageButton2.isEnabled = false
                binding.text1.setTextColor(Color.rgb(153, 0, 0))
                binding.text1.text = "Слишком много пассажиров!"
            }
        }



        binding.button.setOnClickListener {
            binding.button.isEnabled = false
            binding.button.visibility = View.INVISIBLE
            counter = 0
            binding.schet.text = counter.toString()
            binding.imageButton.isEnabled = false
            binding.imageButton2.isEnabled = true
            binding.text1.setTextColor(Color.rgb(0, 153, 0))
            binding.text1.text = "Все места свободны"
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}



