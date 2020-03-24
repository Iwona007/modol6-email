package iwona.pl.modol6email.aspect;


import iwona.pl.modol6email.email.EmailSender;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class EmailAspect {

    private EmailSender emailSender;
    @Autowired
    public EmailAspect(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    @After("@annotation(SendEmail)")
    private void aroundSenEmail() {
        System.out.println("wywołanie aspektu after");
    }
}

