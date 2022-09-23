package com.test.empowerment.labs.recipebook.common.base

import android.app.Application
import android.content.Context

class EmpowermentLabsApplication : Application() {
    init {
        instance = this
    }

    companion object {
        private var instance: EmpowermentLabsApplication? = null
        fun getContext(): Context = instance!!.applicationContext
    }
}