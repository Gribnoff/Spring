package l7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/books")
class BookController {
    private BookService bookService;

    @SuppressWarnings("unused")
    @Autowired
    void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @SuppressWarnings("unused")
    @GetMapping("/catalog")
    public String showCatalog(Model model) {
        model.addAttribute("books", bookService.getBookList());
        return "books-list";
    }

    @SuppressWarnings("unused")
    @GetMapping("/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "add-book-form";
    }

    @PostMapping("/add")
    public String addBook(Book book) {
        bookService.addBook(book);
        return "redirect:/books/catalog";
    }
}
