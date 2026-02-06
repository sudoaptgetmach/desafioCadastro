package com.mach.entity.form

const val NAO_INFORMADO = "Não informado."

data class Pet(
    val nomePet: String = NAO_INFORMADO,
    val tipo: TipoPet = TipoPet.NAO_ESPECIFICADO,
    val sexo: Sexo,
    val endereco: Endereco,
    val idade: String = NAO_INFORMADO,
    val peso: String = NAO_INFORMADO,
    val raca: String = NAO_INFORMADO
)

enum class TipoPet {
    CACHORRO,
    GATO,
    NAO_ESPECIFICADO
}

enum class Sexo {
    MACHO,
    FEMEA
}

data class Endereco(val rua: String,
                    val cidade: String,
                    val numero: String = NAO_INFORMADO)