
package com.mycompany.provads2pedro;
import java.time.LocalDate;

public class Paciente {
    
    private String CPF;
    private String nome;
    private LocalDate DataNascimento;
    private int PlanodeSaude;
    
    public Paciente(String cpf, String nome, LocalDate dataNascimento, int planodeSaude) throws EValorInvalidoException {
        if (!validarDataNascimento(dataNascimento)) {
            throw new EValorInvalidoException("Valor Inválido!");
        }

        this.CPF = CPF;
        this.nome = nome;
        this.DataNascimento = dataNascimento;
        this.PlanodeSaude = planodeSaude;
    }

    public String getCpf() {
        return CPF;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return DataNascimento;
    }


    public int getPlanodeSaude() {
        return PlanodeSaude;
    }

    private boolean validarDataNascimento(LocalDate dataNascimento) {
        LocalDate hoje = LocalDate.now();
        return true; 
    }
}

