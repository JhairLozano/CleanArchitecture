package com.belatrix.domain.usecase

import com.belatrix.data.repository.database.entity.UsuarioEntity
import com.belatrix.data.repository.network.UsuarioRepository
import com.belatrix.data.util.Either
import com.belatrix.data.util.ExceptionUtil


class UsuarioUseCase(
    private val usuarioRepository: UsuarioRepository,
    private val executor: Executor
) : BaseUseCase(executor) {


    private var onUsuarioLoaded: (UsuarioEntity) -> Unit = {}
    private var onConnectionError: () -> Unit = {}

    fun execute(onResult: (Either<ExceptionUtil, UsuarioEntity>) -> Unit) {
        this.onUsuarioLoaded = onUsuarioLoaded
        this.onConnectionError = onConnectionError

        asyncExecute {
            val usuarioResult = usuarioRepository.getAll()

            uiExecute { onResult(usuarioResult) }
        }
    }
}