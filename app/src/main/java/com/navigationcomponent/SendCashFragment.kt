package com.navigationcomponent

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_send_cash.*


class SendCashFragment : Fragment(R.layout.fragment_send_cash) {

    val args: SendCashFragmentArgs by navArgs()

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        et_amount.setText(SampleData.defaultAmount.value.toString())

        SampleData.defaultAmount.observe(viewLifecycleOwner) {
            et_amount.setText(it.toString())
        }


        val receiverName = args.receiverString

        tv_receiver.text = "Send Cast to ${receiverName}"

        btn_send.setOnClickListener {

            if (et_amount.text.toString().isEmpty())
                context?.toast("please enter amount for $receiverName")
            else {
                val amount = et_amount.text.toString().toLong()
                val action =
                    SendCashFragmentDirections.actionSendCashFragmentToConfirmDialogFragment(
                        receiverName,
                        amount
                    )
                findNavController().navigate(action)
            }
        }

        btn_done.setOnClickListener {
            val action =
                SendCashFragmentDirections.actionSendCashFragmentToHomeFragment()
            findNavController().navigate(action)
        }
        btn_cancel.setOnClickListener {
            findNavController().popBackStack(R.id.homeFragment, true)
        }
    }


}



