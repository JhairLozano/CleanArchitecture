package com.belatrix.data.repository.network

import com.belatrix.data.repository.database.entity.UsuarioEntity
import com.belatrix.data.util.Either
import com.belatrix.data.util.ExceptionUtil

interface UsuarioRepository {
    fun getAll(): Either<ExceptionUtil, UsuarioEntity>
}