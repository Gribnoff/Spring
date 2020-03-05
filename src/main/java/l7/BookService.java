package l7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private BookRepository bookRepository;

    @SuppressWarnings("unused")
    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    List<Book> getBookList() {
        return (List<Book>) bookRepository.findAll();
    }

    void addBook(Book book) {
        bookRepository.save(book);
    }
}
