package com.imaginatologintest.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.imaginatologintest.di.key.ViewModelKey
import com.imaginatologintest.presentation.login.viewmodel.LoginViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import test.app.com.logintest.presentation.base.ViewModelFactory

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModule(loginViewModel: LoginViewModel): ViewModel

}