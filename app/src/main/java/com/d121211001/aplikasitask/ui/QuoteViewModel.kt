package com.d121211001.aplikasitask.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.d121211001.aplikasitask.model.Quote
import com.d121211001.aplikasitask.repository.QuoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(private val repository: QuoteRepository) : ViewModel() {
    private val _quotes = MutableStateFlow<List<Quote>>(emptyList())
    val quotes: StateFlow<List<Quote>> = _quotes

    init {
        viewModelScope.launch {
            _quotes.value = repository.getQuotes()
        }
    }
}
