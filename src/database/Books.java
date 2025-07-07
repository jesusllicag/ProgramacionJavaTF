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
        this.create("0-1234-1111-0", "La Ciudad y los Perros", "Mario Vargas Llosa", "1963");
        this.create("0-1234-1111-1", "Conversación en La Catedral", "Mario Vargas Llosa", "1969");
        this.create("0-1234-1111-2", "Pantaleón y las Visitadoras", "Mario Vargas Llosa", "1973");
        this.create("0-1234-1111-3", "Lituma en los Andes", "Mario Vargas Llosa", "1993");
        this.create("0-1234-1111-4", "El Héroe Discreto", "Mario Vargas Llosa", "2013");
        this.create("0-1234-1111-5", "Travesuras de la Niña Mala", "Mario Vargas Llosa", "2006");
        this.create("0-1234-1111-6", "La Fiesta del Chivo", "Mario Vargas Llosa", "2000");
        this.create("0-1234-1111-7", "La Tía Julia y el Escribidor", "Mario Vargas Llosa", "1977");
        this.create("0-1234-1111-8", "¿Quién mató a Palomino Molero?", "Mario Vargas Llosa", "1986");
        this.create("0-1234-1111-9", "Los Cachorros", "Mario Vargas Llosa", "1967");

        this.create("0-1234-2222-1", "Cien Años de Soledad", "Gabriel García Márquez", "1967");
        this.create("0-1234-2222-2", "El Amor en los Tiempos del Cólera", "Gabriel García Márquez", "1985");
        this.create("0-1234-2222-3", "Crónica de una Muerte Anunciada", "Gabriel García Márquez", "1981");
        this.create("0-1234-2222-4", "El General en su Laberinto", "Gabriel García Márquez", "1989");
        this.create("0-1234-2222-5", "La Hojarasca", "Gabriel García Márquez", "1955");
        this.create("0-1234-2222-6", "Del Amor y Otros Demonios", "Gabriel García Márquez", "1994");
        this.create("0-1234-2222-7", "Vivir para Contarla", "Gabriel García Márquez", "2002");
        this.create("0-1234-2222-8", "Ojos de Perro Azul", "Gabriel García Márquez", "1972");
        this.create("0-1234-2222-9", "Doce Cuentos Peregrinos", "Gabriel García Márquez", "1992");
        this.create("0-1234-2222-0", "Memoria de mis Putas Tristes", "Gabriel García Márquez", "2004");

        this.create("0-1234-3333-1", "Rayuela", "Julio Cortázar", "1963");
        this.create("0-1234-3333-2", "Final del Juego", "Julio Cortázar", "1956");
        this.create("0-1234-3333-3", "Bestiario", "Julio Cortázar", "1951");
        this.create("0-1234-3333-4", "Todos los fuegos el fuego", "Julio Cortázar", "1966");
        this.create("0-1234-3333-5", "62 Modelo para Armar", "Julio Cortázar", "1968");
        this.create("0-1234-3333-6", "Un Tal Lucas", "Julio Cortázar", "1979");
        this.create("0-1234-3333-7", "Queremos Tanto a Glenda", "Julio Cortázar", "1980");
        this.create("0-1234-3333-8", "Historias de Cronopios y de Famas", "Julio Cortázar", "1962");
        this.create("0-1234-3333-9", "La vuelta al día en ochenta mundos", "Julio Cortázar", "1967");
        this.create("0-1234-3333-0", "Octaedro", "Julio Cortázar", "1974");

        this.create("0-1234-4444-1", "Pedro Páramo", "Juan Rulfo", "1955");
        this.create("0-1234-4444-2", "El Llano en Llamas", "Juan Rulfo", "1953");
        this.create("0-1234-4444-3", "Cartas a Clara", "Juan Rulfo", "1995");

        this.create("0-1234-5555-1", "El Túnel", "Ernesto Sabato", "1948");
        this.create("0-1234-5555-2", "Sobre Héroes y Tumbas", "Ernesto Sabato", "1961");
        this.create("0-1234-5555-3", "Abaddón el Exterminador", "Ernesto Sabato", "1974");

        this.create("0-1234-6666-1", "Don Quijote de la Mancha", "Miguel de Cervantes", "1605");
        this.create("0-1234-6666-2", "Novelas Ejemplares", "Miguel de Cervantes", "1613");

        this.create("0-1234-7777-1", "Ficciones", "Jorge Luis Borges", "1944");
        this.create("0-1234-7777-2", "El Aleph", "Jorge Luis Borges", "1949");
        this.create("0-1234-7777-3", "El Hacedor", "Jorge Luis Borges", "1960");

        this.create("0-1234-8888-1", "La Sombra del Viento", "Carlos Ruiz Zafón", "2001");
        this.create("0-1234-8888-2", "El Juego del Ángel", "Carlos Ruiz Zafón", "2008");
        this.create("0-1234-8888-3", "El Prisionero del Cielo", "Carlos Ruiz Zafón", "2011");
        this.create("0-1234-8888-4", "El Laberinto de los Espíritus", "Carlos Ruiz Zafón", "2016");
    }
}
