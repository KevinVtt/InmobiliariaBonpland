package com.project.imuebles.bondpland.inmobiliaria_bonpland.models.enumerator;

public enum Estado {
    DISPONIBLE(1),
    RESERVADO(2),
    VENDIDO(3),
    ALQUILA(4);

    private final int codigo;

    Estado(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
}