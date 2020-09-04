package com.imaginatologintest.di.component.module

import com.imaginatologintest.presentation.login.LoginActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun provideLoginActivity(): LoginActivity

}