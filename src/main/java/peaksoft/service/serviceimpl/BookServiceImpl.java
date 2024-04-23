package peaksoft.service.serviceimpl;

import peaksoft.dao.BookDao;
import peaksoft.dao.daoImpl.BookDaoImpl;
import peaksoft.model.Book;
import peaksoft.service.BookService;

public class BookServiceImpl implements BookService {
    BookDao bookDao = new BookDaoImpl();


    @Override
    public void createTableBook() {
      bookDao.createTableBook();
    }

    @Override
    public String saveBook(Book book) {
        return null;
    }
}
