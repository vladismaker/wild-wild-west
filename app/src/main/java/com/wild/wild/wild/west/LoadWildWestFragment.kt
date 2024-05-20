package com.wild.wild.wild.west

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ViewFlipper
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoadWildWestFragment : Fragment() {
    private lateinit var viewFlipperWildWest: ViewFlipper
    private val imageResourcesWildWest = intArrayOf(R.drawable.progress_wild_west_1, R.drawable.progress_wild_west_2, R.drawable.progress_wild_west_3, R.drawable.progress_wild_west_4, R.drawable.progress_wild_west_5, R.drawable.progress_wild_west_6, R.drawable.progress_wild_west_7, R.drawable.progress_wild_west_8, R.drawable.progress_wild_west_9)
    private var currentIndexWildWest = 0
    private val handlerWildWest = Handler(Looper.getMainLooper())
    private val delayWildWest = 155L
    private val imageChangerRunnableWildWest = object : Runnable {
        override fun run() {
            currentIndexWildWest = (currentIndexWildWest + 1) % imageResourcesWildWest.size

            val imageViewWildWest = ImageView(AppWildWest.contextWildWest)
            imageViewWildWest.setImageResource(imageResourcesWildWest[currentIndexWildWest])

            viewFlipperWildWest.addView(imageViewWildWest)
            viewFlipperWildWest.showNext()

            handlerWildWest.postDelayed(this, delayWildWest)
        }
    }

    override fun onCreateView(
        inflaterWildWest: LayoutInflater, containerWildWest: ViewGroup?,
        savedInstanceStateWildWest: Bundle?
    ): View? {
        return inflaterWildWest.inflate(R.layout.fragment_load_wild_west, containerWildWest, false)
    }

    override fun onViewCreated(viewWildWest: View, savedInstanceStateWildWest: Bundle?) {
        super.onViewCreated(viewWildWest, savedInstanceStateWildWest)

        viewFlipperWildWest = viewWildWest.findViewById(R.id.view_flipper_treasures_of_anubis)

        val firstImageViewWildWest = ImageView(AppWildWest.contextWildWest)
        firstImageViewWildWest.setImageResource(imageResourcesWildWest[currentIndexWildWest])
        viewFlipperWildWest.addView(firstImageViewWildWest)

        handlerWildWest.postDelayed(imageChangerRunnableWildWest, delayWildWest)


        lifecycleScope.launch(Dispatchers.Main) {
            delay(2500)

            parentFragmentManager.beginTransaction()
                .replace(R.id.container_fragments_wild_west, MenuWildWestFragment())
                .commit()
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        handlerWildWest.removeCallbacksAndMessages(null)
    }
}