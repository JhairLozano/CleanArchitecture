package com.belatrix.data.util


sealed class ExceptionUtil {
    class NetworkConnection : ExceptionUtil()
    class UsuarioNoEncontrado : ExceptionUtil()
}