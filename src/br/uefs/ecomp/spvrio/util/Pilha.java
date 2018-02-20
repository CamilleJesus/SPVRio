package br.uefs.ecomp.spvrio.util;


/**
 * Classe Pilha, implementada a partir dos métodos da interface IPilha.
 * 
 * @author Camille Jesus
 */
public class Pilha implements IPilha {
    private ILista pilha;   //Declara um objeto do tipo ILista, para usar métodos da lista.

    /** Construtor da classe, instancia o objeto tipo lista "pilha", que aponta para nulo.
     * 
     */
    public Pilha() {
        pilha = new Lista();
    }
    
    /** Método que verifica o tamanho da lista em tempo de execução
     * 
     * @return int
     */
    @Override
    public int obtertTamanho() {
        return pilha.obterTamanho();
    }

    /** Método que verifica se a pilha está vazia.
     * 
     * @return true ou false
     */
    @Override
    public boolean estaVazia() {
        return pilha.estaVazia();
    }

    /** Método que remove o primeiro elemento da pilha.
     * 
     * @return Object
     */
    @Override
    public Object removerTopo() {
        return pilha.removerInicio();
    }

    /** Método que recebe um objeto para inserir no início da pilha.
     * 
     * @param obj
     */
    @Override
    public void inserirTopo(Object obj) {
        pilha.inserirInicio(obj);
    }

    /** Método que recupera o primeiro elemento da pilha.
     * 
     * @return Object
     */
    @Override
    public Object recuperarTopo() {
        return pilha.recuperar(0);
    }    
}