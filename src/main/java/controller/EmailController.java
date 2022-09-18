package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class EmailController {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static Pattern pattern;
    private Matcher matcher;
    // matcher dung de so sanh voi regex
    // pattern dung de luu tru regex
    // regex dung de kiem tra email
    //

//pattern có những phương thức nào:
//    private int flags;
//    private String pattern;

    public EmailController()
    // ham nay dung de kiem tra email
//
    {
      pattern = Pattern.compile(EMAIL_REGEX);

    }
    private boolean validate(String regex)
    //phương thức matcher có những phương thức nào: //

    {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    @GetMapping("/")
    String getIndex() {
        return "index";
    }

    @PostMapping ("/validate")
    String validateEmail (@RequestParam("email") String email, Model model) {
        boolean isValid = this.validate(email);
        if (!isValid) {
            model.addAttribute("message" ,"Email is invalid-lam gi co email nay");
            return "index";
        }
        model.addAttribute("email", email);
        return "success";
    }

}
