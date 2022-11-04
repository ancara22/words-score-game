package formativetest1;

import java.util.Arrays;
import java.util.Scanner;

public class FormativeTest1 {

    public static void main(String[] args) {
        String[][] userData = {};

        System.out.println("Let`s play...");

        String[] result = {};
        int r = 10;
        int totalSum = 0;
        
        while (r > 1) {
            for (int i = 0; i < 2; i++) {
                System.out.println("Player " + (i + 1) + " to choose the first word ...");
                result = play();

                userData = Arrays.copyOf(userData, userData.length + 1);
                userData[userData.length - 1] = result;

                totalSum = printTable(userData);
                if(totalSum>=200) {
                    System.out.println("Over 200, player "+ (i+1) + " lose.");
                    System.exit(0);
                }
                    
            }
            
            r--;
        }
        

    }

    public static String[] play() {
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        System.out.println("Enter a 3-letter word (lower case), "
                + "which must have a value of 20 or less, or enter * to give up > ");

        Scanner sc = new Scanner(System.in);

        String userWord = sc.nextLine();
        String[] userWordArray = userWord.split("");

        int innerScore = 0;
        String resultString = "(";

        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < alphabet.length; i++) {
                if (alphabet[i].toLowerCase().equals(userWordArray[j])) {
                    innerScore += i + 1;
                    String r = (i + 1) + "";
                    if(i<10) r = r + " ";
                    resultString = resultString + " " + r;
                }

            }
            if (j < 2) {
                resultString += " + ";
            } else {
                resultString += " )";
            }
        }
        String[] result = {userWord, resultString, "" + innerScore};

        return result;

    }

    public static int printTable(String[][] userData) {
        System.out.println("-----------------------------------------------------------");
        System.out.println("|   word                     | word total | running total |");
        System.out.println("-----------------------------------------------------------");

        int sum = 0;
        for (String[] game : userData) {
            if(game[0].length()<2) game[0] =  game[0]+ " ";
            if(game[2].length()<2) game[2] =  game[2]+ " ";
            
            sum += Integer.parseInt(game[2]);
            String sumString = (""+sum);
            if(sumString.length()<2) sumString =  sumString+ "  ";
            else if(sumString.length()==2) sumString =  sumString+ " ";
            
            System.out.println("|   " + game[0] + " " + game[1] + "   |     " + game[2] + "     |      "+ sumString +"      |");
            System.out.println("-----------------------------------------------------------");
            
            
        }
        System.out.println("\n");
        
        return sum;

    }
}
