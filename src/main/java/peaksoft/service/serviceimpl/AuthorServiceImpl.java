package peaksoft.service.serviceimpl;

import peaksoft.dao.AuthorDao;
import peaksoft.dao.daoImpl.AuthorDaoImpl;
import peaksoft.model.Author;
import peaksoft.service.AuthorService;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {
    AuthorDao authorDao = new AuthorDaoImpl();
    @Override
    public void createTableAuthor() {
        authorDao.createTableAuthor();
    }

    @Override
    public String saveAuthor(Author newAuthor) {
        return authorDao.saveAuthor(newAuthor);
    }

    @Override
    public Author findById(Long authorId) {
        return authorDao.findById(authorId);
    }

    @Override
    public List<Author> findAllAuthors() {
        return authorDao.findAllAuthors();
    }

    @Override
    public String updateAuthor(Long authorId, Author newAuthor) {
        return null;
    }

    @Override
    public void deleteAuthor(Long authorId) {
       authorDao.deleteAuthor(authorId);
    }

    @Override
    public void dropAuthorTable() {

    }

    @Override
    public void cleanAuthorTable() {

    }

    @Override
    public List<Author> sortByDateOfBirth() {
        return authorDao.sortByDateOfBirth();
    }
}
