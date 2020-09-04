package com.imaginatologintest.di.module

import android.app.Application
import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.imaginatologintest.data.remote.repository.LoginDataRepository
import com.imaginatologintest.domain.repository.LoginRepository
import dagger.Module
import dagger.Provides

import javax.inject.Singleton

@Module(includes = arrayOf(ViewModelModule::class))
class ApplicationModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    internal fun  provideLoginRepository(loginDataRepository: LoginDataRepository): LoginRepository
    {
        return loginDataRepository;
    }
}