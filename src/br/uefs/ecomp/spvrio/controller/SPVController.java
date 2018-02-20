package br.uefs.ecomp.spvrio.controller;


import br.uefs.ecomp.spvrio.model.*;
import br.uefs.ecomp.spvrio.util.*;

/**
 * A classe SPVController, como o nome sugere, é o controlador, ele é responsável
 * por intermediar a comunicação entre os componentes do sistema, a interação de
 * todas as classes.
 */
public class SPVController {
    private ILista listaCandidato, listaDepartamento, listaReserva, listaGeral;
    private static int satisfeitoC, totalC;
    
    // Construtor do SPVController, onde os atributos são inicializados:
    public SPVController() {
        listaCandidato = new Lista();   //Lista de candidatos recém-cadastrados, antes da distribuição de vagas.
        listaDepartamento = new Lista();
        listaReserva = new Lista();
        listaGeral = new Lista();   //Lista geral de candidatos, consta todos os cadastrados.
    }

    /** Método para cadastrar candidato, ele recebe todas as suas informações, 
     * sua referência é salva ao final de duas listas encadeadas e retorna o 
     * candidato que acabou de ser cadastrado.
     * 
     * @param nome
     * @param nacionalidade
     * @param pais
     * @param estado
     * @param bairro
     * @param rua
     * @param numero
     * @param cep
     * @param opcao1
     * @param opcao2     * 
     * @return candidato
     */
    public Candidato cadastrarCandidato(String nome, String nacionalidade,
        String pais, String estado, String bairro, String rua, int numero, 
        int cep, String opcao1, String opcao2) {
        
        Candidato candidato = new Candidato(nome, nacionalidade, pais, estado,
                                    bairro, rua, numero, cep, opcao1, opcao2);
        listaCandidato.inserirFinal(candidato);
        listaGeral.inserirFinal(candidato);
        totalC++;
        return candidato;
    }

    /** Método para obter (encontrar) candidato, recebe como parâmetro seu id.
     * A lista de candidatos é percorrida até que algum voluntário tenha o id
     * desejado ou ela chegue ao fim, ao ser encontrado, sua referência é 
     * retornada, caso contrário retorna nulo.
     * 
     * @param id
     * @return candidato
     */
    public Candidato obterCandidato(Integer id) {
        
        for (int i = 0; i < listaGeral.obterTamanho(); i++) {
            Candidato candidato = (Candidato) listaGeral.recuperar(i);
            
            if (candidato.getId() == id) {
                return candidato;
            }
        }
        return null;
    }

    /** Método para cadastrar departamento, ele recebe todas as suas informações, 
     * sua referência é salva ao final de uma lista encadeada e retorna o 
     * departamento que acabou de ser cadastrado.
     * 
     * @param id
     * @param nome
     * @param qtdVagas     * 
     * @return departamento
     */
    public Departamento cadastrarDepartamento(int id, String nome, int qtdVagas) {
        Departamento departamento = new Departamento(id, nome, qtdVagas);
        listaDepartamento.inserirFinal(departamento);
        return departamento;        
    }

    /** Método para obter (encontrar) departamento, recebe como parâmetro seu id.
     * A lista de departamentos é percorrida até que algum tenha o id desejado
     * ou ela chegue ao fim, ao ser encontrado, sua referência é retornada,
     * caso contrário retorna nulo.
     * 
     * @param id
     * @return departamento
     */
    public Departamento obterDepartamento(Integer id) {
        
        for (int i = 0; i < listaDepartamento.obterTamanho(); i++) {
            Departamento departamento = (Departamento) listaDepartamento.recuperar(i);
            
            if (departamento.getId() == id) {
                return departamento;
            }
        }
        return null;
    }

