package bootstrap;

import domain.Author;
import domain.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import repository.AuthorRepository;
import repository.BookRepository;

public class BootStrapData {
    public static void main(String[] args) {

        ApplicationContext ctx = new GenericXmlApplicationContext("bean.xml");

        AuthorRepository authorRepository = (AuthorRepository) ctx.getBean("authorRepository");
        BookRepository bookRepository = (BookRepository) ctx.getBean("bookRepository");

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
    }
}
