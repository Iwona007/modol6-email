package iwona.pl.modol6email.email;

public interface EmailSender {

    void sendEmail(String to, String subject, String content, boolean isHtmlContent);
}
