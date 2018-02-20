package br.uefs.ecomp.spvrio.model;


/**
 * Classe Candidato, permite criar candidatos de acordo com seus atributos
 * (características do objeto), um candidato tem como atributos seu nome, um id 
 * (que é gerado em ordem de criação por um contador) e o endereço.
 * 
 * @author Camille Jesus
 */
public class Candidato {
    
    private final int id, numero, cep;
    private final String nome, nacionalidade, opcao1, opcao2;
    private final String pais, estado, bairro, rua;
    private boolean convocado, reserva;
    private static int auxId = 0;   //Será incrementada e associada ao id.
    
    /**Construtor da classe, recebe como parâmetro as informações para inicializar
     * os atributos e instanciar um novo objeto.
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
     * @param opcao2
     */
    public Candidato(String nome, String nacionalidade, String pais, String estado, String bairro, String rua, int numero, int cep, String opcao1, String opcao2) {
        this.id = ++auxId;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.pais = pais;
        this.estado = estado;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.opcao1 = opcao1;
        this.opcao2 = opcao2;
    }
    
    /* Métodos que permitem verificar o estado dos atributos (retornando-o):
     */
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public String getPais() {
        return pais;
    }

    public String getEstado() {
        return estado;
    }

    public String getBairro() {
        return bairro;
    }

    public String getRua() {
        return rua;
    }

    public int getNumero() {
        return numero;
    }

    public int getCep() {
       return cep;
    }
    
    public String getOpcao1() {
        return opcao1;
    }

    public String getOpcao2() {
        return opcao2;
    }
    
    public int getAuxId() {
        return auxId;
    }
    
    public boolean getConvocado() {
        return convocado;
    }

    public boolean getReserva() {
        return reserva;
    }

    /* Método que recebe um booleano (true para convocado e false para não) e 
     * guarda no atributo da classe.
     */
    public void setConvocado(boolean convocado) {
        this.convocado = convocado;
    }
    
    public void setReserva(boolean reserva) {
        this.reserva = reserva;
    }
    
    /** Método que dá uma representação em String do objeto.
     * 
     * @return String 
     */
    public String toString() {
        return "Candidato - " + "Id: " + id + ", Nome: " + nome + ", Nacionalidade: "
                + nacionalidade + ", País: " + pais + ", Estado: " + estado + ", "
              + "Bairro: " + bairro + ", Rua: " + rua + ", Número: " + numero + ","
            + " CEP: " + cep + ", 1ª Opção: " + opcao1 + ", 2ª Opção: " + opcao2;
    }

    /** Método que verifica se dois candidatos são iguais retornando um valor booleano,
     * onde true significa que o objeto é igual e false que o objeto é diferente.
     * 
     * @param o
     * @return true ou false
     */
    public boolean equals(Object o) {
        
        if(o instanceof Candidato) {
            Candidato c = (Candidato) o;
            
            if (nome.equals(c.getNome())) {
                return true;
            }
        }
        return false;
    }    
}