package database;

import app.config.DatabaseTable;
import app.contracts.models.Book;

public class Books extends DatabaseTable<Book> {

    @Override
    protected Book model() {
        return new Book();
    }

    @Override
    protected void seed() {
        this.create("0-1234-1111-5", "Travesuras de la Niña Mala", "Mario Vargas Llosa", "2006");
        this.create("0-1234-2222-8", "Ojos de Perro Azul", "Gabriel García Márquez", "1972");
        this.create("0-1234-3333-1", "Rayuela", "Julio Cortázar", "1963");
        this.create("0-1234-4444-1", "Pedro Páramo", "Juan Rulfo", "1955");
        this.create("0-1234-5555-1", "El Túnel", "Ernesto Sabato", "1948");
        this.create("0-1234-6666-1", "Don Quijote de la Mancha", "Miguel de Cervantes", "1605");
        this.create("0-1234-7777-3", "El Hacedor", "Jorge Luis Borges", "1960");
        this.create("0-1234-8888-1", "La Sombra del Viento", "Carlos Ruiz Zafón", "2001");
    }
}
