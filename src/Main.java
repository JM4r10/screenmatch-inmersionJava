import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int releaseDate = 2007;
        double rating = 4.6;
        boolean includedInBasicPlan = true;
        double averageRating = 0;
        double users = 3;
        String name = "There will be blood";
        String synopsis = """
                There Will Be Blood is a 2007 American epic period drama film written and directed by Paul Thomas Anderson, loosely based on the 1927 novel Oil! by Upton Sinclair.""";

        System.out.println("Bienvenidos a la inmersión en Java");
        System.out.printf("Title: %s\n",name);
        System.out.printf("Synopsis: %s%n",synopsis);
        System.out.printf("Release Date: %d%n",releaseDate);
        System.out.printf("Rating: %f%n",rating);
        System.out.printf("Basic Plan: %b%n%n",includedInBasicPlan);
        System.out.println(releaseDate<1995?"Retro Movie":"Modern Movie");

        for(int i = 0; i < users; i++){
            Scanner teclado = new Scanner(System.in);
            System.out.printf("Ingresa la nota que le darías a: '%s'%n", name);
            double userRating = teclado.nextDouble();
            averageRating += userRating;
        }

        System.out.printf("Average Rating: %,.1f%n", averageRating/users);

    }


}