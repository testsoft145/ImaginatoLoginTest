package com.imaginatologintest.utility

import android.app.Activity
import android.app.Dialog
import android.view.Window
import com.imaginatologintest.R


class ViewDialog //..we need the context else we can not create the dialog so get context in constructor
    (var activity: Activity) {
    var dialog: Dialog? = null
    fun showDialog() {
        dialog = Dialog(activity)
        dialog!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog!!.setCancelable(false)
        dialog!!.setContentView(R.layout.progress_dialog)

        dialog!!.show()
    }

    //..also create a method which will hide the dialog when some work is done
    fun hideDialog() {
        if(dialog != null && dialog!!.isShowing)
        dialog!!.dismiss()
    }

}