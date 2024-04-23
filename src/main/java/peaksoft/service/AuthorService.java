package peaksoft.service;

import peaksoft.model.Author;

import java.util.List;

public interface AuthorService {
    //    CRUD
    void createTableAuthor();

    String saveAuthor(Author newAuthor);

    Author findById(Long authorId);

    List<Author> findAllAuthors();

    String updateAuthor(Long authorId, Author newAuthor);

    void deleteAuthor(Long authorId);

    void dropAuthorTable();

    void cleanAuthorTable();

    //    DOP Method
    List<Author> sortByDateOfBirth();
}
