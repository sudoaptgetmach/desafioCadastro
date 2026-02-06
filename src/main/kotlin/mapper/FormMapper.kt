package com.mach.mapper

import java.io.File
import java.io.FileNotFoundException
import java.nio.file.Path
import java.util.Scanner

class FormMapper(private val filePath: Path) {
    fun ler() {
        val list: HashMap<String, String> = HashMap();
        try {
            Scanner(File("./src/main/resources/formulario.txt")).use { read ->
                while (read.hasNext()) {
                    TODO("Implementar o mapper do .txt")
                }
            }
        } catch (e: FileNotFoundException) {
            println("Falha ao ler o arquivo.")
            e.printStackTrace()
        }
    }
}