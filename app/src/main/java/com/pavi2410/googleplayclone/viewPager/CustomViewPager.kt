package com.pavi2410.googleplayclone.viewPager

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent

import androidx.viewpager.widget.ViewPager

class CustomViewPager(context: Context, attrs: AttributeSet) : ViewPager(context, attrs) {

    override fun onTouchEvent(event: MotionEvent) = false

    override fun onInterceptTouchEvent(event: MotionEvent) = false
}
