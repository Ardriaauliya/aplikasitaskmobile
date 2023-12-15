
package com.d121211001.aplikasitask.di

import com.d121211001.aplikasitask.network.ApiService
import com.d121211001.aplikasitask.repository.QuoteRepository
import com.d121211001.aplikasitask.repository.QuoteRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://api.quotable.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideQuoteRepository(apiService: ApiService): QuoteRepository {
        return QuoteRepositoryImpl(apiService)
    }
}
