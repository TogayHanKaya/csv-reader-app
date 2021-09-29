package com.thk.commons

import android.view.View

fun View.visible() {
    visibility = View.VISIBLE
}

var View.visible
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if (value) View.VISIBLE else View.GONE
    }