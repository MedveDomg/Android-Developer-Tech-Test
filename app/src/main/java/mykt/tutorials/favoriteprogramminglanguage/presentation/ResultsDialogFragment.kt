package mykt.tutorials.favoriteprogramminglanguage.presentation

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class ResultsDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val text = arguments?.getString(KEY_TEXT)
        return MaterialAlertDialogBuilder(requireContext())
            .setTitle("Results")
            .setMessage(text)
            .setPositiveButton("Ok") { _, _ ->
                dismiss()
            }.create()
    }

    companion object {
        const val KEY_TEXT = "KEY_TEXT"
    }
}