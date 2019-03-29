package com.livedata.sample

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        postBtn.setOnClickListener {
            LiveDataBus.get().with("post_event", String::class.java).value = "这是发布消息"
        }

        navigateBtn.setOnClickListener {
            startActivity(Intent(this, ThirdActivity::class.java))
        }
    }
}
