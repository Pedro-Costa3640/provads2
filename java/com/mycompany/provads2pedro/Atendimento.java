package com.mycompany.provads2pedro;

import java.time.LocalDate;

public class Atendimento {
    private String tipoConsulta;
    private String paciente;
    private LocalDate dataAtendimento;
    private double valorAtendimento;

    public Atendimento(String tipoConsulta, String paciente, double valorAtendimento) {
        this.tipoConsulta = tipoConsulta;
        this.paciente = paciente;
        this.dataAtendimento = LocalDate.now();
        this.valorAtendimento = valorAtendimento;
    }

    public double getValorAtendimento() {
        return valorAtendimento;
    }
}

