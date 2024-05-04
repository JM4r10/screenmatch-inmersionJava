package model;

public class Movie extends Title{
    private String director;

    public Movie(String name, int releaseDate, int lengthInMinutes) {
        super(name, releaseDate);
        this.setLengthInMinutes(lengthInMinutes);
    }
}
