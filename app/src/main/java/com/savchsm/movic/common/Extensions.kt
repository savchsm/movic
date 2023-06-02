package com.savchsm.movic.common

import android.view.View

fun View.show() { this.visibility = View.VISIBLE }
fun View.hide() { this.visibility = View.GONE }
fun View.visible(condition: Boolean) = if (condition) this.show() else this.hide()