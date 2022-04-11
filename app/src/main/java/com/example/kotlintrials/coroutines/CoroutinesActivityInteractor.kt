package com.example.kotlintrials.coroutines

import android.content.Context

class CoroutinesActivityInteractor {
    interface View{
        fun initView()
    }
    interface Presenter{
        fun showDialogBox(context: Context)
        fun showDialogBoxFromCoroutineLaunch(context: Context)
        fun showDialogBoxFromCoroutineAsync(context: Context)
    }
}