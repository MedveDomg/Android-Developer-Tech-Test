package mykt.tutorials.favoriteprogramminglanguage.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mykt.tutorials.favoriteprogramminglanguage.domain.ResultsUseCase

class MainViewModel : ViewModel() {

    private val resultsUseCase = ResultsUseCase()

    val resultLiveData = MutableLiveData<String>()

    fun sumbit(id: Int) {
        resultsUseCase.addResult(id)
    }

    fun showResults() {
        resultLiveData.postValue(resultsUseCase.getResults())
    }
}