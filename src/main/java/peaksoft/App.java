package peaksoft;

import peaksoft.model.Author;
import peaksoft.model.Book;
import peaksoft.service.AuthorService;
import peaksoft.service.BookService;
import peaksoft.service.serviceimpl.AuthorServiceImpl;
import peaksoft.service.serviceimpl.BookServiceImpl;

import java.time.LocalDate;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        AuthorService authorService = new AuthorServiceImpl();
//        System.out.println("Create table :");
//        authorService.createTableAuthor();
//        System.out.println("Save author:");
//        System.out.println(authorService.saveAuthor(new Author("Bektur", "Temirbekov", "bektur@gmail.com", "KG", LocalDate.of(2004, 03, 04))));

//        System.out.println("Find By id : ");
//        System.out.println(authorService.findById(3L));
//        System.out.println("Find all authors : ");
//        System.out.println(authorService.findAllAuthors());
//        System.out.println("Delete author by id : ");
//        authorService.deleteAuthor(4L);
//        System.out.println("Sorted authors by date of birth");
//        System.out.println(authorService.sortByDateOfBirth());


        BookService bookService = new BookServiceImpl();
        System.out.println("Create table book");
        bookService.createTableBook();

    }
}
