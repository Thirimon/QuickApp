package com.example.quickapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.quickapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener{
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnPlay.setOnClickListener(this)
        binding.btnExit.setOnClickListener(this)
        binding.btnSetting.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
       when(v?.id){
           R.id.btn_play-> {      val moveToplay= Intent(applicationContext,PlayAcivity::class.java)
                                  startActivity(moveToplay)}
           R.id.btn_exit ->{
               Toast.makeText(this,"Exit ",Toast.LENGTH_SHORT).show()
               finishAffinity()
           }
           R.id.btn_setting->Toast.makeText(this,"Setting ",Toast.LENGTH_SHORT).show()
       }
    }
}