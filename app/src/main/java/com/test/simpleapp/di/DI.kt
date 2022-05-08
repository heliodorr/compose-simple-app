package com.test.simpleapp.di


import androidx.room.Room
import com.test.simpleapp.data.remote.SWApi
import com.test.simpleapp.data.repository.MainRepositoryImpl
import com.test.simpleapp.data.repository.utility.impl.CacheRepositoryImpl
import com.test.simpleapp.data.repository.utility.impl.InMemoryRepositoryImpl
import com.test.simpleapp.data.repository.utility.impl.NetworkRepositoryImpl
import com.test.simpleapp.data.room.db.LocalStorageDB
import com.test.simpleapp.data.repository.utility.interfaces.CacheRepository
import com.test.simpleapp.data.repository.utility.interfaces.InMemoryRepository
import com.test.simpleapp.data.repository.utility.interfaces.NetworkRepository
import com.test.simpleapp.data.room.dao.ItemsDao
import com.test.simpleapp.domain.repository.MainRepository
import com.test.simpleapp.domain.usecase.items.GetNavigationDataUseCase
import com.test.simpleapp.domain.usecase.items.GetRefreshedDataUseCase
import com.test.simpleapp.presentation.vm.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val SWAPI_URL = "https://swapi.dev/api/"
private const val SWAPI_TIMEOUT = 10L

val appModule = module {


    /* --------------------------------------------------------------------------------------
     * MAIN REPOSITORY FOR USECASES
     * -------------------------------------------------------------------------------------- */
    single<MainRepository> {

        MainRepositoryImpl(
            cacheRepository = get(),
            networkRepository = get(),
            inMemoryRepository = get(),
        )

        /*TestMainRepositoryImpl(
            cacheRepository = get(),
            networkRepository = get(),
            inMemoryRepository = get(),
        )*/

    }


    /* --------------------------------------------------------------------------------------
     * USECASE TO OBTAIN DATA AT START OR BY EXCPLICIT REFRESH IN FOLLOWING ORDER:
     *      NETWORK -> CACHE(MARKS OUTDATED) -> STORAGE(MARKS OUTDATED)
     * -------------------------------------------------------------------------------------- */
    single<GetRefreshedDataUseCase> {
        GetRefreshedDataUseCase(
            mainRepository = get(),
        )
    }

    /* --------------------------------------------------------------------------------------
     * USECASE TO OBTAIN DATA FOR NAVIGATION IN FOLLOWING ORDER:
     *     CACHE -> NETWORK -> DEVICE(MARKS OUTDATED)
     * -------------------------------------------------------------------------------------- */
    single<GetNavigationDataUseCase> {
        GetNavigationDataUseCase(
            mainRepository = get(),
        )
    }

    /* --------------------------------------------------------------------------------------
    * DB
    * -------------------------------------------------------------------------------------- */
    single<ItemsDao> {
        Room.databaseBuilder(
            androidContext(),
            LocalStorageDB::class.java,
            "items_db",
        )
            .build()
            .getItemsDao()
    }



    /* --------------------------------------------------------------------------------------
     * RETROFIT2
     * -------------------------------------------------------------------------------------- */
    single<SWApi> {

        Retrofit.Builder()
            .baseUrl(SWAPI_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SWApi::class.java)

    }



    /* --------------------------------------------------------------------------------------
     * NETWORK REPOSITORY - SWAPI.DEV
     * -------------------------------------------------------------------------------------- */
    single<NetworkRepository> {
        NetworkRepositoryImpl(
            api =  get(),
            SWAPI_TIMEOUT,
        )
    }



    /* --------------------------------------------------------------------------------------
     * RAM CACHE REPOSITORY
     * -------------------------------------------------------------------------------------- */
    single<CacheRepository> {
        CacheRepositoryImpl()
    }

    /* --------------------------------------------------------------------------------------
    * IN-MEMORY REPO
    * -------------------------------------------------------------------------------------- */
    single<InMemoryRepository> {
        InMemoryRepositoryImpl(
            dao = get()
        )
    }

    /* --------------------------------------------------------------------------------------
     * JUST AN USUAL VIEWMODEL
     * -------------------------------------------------------------------------------------- */
    viewModel {
        MainViewModel(
            getRefreshedDataUseCase = get(),
            getNavigationDataUseCase = get(),
        )
    }

}
