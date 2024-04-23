package peaksoft.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {
   private Long id;
   private String name ;
   private String country;
   private int publishedYear;
   private int price;
   private Long authorId;

   public Book(String name, String country, int publishedYear, int price, Long authorId) {
      this.name = name;
      this.country = country;
      this.publishedYear = publishedYear;
      this.price = price;
      this.authorId = authorId;
   }
}
