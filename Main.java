import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static String [] words = {"EVEREST", "CINEMA", "APEX", "CLIMAX", "WISDOM", "PREMIERE", "HEREDITARY", "PRIMARY"};
    public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList <String> arr = new ArrayList<>();



    public static void printBoard(ArrayList<String>arr, int life){

        for(String x: arr){
            System.out.print(x);

        }
        System.out.println(" " + life + " life left");

    }


    public static boolean checkWinner(ArrayList <String> arr, String theWord, int life){
        String winnerCheck = "";

        for(String x: arr){
            winnerCheck += x;

        }

        if(winnerCheck.equals(theWord)){
            System.out.println("You won!!!");
            return false;

        }else if(life==0){
            System.out.println("No life left..");
            System.out.println("Game Over!!!");
            return false;

        }
        return true;

    }


    public static void main(String[] args) {



       while (true) {
           String theWord = "";
           arr.clear();
           int life = 8;
            System.out.println("Welcome to Hangman!!!");
            System.out.println();
            System.out.println("Press n for new game");
            System.out.println("Press q to quit");
            String menu = scanner.nextLine();

            if (menu.equals("q")) {
                System.out.println("Exitting.....");
                break;
            } else if (menu.equals("n")) {

                int index = random.nextInt(words.length);
                theWord += words[index];

                for(int i = 0; i<theWord.length(); i++){
                    arr.add("_");
                }

                printBoard(arr, life);


                while(checkWinner(arr, theWord, life)){

                    System.out.println("Enter a Letter: (A-Z)");

                    //Only letters exception regex

                    String answer = scanner.nextLine();

                    if(!Pattern.matches("[A-Z]", answer)){
                        System.out.println("Only capital letters..");
                        continue;
                    }


                    char letter = answer.charAt(0);

                    if(arr.contains(answer)){
                        System.out.println("Already Entered");

                    }else {

                        for (int i = 0; i < theWord.length(); i++) {
                            if (theWord.charAt(i) == letter) {
                                arr.remove(i);
                                arr.add(i, answer);

                            }


                        }

                        if(!arr.contains(answer)){
                            life-=1;

                        }


                    }



                    printBoard(arr, life);
                    System.out.println();



                }



                }else{
                System.out.println("Invalid character");
                continue;

            }


            }



        }



}
