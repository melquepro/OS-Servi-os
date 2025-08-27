package com.example.ordemservico.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
data class OrdemServico(
    val id: Long = 0,
    val numero: String = "",
    val cliente: Cliente = Cliente(),
    val servico: Servico = Servico(),
    val descricaoProblema: String = "",
    val observacoes: String = "",
    val dataAbertura: Date = Date(),
    val dataPrevista: Date? = null,
    val dataFechamento: Date? = null,
    val status: StatusOrdem = StatusOrdem.ABERTA,
    val prioridade: Prioridade = Prioridade.MEDIA,
    val valorServico: Double = 0.0,
    val valorPecas: Double = 0.0,
    val valorTotal: Double = valorServico + valorPecas,
    val tecnicoResponsavel: String = ""
) : Parcelable

@Parcelize
data class Cliente(
    val id: Long = 0,
    val nome: String = "",
    val telefone: String = "",
    val email: String = "",
    val endereco: String = "",
    val cpfCnpj: String = ""
) : Parcelable

@Parcelize
data class Servico(
    val id: Long = 0,
    val nome: String = "",
    val descricao: String = "",
    val categoria: String = "",
    val valorPadrao: Double = 0.0
) : Parcelable

enum class StatusOrdem {
    ABERTA,
    EM_ANDAMENTO,
    AGUARDANDO_PECA,
    AGUARDANDO_CLIENTE,
    CONCLUIDA,
    CANCELADA
}

enum class Prioridade {
    BAIXA,
    MEDIA,
    ALTA,
    URGENTE
}