import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("*********************");
        System.out.println("Welcome to Java Slots");
        System.out.println("Symbols: 🍒🍉🍋🔔⭐");
        System.out.println("*********************");

        int balance = 100;
        int bet;
        String[] row;
        int payout;
        String playAgain;


        while (balance > 0) {
            System.out.println("Current Balance: $" + balance);
            System.out.print("Place your bet amount: ");
            bet = scanner.nextInt();
            scanner.nextLine();


            if (bet <= 0) {
                System.out.println("Bet must be greater than 0");
                continue;
            }
            if (bet <= balance) {
                balance -= bet;
            } else {
                System.out.println("INSUFFICIENT FUNDS");
                continue;
            }


            System.out.println("Spinning...");
            row = spinRow();
            printRow(row);
            payout = getPayout(row, bet);

            if (payout > 0) {
                System.out.println("You Won $" + payout);
                balance += payout;
            } else {
                System.out.println("Sorry you lost this round");
            }

            System.out.print("Play Again?(Y/N): ");
            playAgain = scanner.nextLine().toUpperCase();

            if (!playAgain.equals("Y")){
                System.out.println("Goodbye! Thanks for playing");
                System.out.println("Current Balance: $" + balance);
                break;
            }

        }
    }

    static String[] spinRow() {

        Random random = new Random();
        String[] symbols = {"🍒", "🍉", "🍋", "🔔", "⭐"};
        String[] row = new String[3];

        for (int i = 0; i < 3; i++) {
            row[i] = symbols[random.nextInt(symbols.length)];
        }
        return row;
    }

    static void printRow(String[] row) {
        System.out.println("**************");
        System.out.println(" " + String.join(" | ", row));
        System.out.println("**************");
    }

    static int getPayout(String[] row, int bet) {
        if (row[0].equals(row[1]) && row[1].equals(row[2]))
            return switch (row[0]) {
                case "🍒" -> bet * 3;
                case "🍉" -> bet * 4;
                case "🍋" -> bet * 5;
                case "🔔" -> bet * 10;
                case "⭐" -> bet * 20;
                default -> 0;
            };

        else if(row[0].equals(row[1]))
            return switch (row[0]) {
                case "🍒" -> bet * 2;
                case "🍉" -> bet * 3;
                case "🍋" -> bet * 4;
                case "🔔" -> bet * 5;
                case "⭐" -> bet * 10;
                default -> 0;
            };

        else if( row[1].equals(row[2]))
            return switch (row[1]) {
                case "🍒" -> bet * 2;
                case "🍉" -> bet * 3;
                case "🍋" -> bet * 4;
                case "🔔" -> bet * 5;
                case "⭐" -> bet * 10;
                default -> 0;
            };

        else if( row[0].equals(row[2]))
            return switch (row[0]) {
                case "🍒" -> bet * 2;
                case "🍉" -> bet * 3;
                case "🍋" -> bet * 4;
                case "🔔" -> bet * 5;
                case "⭐" -> bet * 10;
                default -> 0;
            };

        return 0;
    }


}