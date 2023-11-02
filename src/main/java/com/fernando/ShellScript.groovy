package com.fernando

import groovy.transform.CompileStatic
import jakarta.enterprise.context.ApplicationScoped

@SuppressWarnings('ClassJavadoc')
@CompileStatic
@ApplicationScoped
class ShellScript {

    @SuppressWarnings('GrMethodMayBeStatic')
    BigDecimal calcularMedia(BigDecimal nota1, BigDecimal nota2) {
        String expressao = '( NOTA1 + NOTA2 ) / 2'
        Binding binding = new Binding()
        binding.setVariable('NOTA1', nota1)
        binding.setVariable('NOTA2', nota2)
        GroovyShell shell = new GroovyShell(binding)
        BigDecimal resultado = shell.evaluate(expressao) as BigDecimal
        return resultado
    }

    @SuppressWarnings('GrMethodMayBeStatic')
    Boolean estaAprovado(BigDecimal notaFinal) {
        String expressao = 'NOTA_FINAL >= 7'
        Binding binding = new Binding()
        binding.setVariable('NOTA_FINAL', notaFinal)
        GroovyShell shell = new GroovyShell(binding)
        return shell.evaluate(expressao) as Boolean
    }

}
