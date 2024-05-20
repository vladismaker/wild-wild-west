package com.wild.wild.wild.west

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class AboutGameWildWestFragment : Fragment() {

    override fun onCreateView(
        inflaterWildWest: LayoutInflater, containerWildWest: ViewGroup?,
        savedInstanceStateWildWest: Bundle?
    ): View? {
        return inflaterWildWest.inflate(R.layout.fragment_about_game_wild_west, containerWildWest, false)
    }

    override fun onViewCreated(viewWildWest: View, savedInstanceStateWildWest: Bundle?) {
        super.onViewCreated(viewWildWest, savedInstanceStateWildWest)

        viewWildWest.findViewById<TextView?>(R.id.btn_back_wild_west).setOnClickListener{
            parentFragmentManager.popBackStack()
        }
    }
}