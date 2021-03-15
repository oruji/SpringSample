package bootstrap;

import domain.Author;
import domain.Book;
import domain.Publisher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import repository.AuthorRepository;
import repository.BookRepository;
import repository.PublisherRepository;

public class BootStrapData {
    public static void main(String[] args) {

        System.out.println("Started in Bootstrap");

        ApplicationContext ctx = new GenericXmlApplicationContext("bean.xml");

        AuthorRepository authorRepository = (AuthorRepository) ctx.getBean("authorRepository");
        BookRepository bookRepository = (BookRepository) ctx.getBean("bookRepository");
        PublisherRepository publisherRepository = (PublisherRepository) ctx.getBean("publisherRepository");

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");

        publisherRepository.save(publisher);

        System.out.println("Publisher Count: " + publisherRepository.count());

        Author eric = new Author("Eric", "Evans");
        Book book1 = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(book1);
        book1.getAuthors().add(eric);

        book1.setPublisher(publisher);
        publisher.getBooks().add(book1);

        authorRepository.save(eric);
        bookRepository.save(book1);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book book2 = new Book("J2EE Development without EJB", "3939459459");
        rod.getBooks().add(book2);
        book2.getAuthors().add(rod);

        book2.setPublisher(publisher);
        publisher.getBooks().add(book2);

        authorRepository.save(rod);
        bookRepository.save(book2);
        publisherRepository.save(publisher);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());
    }
}
