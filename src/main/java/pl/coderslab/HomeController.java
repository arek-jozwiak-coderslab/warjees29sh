package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.book.AuthorDao;
import pl.coderslab.book.Book;
import pl.coderslab.book.BookDao;

@Controller
public class HomeController {

    private final BookDao bookDao;
    private final AuthorDao authorDao;

    public HomeController(BookDao bookDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.authorDao = authorDao;
    }


    @ResponseBody
    @RequestMapping("/")
    public String hello() {

        return "start";
    }

    @ResponseBody
    @RequestMapping("/hhhaaa")
    public String hhh() {
        System.out.println("12312312321");
        Book book = new Book();
        book.setTitle("Thinkink in Java");
        bookDao.save(book);
        return "start";
    }

}
