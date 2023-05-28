package com.example.howtouseconfettilib

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import com.example.howtouseconfettilib.databinding.ActivityMainBinding
import nl.dionsegijn.konfetti.core.Party
import nl.dionsegijn.konfetti.core.Position
import nl.dionsegijn.konfetti.core.emitter.Emitter
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomSheet.setOnClickListener{
            showDialog()
        }

       initM()
    }

    private fun showDialog() {
        val dialog = Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.bottomshatlayout)

        val editLayout = dialog.findViewById<View>(R.id.layoutEdit)
        val shareLayout = dialog.findViewById<View>(R.id.layoutShare)
        val uploadLayout = dialog.findViewById<View>(R.id.layoutUpload)
        val printLayout = dialog.findViewById<View>(R.id.layoutPrint)

        editLayout.setOnClickListener{
            Toast.makeText(this,"Edit is clicked",Toast.LENGTH_SHORT).show()
        }

        shareLayout.setOnClickListener{
            Toast.makeText(this,"Share is clicked",Toast.LENGTH_SHORT).show()
        }

        uploadLayout.setOnClickListener{
            Toast.makeText(this,"Upload is Clicked",Toast.LENGTH_SHORT).show()
        }

        printLayout.setOnClickListener{
            Toast.makeText(this,"Print is clicked",Toast.LENGTH_SHORT).show()
        }

        dialog.show()
        dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window?.attributes?.windowAnimations = R.style.DialogAnimation
        dialog.window?.setGravity(Gravity.BOTTOM)
    }

    private fun initM() {
        val party = Party(
            speed = 0f,
            maxSpeed = 30f,
            damping = 0.9f,
            spread = 360,
            colors = listOf(0xfce18a, 0xff726d, 0xf4306d, 0xb48def),
            emitter = Emitter(duration = 100, TimeUnit.MILLISECONDS).max(100),
            position = Position.Relative(0.5, 0.3)
        )

        binding.koffty.setOnClickListener {
            var dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(true)
            dialog.setContentView(R.layout.emulator_dialog)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.show()
            binding.konfettiView.start(party)
        }
    }
}