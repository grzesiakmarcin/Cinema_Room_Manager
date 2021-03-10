package cinema;

public class Cinema {

    public static void main(String[] args) {

        Bebechy playMe = new Bebechy();

        playMe.printCinema(playMe.cinema);







    }
}

class Bebechy{

    String[][] cinema={
            { " ","1","2","3","4","5","6","7","8"},
            {"1", "S", "S", "S", "S", "S", "S", "S","S"},
            {"2", "S", "S", "S", "S", "S", "S", "S","S"},
            {"3", "S", "S", "S", "S", "S", "S", "S","S"},
            {"4", "S", "S", "S", "S", "S", "S", "S","S"},
            {"5", "S", "S", "S", "S", "S", "S", "S","S"},
            {"6", "S", "S", "S", "S", "S", "S", "S","S"},
            {"7", "S", "S", "S", "S", "S", "S", "S","S"}};


    public void printCinema(String[][] array){
        System.out.println("Cinema:");


        for (int i=0; i< array.length;i++){
            for (int j=0; j<array[i].length;j++ ){
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }

    }
}