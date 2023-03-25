package com.example.chet_nechet
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.chet_nechet.databinding.FragmentComputerBinding
import com.example.chet_nechet.databinding.FragmentUserBinding

class ComputerFragment : Fragment() {
    lateinit var binding: FragmentComputerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentComputerBinding.inflate(inflater);
        return binding.root
    }
    companion object {
        @JvmStatic
        fun newInstance() = ComputerFragment()
    }
}