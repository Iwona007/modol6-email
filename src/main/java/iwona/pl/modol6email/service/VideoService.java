package iwona.pl.modol6email.service;

import iwona.pl.modol6email.model.Video;
import java.util.LinkedHashSet;

public interface VideoService {

    LinkedHashSet<Video> getAll();

    boolean addVideo(Video video);

   long addNextId();
}
