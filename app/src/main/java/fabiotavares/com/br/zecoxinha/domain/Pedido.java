package fabiotavares.com.br.zecoxinha.domain;

import java.io.Serializable;

public class Pedido implements Serializable {


    private String nome = "";
    private Integer hamburguer = 0;
    private Integer sanduiche = 0;
    private Integer cachorroQuente = 0;
    private Integer batataFrita = 0;
    private Integer batataRustica = 0;
    private Integer batataChips = 0;
    private Integer suco = 0;
    private Integer refrigerante = 0;
    private Integer cerveja = 0;
    private boolean dinheiro = false;
    private boolean credito = false;
    private boolean debito = false;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getHamburguer() {
        return hamburguer;
    }

    public void setHamburguer(Integer hamburguer) {
        this.hamburguer = hamburguer;
    }

    public Integer getSanduiche() {
        return sanduiche;
    }

    public void setSanduiche(Integer sanduiche) {
        this.sanduiche = sanduiche;
    }

    public Integer getCachorroQuente() {
        return cachorroQuente;
    }

    public void setCachorroQuente(Integer cachorroQuente) {
        this.cachorroQuente = cachorroQuente;
    }

    public Integer getBatataFrita() {
        return batataFrita;
    }

    public void setBatataFrita(Integer batataFrita) {
        this.batataFrita = batataFrita;
    }

    public Integer getBatataRustica() {
        return batataRustica;
    }

    public void setBatataRustica(Integer batataRustica) {
        this.batataRustica = batataRustica;
    }

    public Integer getBatataChips() {
        return batataChips;
    }

    public void setBatataChips(Integer batataChips) {
        this.batataChips = batataChips;
    }

    public Integer getSuco() {
        return suco;
    }

    public void setSuco(Integer suco) {
        this.suco = suco;
    }

    public Integer getRefrigerante() {
        return refrigerante;
    }

    public void setRefrigerante(Integer refrigerante) {
        this.refrigerante = refrigerante;
    }

    public Integer getCerveja() {
        return cerveja;
    }

    public void setCerveja(Integer cerveja) {
        this.cerveja = cerveja;
    }

    public boolean isDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(boolean dinheiro) {
        this.dinheiro = dinheiro;
    }

    public boolean isCredito() {
        return credito;
    }

    public void setCredito(boolean credito) {
        this.credito = credito;
    }

    public boolean isDebito() {
        return debito;
    }

    public void setDebito(boolean debito) {
        this.debito = debito;
    }

    public Integer getTotal(){
        Integer total = 0;
        total = total + getHamburguer()*15;
        total = total + getSanduiche()*12;
        total = total + getCachorroQuente()*8;
        total = total + getBatataFrita()*6;
        total = total + getBatataRustica()*8;
        total = total + getBatataChips()*5;
        total = total + getRefrigerante()*3;
        total = total + getSuco()*4;
        total = total + getCerveja()*6;

        return total;
    }
}
