package peaksoft.service;

import peaksoft.model.Book;

public interface BookService {

    void  createTableBook();
    String saveBook(Book book);
}
