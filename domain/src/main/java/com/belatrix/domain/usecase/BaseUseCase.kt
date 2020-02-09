package com.belatrix.domain.usecase


abstract class BaseUseCase(private val executor: Executor) {

    fun uiExecute(uiFun: suspend () -> Unit) {
        executor.uiExecute { uiFun() }
    }

    fun asyncExecute(asyncFun: suspend () -> Unit) {
        executor.asyncExecute { asyncFun() }
    }

}