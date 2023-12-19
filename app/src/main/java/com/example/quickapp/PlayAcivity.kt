package com.example.quickapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.example.quickapp.databinding.ActivityMainBinding

class PlayAcivity : AppCompatActivity(), View.OnClickListener{
   // lateinit var binding: ActivityMainBinding
    val q1 = Question("Kotlin was developed by?", "IBM", "NetBeans", "JetBrains", "Oracle","JetBrains")
    val q2=Question("Kotlin is a statically-typed programming language which runs on the?","JCM","JVM","JPM","JDM","JVM")
    val q3=Question("Why you should switch to Kotlin from Java?","Kotlin language is quite simple compared to Java","It reduces may redundancies in code as compared to Java","Kotlin can offer some useful features which are not supported by Java","All of the above","All of the above")
    val q4=Question("How many types of constructors available in Kotlin?","1","2","3","4","2")
    val qustions:List<Question> = listOf<Question>(q1,q2,q3,q4)
    lateinit var que_view:TextView
    lateinit var ch1:Button
    lateinit var ch2:Button
    lateinit var ch3:Button
    lateinit var ch4:Button
    var current:Int=0
    lateinit var next_btn:Button
    lateinit var previous:ImageButton
    lateinit var cpt_view:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_play)
        que_view=findViewById(R.id.question)
        ch1=findViewById(R.id.choose1)
        ch2=findViewById(R.id.choose2)
        ch3=findViewById(R.id.choose3)
        ch4=findViewById(R.id.choose4)
        next_btn=findViewById(R.id.next_btn)
        previous=findViewById(R.id.prev_btn)
        cpt_view=findViewById(R.id.cpt_question)
        que_view.text=qustions[current].questionName
        ch1.text=qustions[current].ch1
        ch2.text=qustions[current].ch2
        ch3.text=qustions[current].ch3
        ch4.text=qustions[current].ch4
        ch1.setOnClickListener(this)
        ch2.setOnClickListener(this)
        ch3.setOnClickListener(this)
        ch4.setOnClickListener(this)
next_btn.setOnClickListener {
    current++
    nextQuestion()
}
        previous.setOnClickListener {
            current--
            prevQuestion()
        }


    }
private fun nextQuestion(){
    cpt_view.text="${current+1}/${qustions.size}"
    que_view.text=qustions[current].questionName
    ch1.text=qustions[current].ch1
    ch2.text=qustions[current].ch2
    ch3.text=qustions[current].ch3
    ch4.text=qustions[current].ch4
}
    private fun prevQuestion(){
        cpt_view.text="${current+1}/${qustions.size}"
        que_view.text=qustions[current].questionName
        ch1.text=qustions[current].ch1
        ch2.text=qustions[current].ch2
        ch3.text=qustions[current].ch3
        ch4.text=qustions[current].ch4
    }

    override fun onClick(v: View?){
      when(v?.id){
          R.id.choose1 -> {
              if(ch1.text.toString().equals(qustions[current].correct,true))
              {
                  Toast.makeText(this,"Correct Answer",Toast.LENGTH_SHORT).show()}
          else
              { Toast.makeText(this,"Wrong Answer",Toast.LENGTH_SHORT).show()}
          }
          R.id.choose2 -> {
              if(ch2.text.toString().equals(qustions[current].correct,true))
              {Toast.makeText(this,"Correct Answer",Toast.LENGTH_SHORT).show()}
              else
              { Toast.makeText(this,"Wrong Answer",Toast.LENGTH_SHORT).show()}
          }
          R.id.choose3 -> {
              if(ch3.text.toString().equals(qustions[current].correct,true))
              { Toast.makeText(this,"Correct Answer",Toast.LENGTH_SHORT).show()}
              else
              { Toast.makeText(this,"Wrong Answer",Toast.LENGTH_SHORT).show()}
          }
          R.id.choose4 -> {
              if(ch4.text.toString().equals(qustions[current].correct,true))
              {
                  Toast.makeText(this,"Correct Answer",Toast.LENGTH_SHORT).show()}
              else
              { Toast.makeText(this,"Wrong Answer",Toast.LENGTH_SHORT).show()}
          }
      }
    }
}