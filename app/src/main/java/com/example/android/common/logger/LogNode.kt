package com.example.android.common.logger


interface LogNode {


    fun println(priority: Int, tag: String?, msg: String?, tr: Throwable?)

}
