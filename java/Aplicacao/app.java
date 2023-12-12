
package Aplicacao;
import com.mycompany.provads2pedro.Clinica;
import com.mycompany.provads2pedro.Consulta;
import com.mycompany.provads2pedro.Paciente;
import com.mycompany.provads2pedro.EAtendimentoNaoRegistradoException;
import com.mycompany.provads2pedro.EValorInvalidoException;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.Month;

public class app {
    public static void main(String[] args) {  
    
        Scanner ler = new Scanner(System.in);    
        Clinica clinica = new Clinica("Senai Med", "Av Dendezeiros, 188, Bonfim", "", 80.0, 120.0);

        try {
        while (true) {
                    System.out.println("Escolha uma das alternativas");
                    System.out.println("a - Realizar atendimento");
                    System.out.println("b - Consultar a média de valor");
                    System.out.println("c - Alterar o valor da consulta simples ou o adicional para exames");

                    String opcao = ler.next().toLowerCase();

                    switch(opcao) {
                        case "a":
                            realizarAtendimento(ler, clinica);
                            break;
                        case "b":
                            consultarMediaValorAtendimentos(clinica);
                            break;
                        case "c":
                            alterarValoresConsulta(ler, clinica);
                            break;
                        default:
                            System.out.println("Opção não pre-definida. Tente novamente.");
                    }
                }
            } catch (EAtendimentoNaoRegistradoException e) {
                System.out.println("Erro: " + e.getMessage());
            }  
        }
        private static void realizarAtendimento(Scanner ler, Clinica clinica) throws EAtendimentoNaoRegistradoException {
            System.out.println("Qual a sua consulta? Simples ou Check-up?:");
            String tipoAtendimento = ler.next();
            System.out.println("Informe o CPF do paciente:");
            String cpf = ler.next();
            System.out.println("Informe o nome do paciente:");
            String nome = ler.next();
            System.out.println("Informe a data de nascimento (formato dd/MM/yyyy):");
            String dataNascimento = ler.next();
            System.out.println("Informe o plano de saúde do paciente:");
            String planoSaude = ler.next();
            System.out.println("Informe a data do atendimento (formato dd/MM/yyyy):");
            String dataAtendimento = ler.next();
            System.out.println("Informe o local do atendimento:");
            String localAtendimento = ler.next();

            try {
                Paciente paciente = new Paciente(cpf, nome, LocalDate.of(0, Month.MARCH, 0), 0);
                double valorAtendimento = clinica.realizarAtendimento("Consulta", planoSaude);
                System.out.println("Atendimento realizado com sucesso. Valor do atendimento: " + valorAtendimento);
            } catch (EValorInvalidoException ex) {
                throw new EAtendimentoNaoRegistradoException("Não foi possível realizar o atendimento: " + ex.getMessage());
            }
        }

          private static void consultarMediaValorAtendimentos(Clinica clinica) {
            double media = clinica.getValorTotal() / clinica.getAtendimentosRealizados().size();
            System.out.println("Média de valor dos atendimentos realizados: " + media);
        }

        private static void alterarValoresConsulta(Scanner ler, Clinica clinica){
            System.out.println("Informe o novo valor da consulta simples:");
            double novoValorConsultaSimples = ler.nextDouble();
            System.out.println("Informe o novo valor adicional para exames:");
            double novoValorAdicionalExames = ler.nextDouble();

            clinica.alterarValorAdicionalCheckup(novoValorConsultaSimples);
            System.out.println("Valores alterados com sucesso.");

    }

}