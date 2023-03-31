package com.example.chet_nechet
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import com.example.chet_nechet.databinding.FragmentUserBinding

class UserFragment : Fragment() {
    lateinit var binding: FragmentUserBinding
    private val dataModel: DataModel by activityViewModels()

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserBinding.inflate(inflater)

        var trueCounterU = 0
        var falseCounterU = 0
        var allCounterU = 0

        binding.textView1U.text = (1..6).random().toString()
        binding.textView2U.text = (1..6).random().toString()
        binding.textView3U.text = (1..6).random().toString()
        binding.textViewSumU.text = (binding.textView1U.text.toString().toInt() +
                binding.textView2U.text.toString().toInt() +
                binding.textView3U.text.toString().toInt()).toString()
        ++allCounterU

        when ((0..1).random()){
            0 -> {binding.radioButton3U.isChecked = true
                binding.radioButton3U.isEnabled = false
                binding.radioButton4U.isEnabled = false
                binding.linearLayout2.isVisible = true
                binding.imageViewU.isVisible = true
                if (binding.textViewSumU.text.toString().toInt() % 2 == 0 && binding.radioButton3U.isChecked)
                {
                    binding.imageViewU.setImageResource(R.drawable.resource_true)
                    ++trueCounterU
                    dataModel.messageForMainActivityFromUserFragmentTrueCounter.value = trueCounterU.toString()
                }
                else
                {
                    binding.imageViewU.setImageResource(R.drawable.resource_false)
                    ++falseCounterU
                    dataModel.messageForMainActivityFromUserFragmentTrueCounter.value = trueCounterU.toString()
                }
            }
            1 -> {
                binding.radioButton4U.isChecked = true
                binding.radioButton3U.isEnabled = false
                binding.radioButton4U.isEnabled = false
                binding.linearLayout2.isVisible = true
                binding.imageViewU.isVisible = true
                if (binding.textViewSumU.text.toString().toInt() % 2 == 1 && binding.radioButton4U.isChecked)
                {
                    binding.imageViewU.setImageResource(R.drawable.resource_true)
                    ++trueCounterU
                    dataModel.messageForMainActivityFromUserFragmentTrueCounter.value = trueCounterU.toString()
                }
                else
                {
                    binding.imageViewU.setImageResource(R.drawable.resource_false)
                    ++falseCounterU
                    dataModel.messageForMainActivityFromUserFragmentTrueCounter.value = trueCounterU.toString()
                }
            }
        }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = UserFragment()
    }
}