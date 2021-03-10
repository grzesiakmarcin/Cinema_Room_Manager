package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {

        Bebechy playMe = new Bebechy();
        playMe.calculateIncome();


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


        System.out.println("Total income:\n$"+income);
    }


    public void printCinema(String[][] array) {
        System.out.println("Cinema:");


        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printCinema() {
        System.out.println("Cinema:");
        // Developing Rows
        for (int row = 0; row <= 8; row++) {
            if (row == 0) {
                System.out.print("  ");
            } else if (row == 8) {
                System.out.print(row + "\n");
            } else {
                System.out.print(row + " ");
            }
        }
        // Developing Columns
        for (int row = 1; row <= 7; row++) {
            for (int col = 0; col <= 8; col++) {
                if (col == 0) {
                    System.out.print(row + " ");
                } else if (col == 8) {
                    System.out.print("S\n");
                } else {
                    System.out.print("S ");
                }
            }
        }
    }


    //    String[][] cinema = {
//            {" ", "1", "2", "3", "4", "5", "6", "7", "8"},
//            {"1", "S", "S", "S", "S", "S", "S", "S", "S"},
//            {"2", "S", "S", "S", "S", "S", "S", "S", "S"},
//            {"3", "S", "S", "S", "S", "S", "S", "S", "S"},
//            {"4", "S", "S", "S", "S", "S", "S", "S", "S"},
//            {"5", "S", "S", "S", "S", "S", "S", "S", "S"},
//            {"6", "S", "S", "S", "S", "S", "S", "S", "S"},
//            {"7", "S", "S", "S", "S", "S", "S", "S", "S"}};
}
