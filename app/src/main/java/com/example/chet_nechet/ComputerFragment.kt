package com.example.chet_nechet
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.chet_nechet.databinding.FragmentComputerBinding

class ComputerFragment : Fragment() {
    private lateinit var binding: FragmentComputerBinding
    private val dataModel: DataModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentComputerBinding.inflate(inflater)

        var trueCounter = 0
        var falseCounter = 0
        var allCounter = 0
        val rbClick = true
        rnd()
        //получение данных из MainActivity (нажатие кнопки Старт)
        dataModel.messageForComputerFragment.observe(activity as LifecycleOwner){
            val btnClick = it.toString().toBoolean()
            if (btnClick)
            {
//                rnd()
                binding.linearLayout.isVisible = true
                binding.imageView.isVisible = true
            }
            else {
//                rnd()
//                binding.imageView.isVisible = false
//                binding.radioButton4.isEnabled = true
//                binding.radioButton4.isChecked = false
//                binding.radioButton3.isEnabled = true
//                binding.radioButton3.isChecked = false
//                binding.linearLayout.isVisible = false
            }
        }


        binding.radioButton3.setOnClickListener{
            dataModel.messageForMainActivityFromComputerFragment.value = rbClick.toString()
            binding.radioButton3.isEnabled = false
            binding.radioButton4.isEnabled = false
            ++allCounter
            if (binding.textViewSum.text.toString().toInt() % 2 == 0 && binding.radioButton3.isChecked)
            {
                binding.imageView.setImageResource(R.drawable.resource_true)
                ++trueCounter
                dataModel.messageForMainActivityFromComputerFragmentTrueCounter.value = trueCounter.toString()
            }
            else
            {
                binding.imageView.setImageResource(R.drawable.resource_false)
                ++falseCounter
                dataModel.messageForMainActivityFromComputerFragmentTrueCounter.value = trueCounter.toString()
            }
        }


        binding.radioButton4.setOnClickListener{
            dataModel.messageForMainActivityFromComputerFragment.value = rbClick.toString()
            binding.radioButton3.isEnabled = false
            binding.radioButton4.isEnabled = false
            ++allCounter
            if (binding.textViewSum.text.toString().toInt() % 2 == 1 && binding.radioButton4.isChecked)
            {
                binding.imageView.setImageResource(R.drawable.resource_true)
                ++trueCounter
                dataModel.messageForMainActivityFromComputerFragmentTrueCounter.value = trueCounter.toString()
            }
            else
            {
                binding.imageView.setImageResource(R.drawable.resource_false)
                ++falseCounter
                dataModel.messageForMainActivityFromComputerFragmentTrueCounter.value = trueCounter.toString()
            }
        }




        return binding.root
    }
    companion object {
        @JvmStatic
        fun newInstance() = ComputerFragment()
    }
    @SuppressLint("SetTextI18n")
    fun rnd()
    {
        binding.textView1.text = (1..6).random().toString()
        binding.textView2.text = (1..6).random().toString()
        binding.textView3.text = (1..6).random().toString()
        binding.textViewSum.text = (binding.textView1.text.toString().toInt() +
                binding.textView2.text.toString().toInt() +
                binding.textView3.text.toString().toInt()).toString()
    }

}