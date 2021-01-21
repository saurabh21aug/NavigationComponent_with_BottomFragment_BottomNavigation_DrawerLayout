package com.navigationcomponent

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_confirm_dialog.*
import kotlinx.android.synthetic.main.fragment_home.*


class ConfirmDialogFragment : BottomSheetDialogFragment() {


    private val args: ConfirmDialogFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_confirm_dialog, container, false)

    }

    @SuppressLint("SetTextI18n")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        dialog?.window?.attributes?.windowAnimations = R.style.MyDialogAnimation

        val receiverName = args.reciverName
        val amount = args.amount

        tv_message.text = "Do you want to send ₹ $amount to $receiverName"

        btn_yes.setOnClickListener {
            context?.toast("$amount has been send to $receiverName")
            dismiss()

        }
        btn_no.setOnClickListener {
            dismiss()
        }


    }


}