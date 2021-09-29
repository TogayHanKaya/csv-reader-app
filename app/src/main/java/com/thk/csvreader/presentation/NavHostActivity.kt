package com.thk.csvreader.presentation

import android.os.Bundle
import android.view.WindowManager
import com.thk.csvreader.R
import com.thk.csvreader.base.presentation.activity.InjectionActivity

class NavHostActivity : InjectionActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav_host)

        supportActionBar?.hide()
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING)
    }
}