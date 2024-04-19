package org.iesch.Ej_10;


import com.fasterxml.jackson.annotation.JsonAnyGetter;
import org.iesch.Ej_1y2.Book;
import org.iesch.Ej_7.Author;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.Map;
@XmlRootElement
public class LibraryCatalog {

    public Map<Author, Book> catalog;

    public LibraryCatalog() {
    }
    @JsonAnyGetter
    public Map<String, String> getCatalog() {
        Map<String, String> catalogoModificado = new HashMap<>();
        for (Map.Entry<Author, Book> entrada : catalog.entrySet()) {
            String nombreAutor = entrada.getKey().getName();
            String tituloLibro = entrada.getValue().getTitle();
            catalogoModificado.put(nombreAutor, tituloLibro);

            return catalogoModificado;
        }


        return catalogoModificado;
    }

    public void setCatalog(Map<Author, Book> catalog) {
        this.catalog = catalog;
    }
}
