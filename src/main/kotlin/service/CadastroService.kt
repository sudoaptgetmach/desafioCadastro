package com.mach.service

import com.mach.mapper.FormMapper
import java.util.Scanner

class CadastroService {

    val mapper = FormMapper("./src/main/resources/formulario.txt")

    fun cadastrarPet() {
        val sc = Scanner(System.`in`)
        val menu = """
            1 - Cadastrar pelo arquivo formulario.txt
            2 - Cadastrar pelo formulário
            0 - Voltar
        """.trimIndent()

        println(menu)

        when (sc.nextLine().toIntOrNull()) {
            1 -> mapper.cadastrar()
            2 -> mapper.lerPerguntas()
            0 -> return
            else -> println("Você deve inserir uma opção válida.")
        }
    }
}