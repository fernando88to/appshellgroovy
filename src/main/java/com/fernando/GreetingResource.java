package com.fernando;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.math.BigDecimal;

import org.jboss.logging.Logger;

@Path("/escola")
public class GreetingResource {

    @Inject
    Logger log;
    @Inject
    ShellScript shellScript;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/calcularmedia")
    public String calcularMedia() {
        BigDecimal resultado = shellScript.calcularMedia(new BigDecimal("5.50"), new BigDecimal("8.0"));
        log.info("Resultado = " + resultado);
        return "Resultado = " + resultado;
    }


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/estaaprovado")
    public String estaAprovado() {
        Boolean resultado = shellScript.estaAprovado(new BigDecimal("7"));
        log.info("Aprovado = " + resultado);
        return "Aprovado = " + resultado;
    }
}
