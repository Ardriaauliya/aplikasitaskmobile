package com.d121211001.aplikasitask.repository

import com.d121211001.aplikasitask.model.Quote

interface QuoteRepository {
    suspend fun getQuotes(): List<Quote>
}