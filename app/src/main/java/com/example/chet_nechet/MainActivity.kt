package com.example.chet_nechet
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.chet_nechet.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val dataModel: DataModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        openFrag(ComputerFragment.newInstance(), R.id.FrameComputer)
        openFrag(UserFragment.newInstance(), R.id.FrameUser)

        dataModel.messageForMainActivityFromComputerFragment.observe(this) {
            val rbClick = it.toString().toBoolean()
            binding.btnStart.isEnabled = rbClick
        }


        binding.FrameComputer.isVisible = true
        var btnCl = true

        binding.btnStart.setOnClickListener {
            binding.tvCompWinners.isVisible = true
            binding.tvUserWinners.isVisible = true
            dataModel.messageForComputerFragment.value = btnCl.toString()
            binding.FrameUser.isVisible = true
            binding.btnClose.isVisible = true

            dataModel.messageForMainActivityFromComputerFragmentTrueCounter.observe(this) {
                val trueCounterComp = it
                binding.tvCompWinners.text = trueCounterComp
            }

            dataModel.messageForMainActivityFromUserFragmentTrueCounter.observe(this) {
                val trueCounterUser = it
                binding.tvUserWinners.text = trueCounterUser
            }
        }

        binding.btnClose.setOnClickListener{
            finish()
        }
    }
    private fun openFrag(f: Fragment, idHolder: Int)
    {
        supportFragmentManager
            .beginTransaction()
            .replace(idHolder, f)
            .commit()
    }
}