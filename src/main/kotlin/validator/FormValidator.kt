package com.mach.validator

import com.mach.entity.form.PerguntaRes
import com.mach.exception.DomainException
import java.util.InputMismatchException

class FormValidator {
    fun validate(list: List<PerguntaRes>) {
        validateSyntax(list)
    }

    fun validateSyntax(list: List<PerguntaRes>) {
        val nomeESobrenome = list[0].resposta.split("\\s+".toRegex())
        val wordCount = nomeESobrenome.size

        if (list.isEmpty()) throw InputMismatchException("O formulário está vazio.")
        if (wordCount < 2) throw DomainException("Você deve inserir um nome e sobrenome.")
    }
}