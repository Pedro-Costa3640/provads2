
package com.mycompany.provads2pedro;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Clinica {
    private String nome;
    private String endereco;
    private String cnpj;
    private double valorConsultaSimples;
    private double valorAdicionalCheckup;
    private List<Atendimento> atendimentosRealizados;

    public Clinica(String nome, String endereco, String cnpj, double valorConsultaSimples, double valorAdicionalCheckup) {
        if (valorConsultaSimples < 0 || valorAdicionalCheckup < 0) {
            throw new EValorInvalidoException("Os valores não podem ser negativos.");
        }

        this.nome = nome;
        this.endereco = endereco;
        this.cnpj = cnpj;
        this.valorConsultaSimples = valorConsultaSimples;
        this.valorAdicionalCheckup = valorAdicionalCheckup;
        this.atendimentosRealizados = new ArrayList<>();
    }

    public void alterarValorConsultaSimples(double novoValor) {
        if (novoValor < 0) {
            throw new EValorInvalidoException("O novo valor não pode ser negativo.");
        }
        this.valorConsultaSimples = novoValor;
    }

    public List<Atendimento> getAtendimentosRealizados() {
        return atendimentosRealizados;
    }

    
    
    public void alterarValorAdicionalCheckup(double novoValor) {
        if (novoValor < 0) {
            throw new EValorInvalidoException("O novo valor não pode ser negativo.");
        }
        this.valorAdicionalCheckup = novoValor;
    }

    public double getValorTotal() {
        double total = 0;
        for (Atendimento atendimento : atendimentosRealizados) {
            total += atendimento.getValorAtendimento();
        }
        return total;
    }

    public double realizarAtendimento(String tipoConsulta, String paciente) throws EAtendimentoNaoRegistradoException {
        double valorAtendimento;

        if ("simples".equals(tipoConsulta)) {
            valorAtendimento = valorConsultaSimples;
        } else if ("checkup".equals(tipoConsulta)) {
            valorAtendimento = valorConsultaSimples + valorAdicionalCheckup;
        } else {
            throw new EAtendimentoNaoRegistradoException("Tipo de consulta não reconhecido.");
        }

        Atendimento atendimento = new Atendimento(tipoConsulta, paciente, valorAtendimento);
        atendimentosRealizados.add(atendimento);
        return atendimento.getValorAtendimento();
    }

}


