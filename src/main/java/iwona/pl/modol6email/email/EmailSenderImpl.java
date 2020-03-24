package iwona.pl.modol6email.email;

import iwona.pl.modol6email.aspect.SendEmail;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderImpl implements EmailSender {

    private JavaMailSender javaMailSender;

    public EmailSenderImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @SendEmail
    public void sendEmail(String to, String subject, String content, boolean isHtmlContent) {
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setTo(to);
            msg.setFrom("Video list <test222test222mail@gmail.com>");
            msg.setSubject(subject);
            msg.setText(content);
            javaMailSender.send(msg);
    }
}

