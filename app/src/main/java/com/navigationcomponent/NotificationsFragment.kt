package com.navigationcomponent

import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_notifications.*


class NotificationsFragment : Fragment(R.layout.fragment_notifications) {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lv_notification.adapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, getNotifications())

    }

    private fun getNotifications(): List<String> {
        val notification = mutableListOf<String>()

        for (i in 1..20)
            notification.add("Notifications #$i")

        return notification
    }


}