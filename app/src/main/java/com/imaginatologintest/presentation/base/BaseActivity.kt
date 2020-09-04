package com.imaginatologintest.presentation.base

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.imaginatologintest.R
import com.imaginatologintest.utility.ViewDialog
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity<B : ViewDataBinding> : DaggerAppCompatActivity() {


    private var viewDialog: ViewDialog? = null
    private var _binding: B? = null

    protected var mProgressDialog: Dialog? = null

    protected val binding: B
        get() = _binding ?: throw IllegalStateException(
            "binding is not available before onCreateView() and in or after onDestroyView()"
        )

    abstract val layout: Int
        @LayoutRes get

    abstract fun viewModelSetup()

    abstract fun viewSetup()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<B>(this, layout).also {
            it.lifecycleOwner = this
            _binding = it
        }
        viewModelSetup()
        viewDialog = ViewDialog(this)
        viewSetup()
    }

    open fun showLoader() {
        if (mProgressDialog == null) {
            mProgressDialog = Dialog(this@BaseActivity)
            mProgressDialog?.setContentView(R.layout.progress_dialog)
            mProgressDialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            mProgressDialog?.setCancelable(false)
        }
        if (!(mProgressDialog?.isShowing!!)) {
            mProgressDialog?.show()
        }



    }

    open fun dismissLoader() {
        mProgressDialog?.dismiss()
    }

}