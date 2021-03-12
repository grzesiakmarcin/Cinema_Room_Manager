package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {


        Bebechy playMe = new Bebechy();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int delcaredRows = (sc.nextInt() + 1);
        System.out.println("Enter the number of seats in each row:");
        int delcaredSeats = (sc.nextInt() + 1);


        String[][] cinemaRoom = new String[delcaredRows][delcaredSeats];
        int totalSeats = playMe.calculateSeats(cinemaRoom);
        int currentincome = 0;
        int totalIncome = 0;


        for (int i = 0; i < delcaredRows; i++) {

            for (int j = 0; j < delcaredSeats; j++) {

                if (i == 0 && j == 0) {
                    cinemaRoom[i][j] = " ";
                } else if (i == 0 && j != 0) {
                    cinemaRoom[i][j] = Integer.toString(j);
                } else if (i != 0 && j == 0) {
                    cinemaRoom[i][j] = Integer.toString(i);
                } else {
                    cinemaRoom[i][j] = "S";
                }

            }

        }


        do {
            System.out.println("\n1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit");
            int menuAnswer = sc.nextInt();

            switch (menuAnswer) {

                case 1:
                    playMe.printCinema(cinemaRoom);
                    break;
                case 2:
                    playMe.bookAndShowCinemaSeatPrise(cinemaRoom);
                    break;
                case 3:
                    playMe.statistics(cinemaRoom);
                    break;
                case 0:
                    return;


            }
        } while (true);


    }
}

class Bebechy {

    static int currentIncome = 0;

    public void increaseCurrentIncome(int priceOfSoldTicker) {
        currentIncome = currentIncome + priceOfSoldTicker;
    }

    public int calculateSeats(String[][] array) {
        return (array.length - 1) * (array[0].length - 1);
    }


    public String[][] bookTheSeat(String[][] cinemaRoom, int rowWanted, int seatWanted) {
        int delcaredRows = cinemaRoom.length;
        int delcaredSeats = cinemaRoom[0].length;

        if (cinemaRoom[rowWanted][seatWanted] == "S") {
            cinemaRoom[rowWanted][seatWanted] = "B";
        } else {
            System.out.println("That ticket has already been purchased!");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a row number:");
            rowWanted = sc.nextInt();
            while (rowWanted > delcaredRows || rowWanted < 1) {
                System.out.println("Wrong input!");
                rowWanted = sc.nextInt();
            }
            System.out.println("Enter a seat number in that row:");
            seatWanted = sc.nextInt();
            while (seatWanted > delcaredSeats || seatWanted < 1) {
                System.out.println("Wrong input!");
                seatWanted = sc.nextInt();
            }
            bookTheSeat(cinemaRoom, rowWanted, seatWanted);
        }
        return cinemaRoom;

    }


    public String[][] bookAndShowCinemaSeatPrise(String[][] cinemaRoom) {
        Scanner sc = new Scanner(System.in);
        int delcaredRows = cinemaRoom.length - 1;
        int delcaredSeats = cinemaRoom[0].length - 1;

        System.out.println("Enter a row number:");

        int rowWanted = sc.nextInt();
        while (rowWanted > delcaredRows || rowWanted < 1) {
            System.out.println("Wrong input!");
            rowWanted = sc.nextInt();
        }
        System.out.println("Enter a seat number in that row:");

        int seatWanted = sc.nextInt();
        while (seatWanted > delcaredSeats || seatWanted < 1) {
            System.out.println("Wrong input!");
            seatWanted = sc.nextInt();
        }

        int price;
        int half = delcaredRows / 2;

        int numberOfSeats = calculateSeats(cinemaRoom);

        if (numberOfSeats <= 60) {
            price = 10;
        } else {

            if (rowWanted > half) {
                price = 8;
            } else {
                price = 10;
            }

        }
        bookTheSeat(cinemaRoom, rowWanted, seatWanted);
        System.out.println("Ticket Price: $" + price);
        increaseCurrentIncome(price);

        printCinema(cinemaRoom);


        return cinemaRoom;

    }


    public void printCinema(String[][] cinemaRoom) {
        int delcaredRows = cinemaRoom.length;
        int delcaredSeats = cinemaRoom[0].length;

        System.out.println("Cinema:");


        for (int i = 0; i < delcaredRows; i++) {
            for (int j = 0; j < delcaredSeats; j++) {
                System.out.print(cinemaRoom[i][j] + " ");
            }
            System.out.println();
        }

    }

    public void statistics(String[][] cinemRoom) {
        System.out.println("Number of purchased tickets: " + countSoldTickets(cinemRoom));
        System.out.println("Percentage: " + String.format("%.2f", countSoldTicketsInPercents(cinemRoom)) + "%");
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + countTotalPossibleIncome(cinemRoom));

    }

    public int countTotalPossibleIncome(String[][] cinemaRoom) {
        int totalIncome = 0;
        int delcaredRows = cinemaRoom.length - 1;
        int delcaredSeats = cinemaRoom[0].length - 1;
        int price = 0;

        int half = delcaredRows / 2;
        System.out.println("polowa: " + half);


        int numberOfSeats = calculateSeats(cinemaRoom);
        System.out.println("ilosc miejsc: " + numberOfSeats);

        if (numberOfSeats <= 60) {

            totalIncome = 10 * numberOfSeats;
        } else {

            for (int i = 0; i < delcaredRows; i++) {
                for (int j = 0; j < delcaredSeats; j++) {


                    if (i < half) {
                        totalIncome = totalIncome + 10;

                    } else {
                        totalIncome = totalIncome + 8;
                    }

                }

            }
        }
        return totalIncome;
    }

    public int countSoldTickets(String[][] cinemaRoom) {

        int counter = 0;
        for (int i = 0; i < cinemaRoom.length; i++) {
            for (int j = 0; j < cinemaRoom[0].length; j++) {
                if (cinemaRoom[i][j] == "B") {
                    counter++;
                }
            }

        }
        return counter;
    }

    public double countSoldTicketsInPercents(String[][] cinemaRoom) {


        double totalSeats = calculateSeats(cinemaRoom);
        double counter = 0;
        for (int i = 0; i < cinemaRoom.length; i++) {
            for (int j = 0; j < cinemaRoom[0].length; j++) {
                if (cinemaRoom[i][j] == "B") {
                    counter++;
                }
            }

        }
        double percentage = 100 * (counter / totalSeats);
        return percentage;
    }


}







