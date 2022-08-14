package mykt.tutorials.favoriteprogramminglanguage.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.os.bundleOf
import mykt.tutorials.favoriteprogramminglanguage.databinding.ActivityMainBinding
import mykt.tutorials.favoriteprogramminglanguage.domain.ResultsUseCase.Companion.JAVA_ID
import mykt.tutorials.favoriteprogramminglanguage.domain.ResultsUseCase.Companion.KOTLIN_ID
import mykt.tutorials.favoriteprogramminglanguage.domain.ResultsUseCase.Companion.SWIFT_ID
import mykt.tutorials.favoriteprogramminglanguage.presentation.ResultsDialogFragment.Companion.KEY_TEXT

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        viewModel.resultLiveData.observe(this) { text ->
            val dialog = ResultsDialogFragment().apply {
                arguments = bundleOf(KEY_TEXT to text)
            }
            dialog.show(supportFragmentManager, ResultsDialogFragment::class.java.canonicalName)
        }
        binding.btnSubmit.setOnClickListener {
            val btnId = binding.rg.checkedRadioButtonId
            if (btnId == -1) {
                Toast.makeText(this, "Select any variant, please", Toast.LENGTH_SHORT).show()
            } else {
                val id = when (btnId) {
                    binding.btnSwift.id -> SWIFT_ID
                    binding.btnJava.id -> JAVA_ID
                    else -> KOTLIN_ID
                }
                binding.rg.clearCheck()
                viewModel.sumbit(id)
            }
        }
        binding.btnShowResult.setOnClickListener {
            viewModel.showResults()
        }
    }
}