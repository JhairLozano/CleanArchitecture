package com.belatrix.data.repository.network

import android.app.Application
import com.belatrix.data.repository.database.entity.UsuarioEntity
import com.belatrix.data.util.Either
import com.belatrix.data.util.ExceptionUtil

class UsuarioRepositoryImpl(val context: Application) : UsuarioRepository {

    override fun getAll(): Either<ExceptionUtil, UsuarioEntity> {
        try {

            return Either.Right(
                UsuarioEntity(
                    1,
                    "Jhair Vincenzo Lozano Angulo",
                    "belatrix",
                    "71820077"
                )
            );

        } catch (ex: Exception) {
            return Either.Left(ExceptionUtil.NetworkConnection())
        }
    }

}