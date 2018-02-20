package br.uefs.ecomp.spvrio.util;


/**
 * A Classe IteradorC, implementada a partir dos métodos da interface Interador,
 * permite ser utilizada para manipular uma lista encadeada sem fazer algum
 * tipo de alteração, seja elementar ou estrutural.
 * 
 * @author Camille Jesus
 */
public class IteradorC implements Iterador {
    private Celula no;
    
    /** Construtor que recebe o primeiro elemento da lista e faz uma cópia num
     * objeto de mesmo tipo.
     * 
     * @param primeiro
     */
    public IteradorC(Celula primeiro) {
        no = primeiro;
    }
            
    /** Método que verifica se há um objeto no campo próximo da célula atual,
     * retornando false para vazia e true caso haja elementos nela.
     * 
     * @return true ou false
     */
    @Override
    public boolean temProximo() {
        return (no != null);
    }

    /** Método que retorna o objeto desejado, após verificação de existência de
     * um próximo elemento (método anterior), antes do retorno o auxiliar avança
     * uma posição, e assim sucessivamente, até não haver próximo para retornar.
     * 
     * @return Object
     */
    @Override
    public Object obterProximo() {
        Object obj = no.getObjeto();
        no = no.getProximo();
        return obj;
    }    
}