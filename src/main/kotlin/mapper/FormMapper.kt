package com.mach.mapper

import com.mach.entity.form.PerguntaRes
import com.mach.validator.FormValidator
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Scanner

class FormMapper(private val filePath: String) {

    val validator = FormValidator()

    val date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"))
    val hour = LocalDateTime.now().format(DateTimeFormatter.ofPattern("hhmm"))

    fun cadastrar() {
        val linhasDoArquivo = File(filePath).readLines()
        val listaMapeada = mutableListOf<PerguntaRes>()

        var bufferPergunta = ""
        var bufferResposta = ""

        val padraoNovaPergunta = Regex("^\\d+\\s-")

        for (linha in linhasDoArquivo) {
            if (padraoNovaPergunta.containsMatchIn(linha)) {

                if (bufferPergunta.isNotEmpty()) {
                    listaMapeada.add(PerguntaRes(bufferPergunta.trim(), bufferResposta.trim()))
                }

                val textoAposNumero = linha.substringAfter("-")
                bufferPergunta = textoAposNumero.substringBefore("?") + "?"
                bufferResposta = textoAposNumero.substringAfter("?", "")

            } else {
                bufferResposta += " $linha"
            }
        }

        if (bufferPergunta.isNotEmpty()) {
            listaMapeada.add(PerguntaRes(bufferPergunta.trim(), bufferResposta.trim()))
        }

        criarPetCadastrado(listaMapeada)
    }

    fun lerPerguntas() {
        val sc = Scanner(System.`in`)

        val linhasDoArquivo = File(filePath).readLines()
        val listaMapeada = mutableListOf<PerguntaRes>()

        var bufferPergunta = ""

        val padraoNovaPergunta = Regex("^\\d+\\s-")

        for (linha in linhasDoArquivo) {
            if (padraoNovaPergunta.containsMatchIn(linha)) {

                if (bufferPergunta.isNotEmpty()) {
                    listaMapeada.add(PerguntaRes(bufferPergunta.trim(), ""))
                }

                val textoAposNumero = linha.substringAfter("-")
                bufferPergunta = textoAposNumero.substringBefore("?") + "?"
            }
        }

        if (bufferPergunta.isNotEmpty()) {
            listaMapeada.add(PerguntaRes(bufferPergunta.trim(), ""))
        }

        listaMapeada.forEachIndexed { index, res ->
            println(res.pergunta)
            listaMapeada.elementAt(index).resposta = sc.nextLine()
        }

        criarPetCadastrado(listaMapeada)
    }

    fun criarPetCadastrado(lista: List<PerguntaRes>) {
        try {
            validator.validate(lista)
        } catch (e: Exception) {
            println(e.message)
            return
        }

        val formattedName = lista[0].resposta.uppercase().replace(" ", "")
        val cadastroFile = "${date}T${hour}-${formattedName}.txt"
        val bw = BufferedWriter(FileWriter("./petsCadastrados/${cadastroFile}"))

        lista.forEachIndexed { index, res ->
            try {
                bw.write("${index + 1} - ${res.resposta}\n")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        bw.close()
    }
}