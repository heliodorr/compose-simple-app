package com.test.tuturu.di

import com.test.tuturu.data.api.SWApi
import com.test.tuturu.data.repository.NetworkRepositoryImpl
import com.test.tuturu.domain.repository.NetworkRepository
import com.test.tuturu.domain.usecase.GetStarshipsUseCase
import com.test.tuturu.presentation.vm.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val appModule = module {

    single<SWApi> {

        Retrofit.Builder()
            .baseUrl("https://swapi.dev/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SWApi::class.java)

    }

    single<NetworkRepository> {
        NetworkRepositoryImpl(get())
    }

    single<GetStarshipsUseCase> {
        GetStarshipsUseCase( get() )
    }

    viewModel {
        MainViewModel(get())
    }





}
