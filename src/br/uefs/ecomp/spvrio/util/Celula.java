package br.uefs.ecomp.spvrio.util;


/**
 * Classe Célula, responsável pela criação de cada elemento da lista encadeada,
 * recebe um objeto para criação individual de cada elemento.
 * 
 * @author Camille Jesus
 */
public class Celula {
    private Object objeto;
    private Celula proximo;
    
    /** Construtor da classe, responsável pela criação de uma nova célula, recebe
     * um objeto e cria uma célula específica para ele.
     * 
     * @param objeto
     */
    public Celula(Object objeto) {
        this.objeto = objeto;
        this.proximo = null;
    }

    /* Métodos que permitem verificar o estado dos atributos (retornando-o):
     */
    public Object getObjeto() {
        return objeto;
    }
    
    public Celula getProximo() {
        return proximo;
    }    
    
    /* Métodos que recebem parâmetros e guardam nos atributos:
     */
    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }

    public void setProximo(Celula proximo) {
        this.proximo = proximo;
    }
}