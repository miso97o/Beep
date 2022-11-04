package com.example.beep.di

import com.example.beep.data.UserApi
import com.example.beep.data.api.RetrofitApi
import com.example.beep.util.BASE_URL
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {
    @Provides
    @Singleton
    @Named("retrofit")
    fun provideRetrofitInstance(gson: Gson): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    // Gson DI
    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().setLenient().create()
    }

    // RetrofitApi DI
    @Provides
    @Singleton
    fun provideRetrofitApi(@Named("retrofit") retrofit: Retrofit): RetrofitApi {
        return retrofit.create(RetrofitApi::class.java)
    }

    // UserApi DI
    @Provides
    @Singleton
    fun UserApi(@Named("retrofit") retrofit: Retrofit): UserApi {
        return retrofit.create(UserApi::class.java)
    }
}