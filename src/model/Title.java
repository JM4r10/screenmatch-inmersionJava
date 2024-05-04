package model;

import java.util.Objects;

public class Title {

    private int releaseDate;
    private int lengthInMinutes;
    private String name;

    public Title() {
    }

    public Title(String name, int releaseDate) {
        this.name = name;
        this.releaseDate = releaseDate;
    }

    public void showDataSheet() {
        System.out.println();
        System.out.println("***DATA SHEET***");
        System.out.printf("Title: %s%n", name);
//        System.out.printf("Synopsis: %s%n", synopsis);
        System.out.printf("Release Date: %d%n", releaseDate);
//        System.out.printf("Included in Basic Plan: %b%n", includedInBasicPlan);
//        System.out.println(releaseDate < 1995 ? "Category: Retro Movie" : "Category: Modern Movie");
        System.out.printf("Length: %d minutes%n", getLengthInMinutes());
        System.out.println();
    }

    public String getName() {
        return name;
    }

    public int getLengthInMinutes() {
        return lengthInMinutes;
    }

    public void setLengthInMinutes(int lengthInMinutes) {
        this.lengthInMinutes = lengthInMinutes;
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Title)) return false;
        return this.getName().equals(((Title) obj).getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
