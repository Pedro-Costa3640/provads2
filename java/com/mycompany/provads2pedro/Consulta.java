
package com.mycompany.provads2pedro;
import java.time.LocalDate;

public class Consulta{
    private Paciente paciente;
    private LocalDate dataAtendimento;
    private String localdeAtendimento;
    private double valor;

    public Consulta(Paciente paciente, LocalDate dataAtendimento, String localdeAtendimento, double valor) throws EValorInvalidoException {
        if (!validarDataAtendimento(dataAtendimento) || valor < 0) {
            throw new EValorInvalidoException("Data inválida ou valor negativo");
        }

        this.paciente = paciente;
        this.dataAtendimento = dataAtendimento;
        this.localdeAtendimento = localdeAtendimento;
        this.valor = valor;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public LocalDate getDataAtendimento() {
        return dataAtendimento;
    }

    public String getLocaldeAtendimento() {
        return localdeAtendimento;
    }

    public double getValor() {
        return valor;
    }

    private boolean validarDataAtendimento(LocalDate data) {
        return true;
    }
}


    
