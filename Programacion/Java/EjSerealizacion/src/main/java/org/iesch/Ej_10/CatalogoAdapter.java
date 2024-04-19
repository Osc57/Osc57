package org.iesch.Ej_10;

import org.iesch.Ej_5.Book;
import org.iesch.Ej_7.Author;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.Map;

public class CatalogoAdapter extends XmlAdapter<CatalogoAdapter, AdatedMap, Map<Author, Book>> {

    @Override
    public AdatedMap unmarshal(CatalogoAdapter catalogoAdapter) throws Exception {
        return null;
    }

    @Override
    public CatalogoAdapter marshal(AdatedMap adatedMap) throws Exception {
        return null;
    }
}
