package iwona.pl.modol6email.controller;

import iwona.pl.modol6email.email.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class emailController {

    private final EmailSender emailSender;

    @Autowired
    public emailController(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    @GetMapping("/sendemail")
    public String sendEmail() {
        emailSender.sendEmail("test222test222mail@gmail.com",
                "Video list",
                "Your video has been added to the list", true);
        return "E-mail sent!";
    }
}

