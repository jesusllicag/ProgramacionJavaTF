package app.contracts.dtos;

import java.util.ArrayList;
import java.util.List;

public class MenuLabel {

    private final String titulo;
    private final List<String> opciones;


    protected MenuLabel (String titulo, List<String> opciones) {
        this.titulo = titulo;
        this.opciones = opciones;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public List<String[]> getOpciones() {
        List<String[]> list = new ArrayList<>();
        for (String option : this.opciones) {
            String[] optionAux = option.split("::");
            list.add(optionAux);
        }
        return list;
    }

}
