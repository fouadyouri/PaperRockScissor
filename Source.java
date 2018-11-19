/**
 * Created by fouadyouri on 11/19/2018.
 */

import java.util.Random;
import java.util.Scanner;

enum Hand {
    PAPER,
    ROCK,
    SCISSOR
}

public class Source {
    static public void main(String[] args) {
        Random rand = new Random();
        boolean gameOver = false;
        Hand playerHand = Hand.ROCK;
        Hand compHand = Hand.ROCK;

        int numPlayerWins = 0;
        int numCompWins = 0;
        int numDraw = 0;
        int numGames = 0;
        Scanner in = new Scanner(System.in);


        System.out.println("Let's begin...!");
        int i = numGames - 1;

        while (!gameOver) {
            System.out.println("Paper, Rock, Scissor !!");
            boolean validInput = false;


            do {
                System.out.println("Enter S for Scissor, P for Paper, R for Rock or Q to Quit!");
                char input = in.next().toLowerCase().charAt(0);
                validInput = true;
                if (input == 'r')
                    playerHand = Hand.ROCK;
                else if (input == 's')
                    playerHand = Hand.SCISSOR;
                else if (input == 'p')
                    playerHand = Hand.PAPER;
                else if (input == 'q')
                    gameOver = true;
                else {
                    System.out.println("Check your input (R, S or P) !");
                }
            } while (!validInput);
            if (!gameOver) {
                int randCompHand = rand.nextInt(3);
                if (randCompHand == 0) {
                    compHand = Hand.PAPER;
                    System.out.println("My hand is Paper !");
                } else if (randCompHand == 1) {
                    compHand = Hand.ROCK;
                    System.out.println("My hand is Rock !");
                } else {
                    compHand = Hand.SCISSOR;
                    System.out.println("My hand is Scissor !");
                }

                if (compHand == playerHand) {
                    System.out.println("It's a Draw !");
                    numDraw++;
                } else if (compHand == Hand.PAPER && playerHand == Hand.ROCK) {
                    System.out.println("I won, Paper wraps Rock !");
                    numCompWins++;
                } else if (compHand == Hand.ROCK && playerHand == Hand.SCISSOR) {
                    System.out.println("I won, Rock breaks Scissor !");
                    numCompWins++;
                } else if (compHand == Hand.SCISSOR && playerHand == Hand.PAPER) {
                    System.out.println("I won, Scissor cuts Paper !");
                    numCompWins++;
                } else {
                    System.out.println("You win !");
                    numPlayerWins++;
                }
                numGames++;
            }
        }

        System.out.println("You have played " + numGames + " games;");
        double percCompWins =(double) numCompWins / numGames;
        double percPlayerWins =(double) numPlayerWins / numGames;
        double percDraws =(double) numDraw / numGames;
        System.out.println("You have won " + numPlayerWins + " which makes " + percPlayerWins * 100 + "% of games !");
        System.out.println("Computer has won " + numCompWins + " which makes " + percCompWins * 100 + "% of games !");
        System.out.println("Draws " + numDraw + " which makes " + percDraws * 100 + "% of games !");
        System.out.println("Bye !");
    }
}
