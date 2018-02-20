package br.uefs.ecomp.spvrio.model;


import br.uefs.ecomp.spvrio.util.*;


/**
 * Classe Dapertamento, permite criar departamentos de acordo com seus atributos
 * (características do objeto), um departamento tem como atributos seu id, nome e 
 * quantidade de vagas.
 * 
 * @author Camille Jesus
 */
public class Departamento {
    
    private int id;
    private final String nome;
    private int qtdVagas;
    private ILista listaConvocado;   //Lista de voluntários convocados (para cada departamento).

    /** Construtor da classe, recebe como parâmetro as informações para inicializar
     * os atributos e instanciar um novo objeto.
     * 
     * @param id
     * @param nome
     * @param qtdVagas
     */
    public Departamento(int id, String nome, int qtdVagas) {
        this.id = id;
        this.nome = nome;
        this.qtdVagas = qtdVagas;
        listaConvocado = new Lista();
    }

    /* Métodos que permitem verificar o estado dos atributos (retornando-o):
     */
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getQtdVagas() {
        return qtdVagas;
    }
    
    public ILista getListaConvocado() {
        return listaConvocado;
    }
    
    /* Métodos que recebem parâmetros e guardam nos atributos:
     */
    public void setId(int id) {
        this.id = id;
    }

    public void setQtdVagas(int qtdVagas) {
        this.qtdVagas = qtdVagas;
    }    

    /** Método que dá uma representação em String do objeto.
     * 
     * @return String
     */
    @Override
    public String toString() {
        return "Departamento - " + "Id: " + id + ", Nome: " + nome;
    }
    
    /** Método que verifica se dois departamentos são iguais retornando um valor booleano,
     * onde true significa que o objeto é igual e false que o objeto é diferente.
     * 
     * @param o
     * @return true ou false
     */
    public boolean equals(Object o) {
        
        if(o instanceof Departamento) {
            Departamento d = (Departamento) o;
            
            if (nome.equals(d.getNome())) {
                return true;
            }
        }
        return false;
    }
}