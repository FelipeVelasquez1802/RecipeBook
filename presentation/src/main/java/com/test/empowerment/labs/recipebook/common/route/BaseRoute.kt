package com.test.empowerment.labs.recipebook.common.route

import android.content.Context
import com.test.empowerment.labs.recipebook.common.base.EmpowermentLabsApplication

abstract class BaseRoute {
    protected val context: Context = EmpowermentLabsApplication.getContext()
}