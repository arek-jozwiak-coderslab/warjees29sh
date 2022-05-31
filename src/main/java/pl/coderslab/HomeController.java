package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.book.AuthorDao;
import pl.coderslab.book.Book;
import pl.coderslab.book.BookDao;
import pl.coderslab.student.Student;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    private final BookDao bookDao;
    private final AuthorDao authorDao;

    public HomeController(BookDao bookDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.authorDao = authorDao;
    }

    @GetMapping("/homee")
    public String hello(Model model) {
        Student student = new Student("arek", "jozwiak");
        model.addAttribute("student", student);
        return "start";
    }

    @PostMapping("/homee")
    public String helloPost(Student student) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return "result";
    }

    @ModelAttribute("languages")
    public List<String> checkOptions() {
        String[] a = new String[] {"pl", "en","gr"};
        return Arrays.asList(a);
    }


    @ResponseBody
    @RequestMapping("/hhhaaa")
    public String hhh(Model model) {

        System.out.println("12312312321");
        Book book = new Book();
        book.setTitle("Thinkink in Java");

        bookDao.save(book);
        return "start";
    }

}
