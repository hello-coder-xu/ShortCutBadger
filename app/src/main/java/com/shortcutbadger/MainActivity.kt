package com.shortcutbadger

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }


    private fun initView() {
        addbadger?.setOnClickListener {
            var iconNumber = iconnumber?.text.toString()
            if (iconNumber == null || iconNumber.isEmpty()) {
                Toast.makeText(this, "数字不能为空", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            var number = Integer.parseInt(iconNumber)
            val success = ShortcutBadger.applyCount(this@MainActivity, number)
            Toast.makeText(this, "数字:$number 添加 $success", Toast.LENGTH_LONG).show()
        }

        removebadger?.setOnClickListener {
            val success = ShortcutBadger.removeCount(this@MainActivity)

            Toast.makeText(applicationContext, "success=" + success, Toast.LENGTH_SHORT).show()
        }
    }
}
