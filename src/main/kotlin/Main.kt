package com.mach

import com.mach.manager.MenuManager
import com.mach.mapper.FormMapper
import kotlin.io.path.Path

fun main() {
    val menu = MenuManager()
    val mapper = FormMapper(Path("./src/main/resources/formulario.txt"))

    mapper.ler()
}