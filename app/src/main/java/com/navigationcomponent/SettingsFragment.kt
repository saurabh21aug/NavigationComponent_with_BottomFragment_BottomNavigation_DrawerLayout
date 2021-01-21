package com.navigationcomponent

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_settings.*


class SettingsFragment : Fragment(R.layout.fragment_settings) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        et_default_amount.setText(SampleData.defaultAmount.value.toString())

        btn_save_default_amount.setOnClickListener {

            val defaultAmount = et_default_amount.text.toString().toLong()
            SampleData.defaultAmount.value = defaultAmount
        }

        btn_about_app.setOnClickListener {
            val action = SettingsFragmentDirections.actionGlobalAboutAppFragment()
//            val action = NavGraphDirections.actionGlobalAboutAppFragment()
            findNavController().navigate(action)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        menu.findItem(R.id.item_about_app).isVisible = false
        menu.findItem(R.id.settingsFragment).isVisible = false
        super.onCreateOptionsMenu(menu, inflater)
    }


}