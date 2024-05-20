package com.wild.wild.wild.west

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.DecelerateInterpolator
import androidx.fragment.app.Fragment
import com.wild.wild.wild.west.databinding.FragmentGameWildWestBinding
import kotlin.random.Random

class GameWildWestFragment : Fragment() {
    private var _bindingWildWest: FragmentGameWildWestBinding? = null
    private val bindingWildWest get() = _bindingWildWest!!
    private var isSpinningWildWest = false
    private var myChoiceWildWest:Int = 40
    private val handlerWildWest = Handler(Looper.getMainLooper())
    private var mediaRulePlayerWildWest: MediaPlayer? = null
    override fun onCreateView(
        inflaterWildWest: LayoutInflater, containerWildWest: ViewGroup?,
        savedInstanceStateWildWest: Bundle?
    ): View {
        _bindingWildWest = FragmentGameWildWestBinding.inflate(inflaterWildWest, containerWildWest, false)
        return bindingWildWest.root
    }

    override fun onViewCreated(viewWildWest: View, savedInstanceStateWildWest: Bundle?) {
        super.onViewCreated(viewWildWest, savedInstanceStateWildWest)

        mediaRulePlayerWildWest = MediaPlayer.create(AppWildWest.contextWildWest, R.raw.ruletka_wild_west)
        bindingWildWest.resultWildWest.visibility = View.GONE
        bindingWildWest.btnRedWildWest.setOnClickListener {
            clickButtonWildWest(2)
        }
        bindingWildWest.btnBlackWildWest.setOnClickListener {
            clickButtonWildWest(1)
        }
        bindingWildWest.btnGreenWildWest.setOnClickListener {
            clickButtonWildWest(0)
        }
        bindingWildWest.btnSettingsWildWest.setOnClickListener{
            if (MainActivity.pauseFragmentWildWest){
                MainActivity.mediaPlayerWildWest?.start()
                MainActivity.pauseFragmentWildWest=false
            }else{
                MainActivity.mediaPlayerWildWest?.pause()
                MainActivity.pauseFragmentWildWest=true
            }
        }
        bindingWildWest.btnMenuWildWest.setOnClickListener{
            parentFragmentManager.popBackStack()
        }
    }

    private fun clickButtonWildWest(num:Int){
        bindingWildWest.resultWildWest.visibility = View.GONE
        bindingWildWest.btnRedWildWest.isEnabled = false
        bindingWildWest.btnGreenWildWest.isEnabled = false
        bindingWildWest.btnBlackWildWest.isEnabled = false
        myChoiceWildWest = num
        if (!isSpinningWildWest) {
            spinRouletteWildWest()
            mediaRulePlayerWildWest?.start()
        }
    }

    private fun spinRouletteWildWest() {
        isSpinningWildWest = true

        val sectionWildWest = Random.nextInt(38)

        val degreesWildWest = 360 * 5 + (sectionWildWest * 360/38)

        val animationWildWest = CustomRotateAnimationWildWest(
            0f, degreesWildWest.toFloat(),
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        )
        animationWildWest.duration = 13000
        animationWildWest.interpolator = DecelerateInterpolator()
        animationWildWest.fillAfter = true

        bindingWildWest.weelWildWest.startAnimation(animationWildWest)

        handlerWildWest.postDelayed({
            showResult(sectionWildWest)
        }, 13000)
    }

    private fun showResult(sectionWildWest: Int) {

        isSpinningWildWest = false

        bindingWildWest.btnRedWildWest.isEnabled = true
        bindingWildWest.btnGreenWildWest.isEnabled = true
        bindingWildWest.btnBlackWildWest.isEnabled = true

        val strWildWest = if (sectionWildWest == 0){
            0
        }else{
            if (isEvenWildWest(sectionWildWest)){
                1
            }else{
                2
            }
        }

        checkResultWildWest(strWildWest)
    }

    private fun checkResultWildWest(resultWildWest:Int){
        mediaRulePlayerWildWest?.pause()
        if (myChoiceWildWest==resultWildWest){
            bindingWildWest.resultWildWest.setImageResource(R.drawable.result_win_wild_west)
        }else{
            bindingWildWest.resultWildWest.setImageResource(R.drawable.result_lose_wild_west)
        }
        bindingWildWest.resultWildWest.visibility = View.VISIBLE
    }

    private fun isEvenWildWest(numberWildWest: Int): Boolean {
        return numberWildWest % 2 == 0
    }

    override fun onResume() {
        super.onResume()

        if (myChoiceWildWest!=40){
            mediaRulePlayerWildWest?.start()
        }
    }

    override fun onPause() {
        super.onPause()

        mediaRulePlayerWildWest?.pause()
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _bindingWildWest = null
        handlerWildWest.removeCallbacksAndMessages(null)
        mediaRulePlayerWildWest?.release()
    }
}