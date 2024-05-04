package model;

public class Series extends Title {
    private int seasons;
    private int episodesPerSeason;
    private int lengthOfEpisodesInMinutes;

    public Series(String name, int releaseDate, int seasons, int episodesPerSeason, int lengthOfEpisodesInMinutes) {
        super(name, releaseDate);
        this.seasons = seasons;
        this.episodesPerSeason = episodesPerSeason;
        this.lengthOfEpisodesInMinutes = lengthOfEpisodesInMinutes;
    }

    @Override
    public int getLengthInMinutes() {
        return lengthOfEpisodesInMinutes * episodesPerSeason * seasons;
    }
}
