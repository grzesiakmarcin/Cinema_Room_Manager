package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int delcaredRows = (sc.nextInt() +1);
        System.out.println("Enter the number of seats in each row:");
        int delcaredSeats =( sc.nextInt()+1) ;


        String[][] cinemaRoom = new String[delcaredRows][delcaredSeats];


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

                //System.out.print(cinemaRoom[i][j] + " ");
            }

            //   System.out.println();
        }

        cinemaRoom[1][5]="F";


        for (int i = 0; i  <delcaredRows; i++) {

            for (int j = 0; j < delcaredSeats; j++) {
                System.out.print(cinemaRoom[i][j]+" ");

            }
               System.out.println();
        }

    }
}

class Bebechy {


    public void calculateTicketPrice(int declaredRows, int declaredSeats, int wantedRow, int wantedSeat) {


        int rows = declaredRows;

        int seats = declaredSeats;
        int price = 0;


        if (seats * rows <= 60) {
            price = 10;
        } else if (seats * rows > 60) {

            price = wantedRow > (rows / 2) ? 8 : 10;

        }


        System.out.println("Ticket Price: $" + price);
    }


    public void seatPriseChecker() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int delcaredRows = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int delcaredSeats = sc.nextInt();
        printCinema(delcaredRows, delcaredSeats);
        System.out.println("Enter a row number:");
        int wantedRow = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int wantedSeat = sc.nextInt();
        calculateTicketPrice(delcaredRows, delcaredSeats, wantedRow, wantedSeat);


    }

    public void printCinemaSeatPrise(int declaredRows, int declaredSeats, int wantedRow, int wantedSeat) {
        int price = 0;

        int half = declaredRows / 2;
        if (wantedRow > half) {
            price = 8;
        } else {
            price = 10;
        }


        System.out.println(price);

    }

    public void printCinema(int delcaredRows, int delcaredSeats) {


        System.out.println("Cinema:");
        System.out.print(" ");


        for (int i = 1; i <= delcaredSeats; i++) {
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


    public String[][] makeAnArray(int delaredRows, int declaredSeats) {
        String[][] cinemaRoom = new String[delaredRows + 1][declaredSeats + 1];


        return cinemaRoom;
    }
}







