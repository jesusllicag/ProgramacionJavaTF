package app.models;

import java.util.List;

public class MenuLabel {
    private final String titulo;
    private final List<String> opciones;

    protected MenuLabel (String titulo, List<String> opciones) {
        this.titulo = titulo;
        this.opciones = opciones;
    }

    public String getTitulo() {
        return titulo;
    }

    public List<String> getOpciones() {
        return opciones;
    }

    public int getCantidadOpciones() {
        return opciones.size();
    }

}
