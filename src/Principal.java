import model.Movie;
import model.Series;
import model.Title;

import java.util.*;

public class Principal {
    public void showMenu() {
        int option = 0;
        List<Title> titles = new ArrayList<>();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("WELCOME TO SCREENMATCH");
        while (option != 9) {

            String menu = """                    
                    MENU
                    1. Register a new movie.
                    2. Register a new series.
                    3. Binge-watch Calculator.
                    9. Exit Screenmatch.
                    """;
            System.out.println(menu);
            System.out.print("Please select an option by typing-in the number: ");
            try {
                option = keyboard.nextInt();
            } catch (InputMismatchException e) {
                keyboard.nextLine();
            }
            keyboard.nextLine();


            switch (option) {
                case 1 -> registerMovie(keyboard, titles);
                case 2 -> registerSeries(keyboard, titles);
                case 3 -> calculateBingeWatchTime(keyboard, titles);
                case 9 -> System.out.println("THANK YOU FOR USING SCREENWATCH!");
                default -> System.out.println("Invalid option.\n");
            }
        }
    }

    private void calculateBingeWatchTime(Scanner keyboard, List<Title> titles) {
        int numeral = -1;
        double hoursPerDay = 0;
        double totalBingeWatchTimeInMinutes = 0;
        long totalHours;
        List<Title> bingeWatchList = new ArrayList<>();
        String message;

        while (numeral != 0) {
            System.out.println("\nTITLES");
            displayTitles(titles);
            message = """
                    Please select the movie/series you want to add to your binge-watch list,
                    using its corresponding numeral in the list above:\s""";
            numeral = assignMatchingKeyboardInput(message, keyboard);

            try {
                Title selectedTitle = titles.get(numeral - 1);
                addTitleToCollection(selectedTitle, bingeWatchList);
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("Your selection is not in our TITLES list, please try again");
                keyboard.nextLine();
                continue;
            }

            System.out.println("YOUR BINGE-WATCH LIST");
            displayTitles(bingeWatchList);

            message = """                    
                    If you are done adding items to your binge-watch list, please input 0.
                    Otherwise, press any other number:\s""";
            numeral = assignMatchingKeyboardInput(message, keyboard);
        }

        while (hoursPerDay < 1) {
            message = "How many hours a day do you binge-watch? (minimum 1 hour): ";
            hoursPerDay = assignMatchingKeyboardInput(message, keyboard);
            System.out.println();
        }

        for (Title title : bingeWatchList) {
            totalBingeWatchTimeInMinutes += title.getLengthInMinutes();
        }
        totalHours = Math.round(totalBingeWatchTimeInMinutes / 60);
        System.out.println("YOUR BINGE-WATCH LIST");
        displayTitles(bingeWatchList);
        System.out.printf("""
                To binge-watch a total of %d hours of content,
                watching %.0f hours at day,
                it will take you %d day(s).%n%n""", totalHours, hoursPerDay, Math.round(totalHours / hoursPerDay));
    }

    private void displayTitles(List<Title> titles) {
        try {
            for (Title title : titles) {
                System.out.printf("%d. %s%n", titles.indexOf(title) + 1, title);
            }
        } catch (NullPointerException nullPointerException) {
            System.out.println(nullPointerException.getMessage());
        } finally {
            System.out.println();
        }
    }

    private void registerSeries(Scanner keyboard, List<Title> titles) {
        String name = insertName(keyboard);
        int releaseDate = insertReleaseDate(name, keyboard);
        int seasons = -1;
        int episodesPerSeason = -1;
        int lengthOfEpisodesInMinutes = -1;
        String message = String.format("Please input how many seasons %s has: ", name);

        while (seasons == -1) {
            seasons = assignMatchingKeyboardInput(message, keyboard);
        }
        keyboard.nextLine();

        message = String.format("Please input how many episodes per season does %s has: ", name);
        while (episodesPerSeason == -1) {
            episodesPerSeason = assignMatchingKeyboardInput(message, keyboard);
        }
        keyboard.nextLine();

        message = String.format("Please input how long each episode of %s lasts (in minutes): ", name);
        while (lengthOfEpisodesInMinutes == -1) {
            lengthOfEpisodesInMinutes = assignMatchingKeyboardInput(message, keyboard);
        }
        keyboard.nextLine();

        Series series = new Series(name,
                releaseDate,
                seasons,
                episodesPerSeason,
                lengthOfEpisodesInMinutes);

        addTitleToCollection(series, titles);
        series.showDataSheet();
    }

    private void registerMovie(Scanner keyboard, List<Title> titles) {
        String name = insertName(keyboard);
        String message = String.format("Please input %s's length in minutes: ", name);
        int releaseDate = insertReleaseDate(name, keyboard);
        int lengthInMinutes = -1;

        while (lengthInMinutes == -1) {
            lengthInMinutes = assignMatchingKeyboardInput(message, keyboard);
        }

        Movie movie = new Movie(name, releaseDate, lengthInMinutes);
        movie.showDataSheet();
        addTitleToCollection(movie, titles);
    }

    private void addTitleToCollection(Title title, Collection<Title> titles) {
        try {
            if (!titles.contains(title)) {
                titles.add(title);
                System.out.printf("%n%s was added to this list%n%n", title);
            } else System.out.printf("%n%s is already in this list%n%n", title);
        } catch (NullPointerException nullPointerException) {
            System.out.println(nullPointerException.getMessage());
        }
    }

    private int insertReleaseDate(String name, Scanner keyboard) {
        int releaseDate = -1;
        String message = String.format("Please input %s's release date: ", name);
        while (releaseDate == -1) {
            releaseDate = assignMatchingKeyboardInput(message, keyboard);
        }
        return releaseDate;
    }

    private int assignMatchingKeyboardInput(String message, Scanner keyboard) {
        try {
            System.out.printf(message);
            return keyboard.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid Option, please try again");
            keyboard.nextLine();
        }
        return assignMatchingKeyboardInput(message, keyboard);
    }

    private String insertName(Scanner keyboard) {
        System.out.print("Please insert title's name: ");
        return keyboard.nextLine();
    }
}
