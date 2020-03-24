package iwona.pl.modol6email.controller;

import iwona.pl.modol6email.model.Video;
import iwona.pl.modol6email.service.VideoService;
import java.util.LinkedHashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/videos")
public class VideoController {

    private VideoService videoService;

    @Autowired
    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping("/all")
    public LinkedHashSet<Video> getAll() {
        return videoService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Video> addVideo(@RequestBody Video video) {
        if (videoService.addVideo(video)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public void getById(Long Id) {
        videoService.getById(Id);
    }

    public long addNextId() {
        return videoService.addNextId();
    }
}
