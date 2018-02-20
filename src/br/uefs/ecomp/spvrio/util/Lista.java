package br.uefs.ecomp.spvrio.util;


/**
 * Classe Lista, implementada a partir dos métodos da interface ILista.
 * 
 * @author Camille Jesus
 */
public class Lista implements ILista {
    
    private Celula primeiro;   //Declara um objeto do tipo célula.

    /* Construtor da classe, faz o objeto célula "primeiro" apontar para nulo.
     */
    public Lista() {
        primeiro = null;
    }
    
    /** Método que verifica se a lista encadeada está vazia, a condição já é 
     * feita no retorno; se a célula aponta para nulo retorna "true" (valor lógico,
     * verdadeiro) portanto tem pelo menos um elemento na lista, caso não, retorna
     * "false", e a lista está vazia.
     * 
     * @return true ou false
     */
    @Override
    public boolean estaVazia() {
        return (primeiro == null);
    }

    /** Método que verifica o tamanho da lista em tempo de execução, ele a percorre
     * contando cada elemento até que não haja mais elementos, o tamanho obtido
     * é retornado.
     * 
     * @return tamanho
     */
    @Override
    public int obterTamanho() {
        int tamanho = 0;
        Celula aux = primeiro;
        
        while (aux != null) {
            tamanho++;
            aux = aux.getProximo();
        }
        return tamanho;
    }
    
    /** Método que recebe um objeto para inserir no início da lista. Após receber
     * o objeto, uma nova célula é criada. O campo próximo da nova célula aponta
     * para a primeira e agora, a primeira célula da lista é a que acabou de ser
     * inserida.
     * 
     * @param o
     */
    @Override
    public void inserirInicio(Object o) {
        Celula nova = new Celula(o);
        nova.setProximo(primeiro);
        primeiro = nova;
    }

    /** Método que recebe um objeto para inserir no final da lista encadeada.
     * Após receber o objeto, uma nova célula é criada, assim como um auxiliar,
     * que recebe a referência (do primeiro elemento) da lista. Quando essa
     * referência for vazia, o objeto será inserido no início da lista, que
     * nesse caso, também será o último. Mas se a lista já conter elementos, o 
     * aulixiar que recebe o endereço da lista, a percorre, deixando a referência
     * principal intacta, quando esse auxiliar encontrar um elemento nulo, ele
     * se posiciona naquele lugar e no seu próximo é adicionado nulo.
     * 
     * @param o
     */
    @Override
    public void inserirFinal(Object o) {
        Celula nova = new Celula(o);
        Celula aux = primeiro;
        
        if (primeiro == null) {
            nova.setProximo(primeiro);
            primeiro = nova;
        } else {
            while (aux.getProximo() != null) {
                aux = aux.getProximo();
            }
            aux.setProximo(nova);
        }
    }

    /** Método que remove o primeiro elemento da lista encadeada. O auxiliar 
     * criado recebe a referência da lista, o primeiro que é a referência, passa
     * a apontar para seu próprio campo próximo, logo se torna o segundo elemento,
     * retornando o antigo primeiro que o auxiliar guardava na sua referência.
     * 
     * @return Object
     */
    @Override
    public Object removerInicio() {
        Celula aux = primeiro;
        primeiro = primeiro.getProximo();
        return aux.getObjeto();
    }

    /** Método que remove o último elemento da lista encadeada. Dois auxiliares
     * são criados. Caso a lista encadeada esteja vazia, null é o retorno. Se a
     * lista contiver apenas um elemento, tal elemento é retornado, não sobrará 
     * elementos na lista. Caso a lista tenha mais de um elemento, os auxiliares
     * vão alternandamente percorrendo as células, até achar o elemento que seu
     * campo próximo aponta para null (última célula da lista), feito isso, o
     * auxiliar mais à frente está na última posição e o outro na anterior, este
     * último passa a apontar para nulo em seu campo próximo. A última posição,
     * que já não faz mais parte da lista, é retornada.
     * 
     * @return Object
    */
    @Override
    public Object removerFinal() {
        Celula aux = primeiro;
        Celula aux2 = primeiro;
        
        if (primeiro == null) {
            return null;
        } else if (aux.getProximo() == null) {
            primeiro = null;
            return aux.getObjeto();
        } else {
            while (aux.getProximo() != null) {
                aux2 = aux;
                aux = aux.getProximo();
            }
            aux2.setProximo(null);
            return aux.getObjeto();
        }
    }

    /** Método que recupera um elemento de determinada posição da lista encadeada,
     * o método recebe um número que faz com que um aulixiar avance até encontrar
     * tal posição, o objeto desejado é retornado. Caso a posiçao não exista, o
     * valor nulo é retornado.
     * 
     * @param index
     * @return Object
     */
    @Override
    public Object recuperar(int index) {
        Celula aux = primeiro;
        
        if (index >= 0 && index < obterTamanho()) {
            for (int i = 0; i < index; i++) {
                aux = aux.getProximo();
            }
            return aux.getObjeto();
        }
        return null;
    }

    /** Método que cria um objeto do tipo Iterador, seu construtor recebe como
     * parâmetro o primeiro elemento da lista encadeada, tal iterador é retornado.
     * 
     * @return iter
     */
    @Override
    public Iterador iterador() {
        Iterador iter = new IteradorC(primeiro);
        return iter;
    }
    
    /** Método que remove um elemento de qualquer posição da lista encadeada, o
     * auxiliar criado recebe a referência da lista, ela é percorrida até que se
     * ache o elemento desejado, o anterior à ele passa a apontar para o seu próximo,
     * ele deixa de fazer parte da lista e é retornado.
     * 
     * @param o
     * @return Object
     */
    @Override
    public Object removerPosicao(Object o) {
        if (primeiro.getObjeto().equals(o)){            
            this.removerInicio();            
        } else {
            Celula aux = primeiro.getProximo();
            Celula aux2 = primeiro;
           
            while (!aux.getObjeto().equals(o) && aux != null) {               
                aux2 = aux;
                aux = aux.getProximo();
            }           
            aux2.setProximo(aux.getProximo());
            return aux;
        }
        return null;
    }
}