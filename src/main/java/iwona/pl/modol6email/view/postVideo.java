package iwona.pl.modol6email.view;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import iwona.pl.modol6email.controller.VideoController;
import iwona.pl.modol6email.model.Video;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;

@Route("addVideo")
public class postVideo extends VerticalLayout {

    private VideoController videoController;

    @Autowired
    public postVideo(VideoController videoController) {
        this.videoController = videoController;
        Grid<Video> grid = new Grid<>(Video.class);
        TextField textFieldTitle = new TextField("Title");
        TextField textFieldYear = new TextField("Year of production");
        Button buttonAdd = new Button("Submmit");

        buttonAdd.addClickListener(clickEvent -> {
            int status = videoController.addVideo(new Video(videoController.addNextId(),
                    textFieldTitle.getValue(), Integer.parseInt(textFieldYear.getValue())
            )).getStatusCodeValue();

            if (status == 200) {
                Notification.show(
                        "Car added!", 3000,
                        Notification.Position.TOP_CENTER);
            } else {
                Notification.show(
                        "Sorry. Video cannot be added", 3000,
                        Notification.Position.TOP_CENTER);
            }
            grid.getDataProvider().refreshAll();
        });

        add(textFieldTitle, textFieldYear);
        add(buttonAdd);
    }
}
