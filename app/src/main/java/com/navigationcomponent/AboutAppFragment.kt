package com.navigationcomponent

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment


class AboutAppFragment : Fragment(R.layout.fragment_about_app) {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return super.onCreateView(inflater, container, savedInstanceState)
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

//        inflater.inflate(R.menu.main_option_menu, menu)
        menu.findItem(R.id.item_about_app).isVisible = false
        menu.findItem(R.id.settingsFragment).isVisible = false
    }


    
}