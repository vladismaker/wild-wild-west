package com.wild.wild.wild.west

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class MenuWildWestFragment : Fragment() {

    override fun onCreateView(
        inflaterWildWest: LayoutInflater, containerWildWest: ViewGroup?,
        savedInstanceStateWildWest: Bundle?
    ): View? {
        return inflaterWildWest.inflate(R.layout.fragment_menu_wild_west, containerWildWest, false)
    }

    override fun onViewCreated(viewWildWest: View, savedInstanceStateWildWest: Bundle?) {
        super.onViewCreated(viewWildWest, savedInstanceStateWildWest)

        viewWildWest.findViewById<ImageView?>(R.id.btn_game_wild_west).setOnClickListener{
            transitionWildWest(GameWildWestFragment())
        }

        viewWildWest.findViewById<ImageView?>(R.id.btn_volume_wild_west).setOnClickListener{
            if (MainActivity.pauseFragmentWildWest){
                MainActivity.mediaPlayerWildWest?.start()
                MainActivity.pauseFragmentWildWest=false
            }else{
                MainActivity.mediaPlayerWildWest?.pause()
                MainActivity.pauseFragmentWildWest=true
            }
        }

        viewWildWest.findViewById<ImageView?>(R.id.btn_about_game_wild_west).setOnClickListener{
            transitionWildWest(AboutGameWildWestFragment())
        }

        viewWildWest.findViewById<ImageView?>(R.id.btn_exit_wild_west).setOnClickListener{
            requireActivity().finish()
        }
    }

    private fun transitionWildWest(fragmentWildWest:Fragment){
        parentFragmentManager.beginTransaction()
            .replace(R.id.container_fragments_wild_west, fragmentWildWest)
            .addToBackStack(null)
            .commit()
    }
}