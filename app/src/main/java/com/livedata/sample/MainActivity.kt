package com.livedata.sample

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), LifecycleOwner {
    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigateBtn.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        LiveDataBus.get().with("post_event", String::class.java)
            .observe(this, Observer<String> {
                Log.e(TAG, "接收到事件----> $it")
                busInfo.text = it
            })
    }
}
