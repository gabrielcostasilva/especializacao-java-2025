package br.edu.utfpr.cp.espjava.crudcidades.visao;

public final class Cidade {
    private final String nome;
    private final String estado;

    public Cidade(final String nome, final String estado) {
        this.nome = nome;
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public String getNome() {
        return nome;
    }
}
