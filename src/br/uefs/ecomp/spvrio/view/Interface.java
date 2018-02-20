/*
 * Autora: Camille Jesus
 * Componente Curricular: EXA863 - MI Programação
 * Data: 27/3/15
 * Declaro que este código foi elaborado por mim de forma individual e não contém
 * algum trecho de código de outro autor, tais como provindos de livros ou apostilas,
 * e páginas ou documentos eletrônicos da internet. Qualquer trecho de código de
 * outra autoria, que não minha, poderá estar destacado com uma citação para o
 * autor ou a fonte do código e estou ciente que estes trechos não serão considerados
 * para fins de avaliação.
 *
 */

package br.uefs.ecomp.spvrio.view;


import br.uefs.ecomp.spvrio.controller.SPVController;
import br.uefs.ecomp.spvrio.model.*;
import br.uefs.ecomp.spvrio.util.*;

import java.io.IOException;

/**
 * Classe Interface, tem como característica principal a interação com o usuário,
 * o menu é mostrado e o usuário entra com os dados necessários para o correto
 * funcionamento do programa.
 * 
 * @author Camille Jesus
 */
public class Interface {        
    private static SPVController controller = new SPVController();
    
    /** O metódo main é o ponto de partida do programa sistema. O menu é apresentado
     * e a leitura dos dados pelo teclado é feita a partir dos métodos do Console.
     * 
     * @param args
     */
    public static void main (String[] args) throws IOException {
        boolean laço = true;
                
        System.out.println("::.  Sistema para o Programa de Voluntários Rio 2016 (SPV Rio)  .::");
        
        /* Menu descritivo:
         */
        do {
            System.out.println("\n [1] - Cadastrar candidato\n [2] - Consultar candidato\n "
                    + "[3] - Cadastrar departamento\n [4] - Consultar departamento\n "
                    + "[5] - Distribuir vagas\n [6] - Listar convocados por departamento\n "
                    + "[7] - Listar candidatos na lista de reserva\n [8] - Permitir desistência\n "
                    + "[9] - Calcular porcentagem de candidatos muito satisfeitos");
            System.out.println(" [0] - Sair");
            int escolha = Console.readInt();

            switch (escolha) {
                case 0:
                    System.exit(0);
                    break;

                case 1:
                    System.out.println("\n Informe \n\nNome: ");
                    String nomeC = Console.readString();
                    System.out.println("Nacionalidade: ");
                    String nacionalidade = Console.readString();
                    System.out.println("País: ");
                    String pais = Console.readString();
                    System.out.println("Estado: ");
                    String estado = Console.readString();
                    System.out.println("Bairro: ");
                    String bairro = Console.readString();
                    System.out.println("Rua: ");
                    String rua = Console.readString();
                    System.out.println("Número: ");
                    int numero = Console.readInt();
                    System.out.println("CEP: ");
                    int cep = Console.readInt();
                    System.out.println("1ª Opção: ");
                    String opcao1 = Console.readString();
                    System.out.println("2ª Opção: ");
                    String opcao2 = Console.readString();
                    controller.cadastrarCandidato(nomeC, nacionalidade, pais, estado, bairro, rua, numero, cep, opcao1, opcao2);
                    break;

                case 2:
                    System.out.println("\n Informe \nId: ");
                    int idC = Console.readInt();
                    try { 
                        Candidato candidato = (Candidato) controller.obterCandidato(idC);
                        System.out.println(candidato.toString());
                    } catch(java.lang.NullPointerException e) {
                        System.out.println(" Candidato não encontrado.");
                    }
                    break;

                case 3:
                    System.out.println("\n Informe \n\nId: ");
                    int idD = Console.readInt();
                    System.out.println("Nome: ");
                    String nomeD = Console.readString();
                    System.out.println("Quantidade de Vagas: ");
                    int qtdVagas = Console.readInt();
                    controller.cadastrarDepartamento(idD, nomeD, qtdVagas);
                    break;

                case 4:
                    System.out.println("\n Informe \nId: ");
                    int id = Console.readInt();
                    try {
                        Departamento departamento = (Departamento) controller.obterDepartamento(id);
                        System.out.println(departamento.toString());
                    } catch(java.lang.NullPointerException e) {
                        System.out.println("Departamento não encontrado.");
                    }
                    break;

                case 5:
                    controller.distribuirVagas();
                    System.out.println("Vagas distribuídas.");
                    break;

                case 6:
                    System.out.println("\n Informe \nId do departamento: ");
                    int idCD = Console.readInt();
                    try {
                        Departamento departamento = controller.obterDepartamento(idCD);
                        Iterador iter = (Iterador)  controller.listarVoluntarios(departamento);

                        while (iter.temProximo()){
                            Candidato candidato = (Candidato) iter.obterProximo();
                            System.out.println(candidato.toString());   
                        }
                    } catch(java.lang.NullPointerException e) {
                        System.out.println("Departamento não encontrado.");
                    }
                    break;

                case 7:
                    Iterador iter = controller.listarReserva();

                    while (iter.temProximo()){
                        Candidato candidato = (Candidato) iter.obterProximo();
                        System.out.println(candidato.toString());
                    }
                    break;

                case 8:
                    System.out.println("\n Informe \nId do candidato: ");
                    int idPD = Console.readInt();
                    try {
                        Candidato candidato = controller.obterCandidato(idPD);
                        controller.desistir(candidato);
                    } catch(java.lang.NullPointerException e){
                        System.out.println("Candidato não encontrado.");                
                    }
                    break;

                case 9:
                    System.out.println(controller.calcPorcSatisfeitos()+"%");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
                }     
        } while (laço);
    }
}