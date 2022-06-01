package pl.coderslab.student;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
@Slf4j
public class StudentController {

    private final Validator validator;

    public StudentController(Validator validator) {
        this.validator = validator;
    }

    @RequestMapping("/validate")
    @ResponseBody
    public String testValidate() {
        Student student = new Student();

        Set<ConstraintViolation<Student>> constraintViolations = validator.validate(student);

        if (constraintViolations.isEmpty()) {
            //save obj
            int a =12;
        } else {
            for (ConstraintViolation<Student> constraintViolation : constraintViolations) {
                log.debug("path {}", constraintViolation.getPropertyPath());
                log.debug("getMessage {}", constraintViolation.getMessage());
            }

        }

        return "ok";
    }

}
