
package com.mycompany.provads2pedro;
import java.time.LocalDate;
import java.util.Date;

public class Checkup extends Consulta {
    private double valorAdicional;

    public Checkup(double valorAdicional, Paciente paciente, LocalDate dataAtendimento, String localdeAtendimento, double valor) throws EValorInvalidoException {
        super(paciente, dataAtendimento, localdeAtendimento, valor);
        this.valorAdicional = valorAdicional;
    if (valorAdicional < 0) {
            throw new EValorInvalidoException("Valor do check-up não pode ser negativo!");
        }

        this.valorAdicional = valorAdicional;
    }

    public double getValorAdicional() {
        return valorAdicional;
    }

    public double calcularValorTotal() {
        if ("PlanSenai".equals(getPaciente().getPlanodeSaude())) {
            return valorAdicional = valorAdicional * 0.15;
        } else {
            return valorAdicional;
        }
    }
}
    
