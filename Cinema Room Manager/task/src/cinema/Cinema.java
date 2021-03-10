package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {

        Bebechy playMe = new Bebechy();
        playMe.printCinema();




    }
}

class Bebechy {

    public void calculateIncome() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = sc.nextInt();
        int income = 0;


        if (seats * rows <= 60) {
            income = seats * rows * 10;
        } else if (seats * rows > 60) {
            int halfOfTheScreemRoom = rows / 2;

            int moreExpesiveTickersIncome = halfOfTheScreemRoom * seats * 10;
            int lessExpesiveTicketsIncome = (rows - halfOfTheScreemRoom) * seats * 8;
            income = moreExpesiveTickersIncome + lessExpesiveTicketsIncome;

        }


        System.out.println("Total income:\n$" + income);
    }






    public void printCinema(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int delcaredRows=sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int delcaredSeats=sc.nextInt();

        System.out.println("Cinema:");
        System.out.print(" ");


        for (int i = 1; i <=delcaredSeats; i++) {
            System.out.print(" " + i);
        }
        System.out.println();

        for (int i = 1; i <= delcaredRows; i++) {
            System.out.print(i);
            for (int j = 1; j <= delcaredSeats; j++) {
                System.out.print(" S");
            }
            System.out.println();
        }
    }


}
