package com.belatrix.cleanarchitecture.ui.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.belatrix.cleanarchitecture.R
import com.belatrix.cleanarchitecture.model.Usuario
import com.belatrix.cleanarchitecture.ui.splash.presenter.SplashPresenter
import kotlinx.android.synthetic.main.activity_main.*

class SplashActivity : AppCompatActivity(), SplashPresenter.View {

    lateinit var presenter: SplashPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializePresenter()
    }

    override fun showUsuario(usuario: Usuario) {
        txv_usuario.text = usuario.usuario
    }

    private fun initializePresenter() {
        presenter.attachView(this)
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }

}
