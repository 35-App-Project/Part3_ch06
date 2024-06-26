package com.choi.part3_ch06.di

import com.choi.part3_ch06.model.ListItem
import com.choi.part3_ch06.remote.ListItemDeserializer
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun providesConverterFactory() : GsonConverterFactory {
        return GsonConverterFactory.create(
            GsonBuilder()
                // View Type 에 따라 Data Class 반환 (gson Converter 에서 적용?)
                .registerTypeAdapter(ListItem::class.java,ListItemDeserializer())
                .create()
        )
    }

    @Provides
    @Singleton
    fun providesOkHttpClient() : OkHttpClient.Builder {
        return OkHttpClient.Builder().apply {
            connectTimeout(5,TimeUnit.SECONDS)
            readTimeout(5,TimeUnit.SECONDS)
            writeTimeout(5,TimeUnit.SECONDS)
        }
    }

    @Provides
    @Singleton
    fun providesRetrofit(
        client: OkHttpClient.Builder,
        gsonConverterFactory: GsonConverterFactory
    ) : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://192.168.31.16:3030/api/v1/fastcampus/")
            .addConverterFactory(gsonConverterFactory)
            .client(client.build())
            .build()
    }

}