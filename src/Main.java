import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int releaseDate = 2007;
        int counter = 0;
        double rating = 0;
        boolean includedInBasicPlan = true;
        double users = 3;

        String name = "There will be blood";
        String synopsis = """
                There Will Be Blood is a 2007 American epic period drama film written and directed by Paul Thomas Anderson, loosely based on the 1927 novel Oil! by Upton Sinclair.""";
        System.out.println("Bienvenidos a la inmersión en Java");
        System.out.printf("Title: %s\n", name);
        System.out.printf("Synopsis: %s%n", synopsis);
        System.out.printf("Release Date: %d%n", releaseDate);
        System.out.printf("Basic Plan: %b%n", includedInBasicPlan);
        System.out.println(releaseDate < 1995 ? "Category: Retro Movie\n" : "Category: Modern Movie\n");

        while (counter < users){
            Scanner keyboard = new Scanner(System.in);
            System.out.printf("Ingresa la calificación que le darías a: '%s'%n", name);
            double userRating = keyboard.nextDouble();
            rating += userRating;
            counter++;
        }

        System.out.printf("Rating: %,.1f%n", rating / users);
    }


}