package com.test.simpleapp.di

import com.test.simpleapp.data.repository.NetworkRepositoryImpl
import com.test.simpleapp.domain.repository.NetworkRepository
import com.test.simpleapp.domain.usecase.GetPlanetsUseCase
import com.test.simpleapp.domain.usecase.GetStarshipsUseCase
import com.test.simpleapp.presentation.vm.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    single<com.test.simpleapp.data.api.SWApi> {
        Retrofit.Builder()
            .baseUrl("https://swapi.dev/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(com.test.simpleapp.data.api.SWApi::class.java)

    }

    single<NetworkRepository> {
        NetworkRepositoryImpl(get())
    }

    single<GetStarshipsUseCase> {
        GetStarshipsUseCase( get() )
    }

    single<GetPlanetsUseCase> {
        GetPlanetsUseCase( get() )
    }

    viewModel {
        MainViewModel(
            get(),
            get()
        )
    }

}
