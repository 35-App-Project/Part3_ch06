package com.choi.part3_ch06.di

import com.choi.part3_ch06.remote.MainService
import com.choi.part3_ch06.remote.repository.MainRepository
import com.choi.part3_ch06.remote.repository.MainRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)
object MainRepository {

    @ViewModelScoped
    @Provides
    fun providesMainRepository(
        mainService: MainService
    ): MainRepository = MainRepositoryImpl(mainService)

}