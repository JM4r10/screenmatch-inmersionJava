package model;

public class Movie extends Title{
    private String director;

    public Movie() {
    }

    public Movie(String name, int releaseDate, int lengthInMinutes) {
        super(name, releaseDate);
        this.setLengthInMinutes(lengthInMinutes);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }


}
