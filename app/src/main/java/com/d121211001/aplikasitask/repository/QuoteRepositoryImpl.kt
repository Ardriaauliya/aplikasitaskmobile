package com.d121211001.aplikasitask.repository

import com.d121211001.aplikasitask.model.Quote
import com.d121211001.aplikasitask.network.ApiService

class QuoteRepositoryImpl(private val apiService: ApiService) : QuoteRepository {
    override suspend fun getQuotes(): List<Quote> {
        return apiService.getQuotes().map { response ->
            Quote(response.content, response.author)
        }
    }
}
