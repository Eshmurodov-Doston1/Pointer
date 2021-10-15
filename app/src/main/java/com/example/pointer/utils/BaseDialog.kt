package com.example.pointer.utils

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.pointer.R
import com.example.pointer.databinding.LayoutExitBinding
import com.example.pointer.extensions.SingleBlock

class BaseDialog(val title:String, val text_cancel:String, val text_done:String) : DialogFragment() {

    private var cancelListener: SingleBlock<Boolean>? = null
    private var doneListener: SingleBlock<Boolean>? = null
    private var _bn: LayoutExitBinding? = null
    private val bn get() = _bn!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.CustomDialog)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _bn = LayoutExitBinding.inflate(inflater, container, false)
        return bn.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isCancelable = false
        bn.apply {
            textTitle.text = title
            btnCancel.text = text_cancel
            btnExit.text = text_done
            btnCancel.setOnClickListener {
                cancelListener?.invoke(true)
            }
            btnExit.setOnClickListener {
                doneListener?.invoke(true)
            }
        }

    }

    fun setOnCancelListener(block: SingleBlock<Boolean>) {
        cancelListener = block
    }
    fun setOnDoneListener(block: SingleBlock<Boolean>) {
        doneListener = block
    }

    override fun onDestroy() {
        super.onDestroy()
        _bn = null
    }
}