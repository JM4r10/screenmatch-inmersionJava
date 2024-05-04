package model;

public class Series extends Title{
    private int seasons;
    private int episodesPerSeason;
    private int lengthOfEpisodesInMinutes;

    public Series(String name, int releaseDate, int seasons, int episodesPerSeason, int lengthOfEpisodesInMinutes) {
        super(name, releaseDate);
        this.seasons = seasons;
        this.episodesPerSeason = episodesPerSeason;
        this.lengthOfEpisodesInMinutes = lengthOfEpisodesInMinutes;
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public int getEpisodesPerSeason() {
        return episodesPerSeason;
    }

    public void setEpisodesPerSeason(int episodesPerSeason) {
        this.episodesPerSeason = episodesPerSeason;
    }
    public int getLengthOfEpisodesInMinutes() {
        return lengthOfEpisodesInMinutes;
    }

    public void setLengthOfEpisodesInMinutes(int lengthOfEpisodesInMinutes) {
        this.lengthOfEpisodesInMinutes = lengthOfEpisodesInMinutes;
    }

    @Override
    public int getLengthInMinutes() {
        return lengthOfEpisodesInMinutes * episodesPerSeason * seasons;
    }
}
