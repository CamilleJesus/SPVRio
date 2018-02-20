package br.uefs.ecomp.spvrio.util;


public interface ILista {

    public boolean estaVazia();

    public int obterTamanho();

    public void inserirInicio(Object o);

    public void inserirFinal(Object o);

    public Object removerInicio();

    public Object removerFinal();

    public Object recuperar(int index);

    public Iterador iterador();
    
    //Método extra, para permitir desistência de convocado:
    public Object removerPosicao(Object o);
}