    /** Método para distribuir os candidatos nos departamentos. A lista de
     * reserva e de departamentos é percorrida totalmente por cada candidato, se
     * o departamento de sua primeira opção estiver com disponibilidade de vaga
     * e ele ainda não tenha sido convocado, ele entra. Verifica-se sua segunda
     * opção da mesma maneira (exceto para candidatos da lista de reserva), pois
     * ele pode não ter conseguido a vaga na primeira opção. Após isso, caso ele
     * ainda não tenha sido convocado, entra na lista de reserva (candidatos da
     * reserva, continuam lá).
     */
    public void distribuirVagas() {
        
        if (listaReserva.estaVazia() == false) {
            
            for (int i = 0; i < listaReserva.obterTamanho(); i++) {
            Candidato candidato = (Candidato) listaReserva.recuperar(i);
            
                for (int j = 0; j < listaDepartamento.obterTamanho(); j++) {
                    Departamento departamento = (Departamento) listaDepartamento.recuperar(j);
                    
                    if ((departamento.getNome()).equals(candidato.getOpcao1()) && departamento.getQtdVagas() > 0) {                    
                        candidato.setConvocado(true);
                        candidato.setReserva(false);
                        departamento.getListaConvocado().inserirFinal(candidato);
                        departamento.setQtdVagas(departamento.getQtdVagas() - 1);
                        listaReserva.removerPosicao(candidato);
                    }
                }          
            }
        }
     
        for (int i = 0; i < listaCandidato.obterTamanho(); i++) {
            Candidato candidato = (Candidato) listaCandidato.recuperar(i);
        
            for (int j = 0; j < listaDepartamento.obterTamanho(); j++) {
                Departamento departamento = (Departamento) listaDepartamento.recuperar(j);
            
                if ((departamento.getNome()).equals(candidato.getOpcao1()) && 
                   departamento.getQtdVagas() > 0 && candidato.getConvocado() == false) {                    
                    candidato.setConvocado(true);
                    departamento.getListaConvocado().inserirFinal(candidato);
                    departamento.setQtdVagas(departamento.getQtdVagas() - 1);
                    satisfeitoC++;
                }
            }
            
            for (int j = 0; j < listaDepartamento.obterTamanho(); j++) {
                Departamento departamento = (Departamento) listaDepartamento.recuperar(j);
                
                if ((departamento.getNome()).equals(candidato.getOpcao2())
                          && departamento.getQtdVagas() > 0 && candidato.getConvocado() == false) {
                    candidato.setConvocado(true);
                    departamento.getListaConvocado().inserirFinal(candidato);
                    departamento.setQtdVagas(departamento.getQtdVagas() - 1);
                }
            }
            
            if (candidato.getConvocado() == false && candidato.getReserva() == false) {
                listaReserva.inserirFinal(candidato);
                candidato.setReserva(true);
            }
        }
        listaCandidato.removerInicio();
    }

    /** Método que retorna um objeto da classe Iterador, que faz referência à
     * lista de convocados de determinado departamento.
     * 
     * @param d
     * @return iterador
     */
    public Iterador listarVoluntarios(Departamento d) {
        
        for (int i = 0; i < listaDepartamento.obterTamanho(); i++) {
            Departamento departamento = (Departamento) listaDepartamento.recuperar(i);
            
            if (d.equals(departamento)) {
                return departamento.getListaConvocado().iterador();
            }
        }
        return null;
    }

    /** Método que retorna um objeto da classe Iterador, que faz referência à 
     * lista de reserva dos departamentos.
     * 
     * @return iterador
     */
    public Iterador listarReserva() {
        return listaReserva.iterador();
    }

    /** Método que possibilita desistência, de convocação imediata do voluntário.
     * Ele vai para a lista de reserva e sai da lista de convocados do departamento
     * em que estava, liberando uma vaga.
     * 
     * @param c
     */
    public void desistir(Candidato c) {
        
        for (int i = 0; i < listaDepartamento.obterTamanho(); i++) {
            Departamento departamento = (Departamento) listaDepartamento.recuperar(i);
            
            for (int j = 0; j < departamento.getListaConvocado().obterTamanho(); j++) {
                Candidato candidato = (Candidato) departamento.getListaConvocado().recuperar(j);
                    
                if (c.equals(candidato)) {                    
                    listaReserva.inserirFinal(c);
                    candidato.setConvocado(false);
                    candidato.setReserva(true);
                    departamento.getListaConvocado().removerPosicao(c);
                    departamento.setQtdVagas(departamento.getQtdVagas() + 1);
                }
            }
        }
    }

    /** Método que calcula a porcentagem de candidatos que conseguiram se vincular
     * ao departamento escolhido como primeira opção.
     * 
     * @return int
     */
    public Integer calcPorcSatisfeitos() {
        return (satisfeitoC / totalC * 100);
    }
}