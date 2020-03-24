package iwona.pl.modol6email.view;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import iwona.pl.modol6email.controller.VideoController;
import iwona.pl.modol6email.model.Video;
import org.springframework.beans.factory.annotation.Autowired;

@Route("allVideo")
public class allVideos extends HorizontalLayout {

    private VideoController videoController;

    @Autowired
    public allVideos(VideoController videoController) {
        this.videoController = videoController;
        Grid<Video> grid = new Grid<>(Video.class);
        grid.setItems(videoController.getAll());
        add(grid);
    }
}

