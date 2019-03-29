package com.livedata.sample

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_third.*

class ThirdActivity : AppCompatActivity() {
    private val TAG = ThirdActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        LiveDataBus.get().with("post_event", String::class.java)
            .observe(this, Observer<String> {
                Log.e(TAG, "接收到事件----> $it")
                busInfo.text = it
            })
    }
}
