package pl.coderslab.book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class AuthorController {

    @ResponseBody
    @RequestMapping("/author/start")
    public String hello() {
        Book book = new Book();
        book.setTitle("Thinkink in Java");
        book.setId(1l);

        return "start";
    }
}
