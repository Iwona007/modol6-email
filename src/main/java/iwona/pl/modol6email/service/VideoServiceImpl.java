package iwona.pl.modol6email.service;

import iwona.pl.modol6email.email.EmailSender;
import iwona.pl.modol6email.model.Video;
import java.util.LinkedHashSet;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl implements VideoService {

    private EmailSender emailSender;
    private LinkedHashSet<Video> videos;

    public VideoServiceImpl(EmailSender emailSender) {
        this.emailSender = emailSender;
        this.videos = new LinkedHashSet<>();
        list();
    }

    public LinkedHashSet<Video> list(){
        videos.add(new Video(1L, "No time to Die", 2020));
        videos.add(new Video(2L, "Once Upon a Time in Hollywood", 2019));
        videos.add(new Video(3L, "Gemini Man", 2019));
        videos.add(new Video(4L, "I Am Ali", 2014));
        videos.add(new Video(5L, "Joy", 2015));
        return videos;
    }

    @Override
    public LinkedHashSet<Video> getAll() {
        return videos;
    }

    @Override
    public boolean addVideo(Video video) {
        boolean add = videos.add(video);
        if (add) {
            emailSender.sendEmail("test222test222mail@gmail.com", "Video List",
                    "Your movie has been added to Video list", true);
            return true;
        }
        return false;
    }

    @Override
    public long addNextId() {
        return videos.size() + 1;
    }
}
