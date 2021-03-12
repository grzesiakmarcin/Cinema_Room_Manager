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

        playMe.printCinema(cinemaRoom);
        playMe.bookAndShowCinemaSeatPrise(cinemaRoom);








    }
}

class Bebechy {

    public int calculateSeats(String[][] array){
        return (array.length-1)*(array[0].length-1);
    }


    public String[][] bookTheSeat(String[][] cinemaRoom, int rowWanted,int seatWanted) {
        int delcaredRows = cinemaRoom.length;
        int delcaredSeats = cinemaRoom[0].length;

        cinemaRoom[rowWanted][seatWanted] = "B";
        return cinemaRoom;

    }


    public String[][] bookAndShowCinemaSeatPrise(String[][] cinemaRoom) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a row number:");
        int rowWanted = sc.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seatWanted = sc.nextInt();
        int delcaredRows = cinemaRoom.length-1;
        int delcaredSeats = cinemaRoom[0].length-1;
        int price;

        int half=delcaredRows/2;




        int numberOfSeats = calculateSeats(cinemaRoom);

        if(numberOfSeats<=60){
            price=10;
        }
        else {

            if (rowWanted > half) {
                price = 8;
            } else {
                price = 10;
            }

        }
        System.out.println("Ticket Price: $" + price);
        bookTheSeat(cinemaRoom,rowWanted,seatWanted);
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


}







