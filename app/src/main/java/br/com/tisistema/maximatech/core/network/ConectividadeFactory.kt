package br.com.tisistema.maximatech.core.network

import android.os.Build
import br.com.tisistema.tiembarque.core.network.callback.CallbackDaConectividade
import br.com.tisistema.tiembarque.core.network.callback.CallbackDaConectividadeParaVersaoDoAndroidMaiorQueM
import br.com.tisistema.maximatech.core.network.callback.CallbackDaConectividadeParaVersaoDoAndroidMenorQueM
import br.com.tisistema.tiembarque.core.network.verificarconexao.VerificadorDeConexao
import br.com.tisistema.tiembarque.core.network.verificarconexao.VerificadorDeConexaoSeAVersaoDoAndroidForMaiorQueM
import br.com.tisistema.tiembarque.core.network.verificarconexao.VerificadorDeConexaoSeAVersaoDoAndroidForMenorQueM

class ConectividadeFactory private constructor() {

    object CALLBACK {
        fun getConectividade(): CallbackDaConectividade {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                CallbackDaConectividadeParaVersaoDoAndroidMaiorQueM.getInstance()
            } else {
                CallbackDaConectividadeParaVersaoDoAndroidMenorQueM.getInstance()
            }
        }
    }

    object CHECKER {
        fun getVerificadorDeConectividade(): VerificadorDeConexao {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                VerificadorDeConexaoSeAVersaoDoAndroidForMaiorQueM.getInstance()
            } else {
                VerificadorDeConexaoSeAVersaoDoAndroidForMenorQueM.getInstance()
            }
        }
    }
}