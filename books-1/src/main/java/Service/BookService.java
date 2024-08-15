package Service;

import java.awt.print.Book;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Repository.BookRepository;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    
    public List<Book> findByTitleContaining(String title) {
        return bookRepository.findByTitleContaining(title);
    }
    
    public List<Book> findByAuthorContaining(String author) {
        return bookRepository.findByAuthorContaining(author);
    }
    
    public Book save(Book book) {
        return bookRepository.save(book);
    }

	public Object findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}

