package pl.coderslab.book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {

    private final BookDao bookDao;

    public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @RequestMapping("/add")
    public String saveBook(){
        Book book = new Book();
        book.setTitle("Java 2");
        bookDao.save(book);
        return "saved";
    }

    @RequestMapping("/edit")
    public String editBook(){
        Book book = bookDao.findById(1l);
        book.setTitle("Java 22");
        bookDao.save(book);
        return "saved";
    }

    @RequestMapping("/delete")
    public String deleteBook(){
        Book book = bookDao.findById(1l);
        bookDao.delete(book);
        return "saved";
    }

    @RequestMapping("/get")
    public String getBook(){
        Book book = bookDao.findById(1l);
        System.out.println(book.getTitle());
        return "saved";
    }
}
