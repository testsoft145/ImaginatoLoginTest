package com.imaginatologintest.domain.usecase

import com.imaginatologintest.domain.UseCase
import com.imaginatologintest.domain.model.LoginData
import com.imaginatologintest.domain.repository.LoginRepository
import io.reactivex.Flowable

import javax.inject.Inject

class LoginUseCase @Inject
constructor(private val loginRepository: LoginRepository) : UseCase<LoginData, LoginUseCase.Params>() {

    override fun buildUseCaseFlowable(params: Params?): Flowable<LoginData> {
        return loginRepository.postLogin(params!!.name, params.password)
    }

    class Params(val name: String, val password: String)
}