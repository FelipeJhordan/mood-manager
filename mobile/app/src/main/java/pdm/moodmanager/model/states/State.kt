package com.example.moodmanager.states

import android.os.Parcelable

abstract class State {
    open var score:Long = 0

    abstract fun ToPositive():State
    abstract fun ToRegular():State
    abstract fun ToNegative():State
}