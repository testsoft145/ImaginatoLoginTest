package com.imaginatologintest.di.component


import android.app.Application
import com.imaginatologintest.ImaginatoLoginTestApplication
import com.imaginatologintest.di.module.ActivityModule
import com.imaginatologintest.di.module.ApplicationModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, ActivityModule::class, ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: ImaginatoLoginTestApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

}