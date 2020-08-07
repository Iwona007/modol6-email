package iwona.pl.modol6email.model;

import java.util.Objects;

public class Video {

    private Long id;
    private String title;
    private int yearOfProduction;

    public Video(Long id, String title,int yearOfProduction) {
        this.id = id;
        this.title = title;
        this.yearOfProduction = yearOfProduction;
    }
    public Video( String title, int yearOfProduction) {
        this.title = title;
        this.yearOfProduction = yearOfProduction;
    }
    public Video() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString(){
        return "Video {" +
                "id= " + id +
                 ", title= " + title + "\'" +
                ", year Of Production = " + yearOfProduction + "\'" +
                "}";
    }
    @Override
    public boolean equals(Object obj){
        if(this == obj){
         return true;
        }
        if(obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Video video = (Video) obj;
        return Objects.equals(id, video.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}
