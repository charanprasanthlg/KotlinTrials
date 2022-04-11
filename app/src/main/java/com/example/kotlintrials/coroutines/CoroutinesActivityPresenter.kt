package com.example.kotlintrials.coroutines

import android.app.Dialog
import android.content.Context
import android.view.Window
import android.widget.TextView
import android.widget.Toast
import com.example.kotlintrials.R

import kotlinx.coroutines.*

class CoroutinesActivityPresenter(view: CoroutinesActivityInteractor.View) :
    CoroutinesActivityInteractor.Presenter {

    override fun showDialogBox(context: Context) {

        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_box)

        val confirmBtn = dialog.findViewById<TextView>(R.id.confirmBtn)
        val cancelBtn = dialog.findViewById<TextView>(R.id.cancelBtn)

        confirmBtn.setOnClickListener { dialog.dismiss() }
        cancelBtn.setOnClickListener { dialog.dismiss() }

        dialog.show()
    }

    override fun showDialogBoxFromCoroutineLaunch(context: Context) {
        runBlocking {

            launch {
//                dialogBoxFromCoroutine(context)
                delay(7000L)
                Toast.makeText(context, "slow and steady wins the race", Toast.LENGTH_SHORT).show()
            }

            val job = launch {
                delay(4000L)
                Toast.makeText(context, "Showing after 3000ms", Toast.LENGTH_SHORT).show()
            }

            Toast.makeText(context, "I am fast", Toast.LENGTH_SHORT).show()
            job.join()
            Toast.makeText(
                context,
                "appearing last(Waiting for specific variable (job) to complete using \'.join()\' function",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun showDialogBoxFromCoroutineAsync(context: Context) {
        runBlocking {

            async {
                delay(4000L)
//                dialogBoxFromCoroutine(context)
                Toast.makeText(context, "Show off after 4000ms", Toast.LENGTH_SHORT).show()
            }.await()

            async {
                delay(2000L)
                Toast.makeText(
                    context,
                    "Showing after dialog box and with gap of 2000ms",
                    Toast.LENGTH_SHORT
                ).show()
            }.await()

            Toast.makeText(
                context,
                "I appear after the completion of all process",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private suspend fun dialogBoxFromCoroutine(context: Context) {
        delay(2000L)
        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_box)

        val confirmBtn = dialog.findViewById<TextView>(R.id.confirmBtn)
        val cancelBtn = dialog.findViewById<TextView>(R.id.cancelBtn)

        confirmBtn.setOnClickListener { dialog.dismiss() }
        cancelBtn.setOnClickListener { dialog.dismiss() }

        dialog.show()
    }

}