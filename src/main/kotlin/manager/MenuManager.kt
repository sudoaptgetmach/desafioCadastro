package com.mach.manager

import java.util.Scanner

class MenuManager {
    fun mostrarMenu() {
        while (true) {
            val scanner: Scanner = Scanner(System.`in`)

            val input = scanner.nextLine()

            when (input.toIntOrNull()) {
                1 -> TODO("cadastro")
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