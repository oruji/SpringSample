package controller;

import domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model) {

        System.out.println("I'm Request map books");

        model.addAttribute("books", bookRepository.findAll());

        return "books/list";
    }

//    @RequestMapping("/mybooks")
//    public @ResponseBody
//    List<Book> getBooks(Model model) {
//        System.out.println("I'm Request map books");
//
//        List<Book> result = new ArrayList<>();
//        for (Book str : bookRepository.findAll()) {
//            result.add(str);
//        }
//
//        return result;
//    }
}
