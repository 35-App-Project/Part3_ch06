package com.choi.part3_ch06.di

import com.choi.part3_ch06.remote.MainService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainServiceModule {

    // instance 생성
    @Provides
    @Singleton
    fun providesMainService(retrofit: Retrofit):
            MainService = retrofit.create(MainService::class.java)
}