package peaksoft.dao.daoImpl;

import peaksoft.config.JdbcConfig;
import peaksoft.dao.AuthorDao;
import peaksoft.model.Author;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorDaoImpl implements AuthorDao {

    private final Connection connection = JdbcConfig.getConnection();
    @Override
    public void createTableAuthor() {
        String sql = """
                create table if not exists authors(
                id serial primary key,
                first_name varchar,
                last_name varchar,
                email varchar,
                country varchar,
                date_of_birth date);
                """;
        try(Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String saveAuthor(Author newAuthor) {
        String sql = """
                insert into authors (first_name, last_name, email,country ,date_of_birth)
                values(?,?,?,?,?);
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,newAuthor.getFirstName());
            preparedStatement.setString(2, newAuthor.getLastName());
            preparedStatement.setString(3, newAuthor.getEmail());
            preparedStatement.setString(4,newAuthor.getCountry());
            preparedStatement.setDate(5, Date.valueOf(newAuthor.getDateOfBirth()));
            preparedStatement.executeUpdate();
            return "Success";
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return "failed";
    }

    @Override
    public Author findById(Long authorId) {
        Author author = new Author();
        String sql = """
                select * from authors where id = ?
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1,authorId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                author.setId(resultSet.getLong("id"));
                author.setFirstName(resultSet.getString("first_name"));
                author.setLastName(resultSet.getString("last_name"));
                author.setEmail(resultSet.getString("email"));
                author.setCountry(resultSet.getString("country"));
                author.setDateOfBirth(resultSet.getDate("date_of_birth").toLocalDate());
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return author;
    }

    @Override
    public List<Author> findAllAuthors() {
        List<Author> authors = new ArrayList<>();
        String sql = " select * from authors";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Author author = new Author();
                author.setId(resultSet.getLong("id"));
                author.setFirstName(resultSet.getString("first_name"));
                author.setLastName(resultSet.getString("last_name"));
                author.setEmail(resultSet.getString("email"));
                author.setCountry(resultSet.getString("country"));
                author.setDateOfBirth(resultSet.getDate("date_of_birth").toLocalDate());
                authors.add(author);
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return authors;
    }

    @Override
    public String updateAuthor(Long authorId, Author newAuthor) {
        return null;
    }

    @Override
    public void deleteAuthor(Long authorId) {
        String sql = "delete from authors where id =?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1,authorId);
            int deleteAuthor = preparedStatement.executeUpdate();
            if (deleteAuthor>0){
                System.out.println("Successfully deleted");
            }else System.out.println("Author id not found!");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void dropAuthorTable() {
      String sql = "drop table if exists authors";
      try(Statement statement = connection.createStatement()){
          statement.executeUpdate(sql);
          System.out.println("Table successfully deleted!");

      }catch (SQLException e){
          System.out.println(e.getMessage());
      }
    }

    @Override
    public void cleanAuthorTable() {
      String sql ="truncate table authors";
      try(Statement statement = connection.createStatement()){
          statement.executeUpdate(sql);
          System.out.println("Table successfully cleaned!");
      }catch (SQLException e){
          System.out.println(e.getMessage());
      }
    }

    @Override
    public List<Author> sortByDateOfBirth() {
        List<Author> authors = new ArrayList<>();
        String sql = " select * from authors order by date_of_birth desc";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Author author = new Author();
                author.setId(resultSet.getLong("id"));
                author.setFirstName(resultSet.getString("first_name"));
                author.setLastName(resultSet.getString("last_name"));
                author.setEmail(resultSet.getString("email"));
                author.setCountry(resultSet.getString("country"));
                author.setDateOfBirth(resultSet.getDate("date_of_birth").toLocalDate());
                authors.add(author);
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return authors;
    }
}
