package app.contracts.dtos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuLabel {

    private final String titulo;
    private final List<String> opciones;


    public MenuLabel (String titulo, String ...opciones) {
        this.titulo = titulo;
        this.opciones = Arrays.asList(opciones);
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
