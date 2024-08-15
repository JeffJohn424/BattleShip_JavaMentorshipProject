//import java.util.Scanner;
//
//public class BattleShip {
//
//    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//        int grid_size = 10;
//
//        int[][] player1_ships = new int[grid_size][grid_size];
//        int[][] player2_ships = new int[grid_size][grid_size];
//        int[][] player1_trackinggrid = new int[grid_size][grid_size];
//        int[][] player2_trackinggrid = new int[grid_size][grid_size];
//        System.out.println("Enter the name of player 1: ");
//        String player1 = scanner.next();
//        System.out.println("Enter the name of player 2: ");
//        String player2 = scanner.next();
//
//        char[][] board = new char[n][n];
//        for (int row = 0; row < board.length; row++) {
//            for (int col = 0; col < board[row].length; col++) {
//                board[row][col] = 'X';
//            }
//        }
//
//        printBoard(board);
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        printBoard(board);
//
//        System.out.println(player1 + " Enter the coordinates where you want to place your ships: ");
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                player1_ships[i][j] = scanner.nextInt();
//                System.out.println(player1_ships[i][j]);
//            }
//
//        }
//
//    }
//
//    public static void printBoard(char[][] board) {
//        for (int row = 0; row < board.length; row++) {
//            for (int col = 0; col < board[row].length; col++) {
//                System.out.print(board[row][col] + " | ");
//            }
//            System.out.println();
//        }
//    }
//
//}