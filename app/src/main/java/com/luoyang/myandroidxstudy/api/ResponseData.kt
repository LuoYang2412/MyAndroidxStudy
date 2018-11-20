package com.luoyang.myandroidxstudy.api

import java.io.Serializable

class ResponseData<T> : Serializable {

    var success: Boolean = false
    var code: Int = 0

    var message: String? = null

    var data: T? = null
}
