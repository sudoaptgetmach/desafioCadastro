package com.mach.manager

import com.mach.service.CadastroService
import java.util.Scanner

class MenuManager {

    val service = CadastroService()
    val scanner: Scanner = Scanner(System.`in`)

    val menu = """
                1 - Cadastrar um novo pet
                2 - Alterar os dados do pet cadastrado
                3 - Deletar um pet cadastrado
                4 - Listar todos os pets cadastrados
                5 - Listar pets por algum critério (idade, nome, raça)
                6 - Sair
            """.trimIndent()

    fun mostrarMenu() {
        while (true) {
            println(menu)

            val input = scanner.nextLine()

            when (input.toIntOrNull()) {
                1 -> service.cadastrarPet()
                2 -> TODO("alterar dados")
                3 -> TODO("deletar pet")
                4 -> TODO("Listar pet")
                5 -> TODO("Listar pet por critério")
                6 -> break
                else -> println("Você deve inserir um valor válido.")
            }
        }
    }
}