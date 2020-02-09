package com.belatrix.cleanarchitecture.ui.splash.presenter

import com.belatrix.cleanarchitecture.model.Usuario
import com.belatrix.data.util.fold
import com.belatrix.domain.usecase.UsuarioUseCase

class SplashPresenter(private val obtenerUsuario: UsuarioUseCase) {

    var view: View? = null

    fun attachView(view: View) {
        this.view = view

        obtenerUsuario()
    }

    fun detachView() {
        this.view = null
    }


    private fun obtenerUsuario() {
        obtenerUsuario.execute(
            onResult = { result ->
                result.fold({ showError() }, { usuarioEntity ->
                    showUsuario(
                        Usuario(
                            usuarioEntity.id, usuarioEntity.usuario,
                            usuarioEntity.clave, usuarioEntity.token
                        )
                    )
                })
            })
    }

    private fun showUsuario(usuario: Usuario) {
        view?.showUsuario(usuario)
    }

    private fun showError() {
    }

    interface View {
        fun showUsuario(usuario: Usuario)
    }
}