package peaksoft.dao.daoImpl;

import peaksoft.config.JdbcConfig;
import peaksoft.dao.BookDao;
import peaksoft.model.Book;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class BookDaoImpl implements BookDao {
    private final Connection connection = JdbcConfig.getConnection();
    @Override
    public void createTableBook() {
        String sql = """
                create table if not exists books(
                id serial primary key,
                name varchar,
                country varchar,
                published_year int ,
                price int,
                author_id int references authors(id));
                """;
        try(Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
            System.out.println("Success");

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String saveBook(Book book) {
        return null;
    }

    @Override
    public List<Book> getAllBookByAuthorID(Long authorId) {
        return null;
    }

    @Override
    public List<Book> sortedBookByPrice() {
        return null;
    }

    @Override
    public void deleteBooksFromAuthor(Long authorId) {

    }
}
