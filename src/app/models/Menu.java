package app.models;

import java.util.List;

public class Menu {
    private final String titulo;
    private final List<String> opciones;

    public Menu(String titulo, List<String> opciones) {
        this.titulo = titulo;
        this.opciones = opciones;
    }
    public String getTitulo() {
        return titulo;
    }

    public List<String> getOpciones() {
        return opciones;
    }
}
