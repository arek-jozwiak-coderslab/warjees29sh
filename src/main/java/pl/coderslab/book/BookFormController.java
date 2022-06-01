package pl.coderslab.book;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/book-form")
public class BookFormController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;

    public BookFormController(BookDao bookDao, PublisherDao publisherDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
    }

    @GetMapping("/add")
    public String add(Model model) {
        Book book = new Book();
        model.addAttribute("publishers", publisherDao.findAll());
        model.addAttribute("book", book);
        return "book/add";
    }

    @PostMapping("/add")
    public String save(@Valid Book book, BindingResult result) {
        if(result.hasErrors()){
            return "book/add";
        }
        bookDao.save(book);
        return "redirect:/book-form/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("books", bookDao.getList());
        return "book/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        bookDao.delete(bookDao.findById(id));
        return "redirect:/book-form/list";
    }

}
