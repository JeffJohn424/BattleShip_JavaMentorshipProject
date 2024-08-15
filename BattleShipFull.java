//import java.util.Scanner;
//
//public class BattleShipFull {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int gridSize = 10;
//        char[][] player1Board = initializeBoard(gridSize);
//        char[][] player2Board = initializeBoard(gridSize);
//        char[][] player1Ships = initializeBoard(gridSize);
//        char[][] player2Ships = initializeBoard(gridSize);
//
//        // Get player names
//        System.out.print("Enter Player 1 name: ");
//        String player1Name = scanner.nextLine();
//        System.out.print("Enter Player 2 name: ");
//        String player2Name = scanner.nextLine();
//
//        // Place ships for Player 1
//        System.out.println(player1Name + ", place your ships:");
//        placeShips(scanner, player1Ships, gridSize);
//
//        // Place ships for Player 2
//        System.out.println(player2Name + ", place your ships:");
//        placeShips(scanner, player2Ships, gridSize);
//
//        // Game loop
//        boolean gameWon = false;
//        boolean player1Turn = true;
//
//        while (!gameWon) {
//            if (player1Turn) {
//                System.out.println(player1Name + "'s turn:");
//                gameWon = takeTurn(scanner, player2Board, player1Ships, gridSize);
//                if (gameWon) {
//                    System.out.println(player1Name + " wins!");
//                }
//            } else {
//                System.out.println(player2Name + "'s turn:");
//                gameWon = takeTurn(scanner, player1Board, player2Ships, gridSize);
//                if (gameWon) {
//                    System.out.println(player2Name + " wins!");
//                }
//            }
//            player1Turn = !player1Turn; // Switch turns
//        }
//
//        scanner.close();
//    }
//
//    // Initialize the board with 'X'
//    public static char[][] initializeBoard(int size) {
//        char[][] board = new char[size][size];
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//                board[i][j] = 'X';
//            }
//        }
//        return board;
//    }
//
//    // Print the board (optional for debugging)
//    public static void printBoard(char[][] board) {
//        System.out.print("  ");
//        for (int i = 0; i < board.length; i++) {
//            System.out.print((i + 1) + " ");
//        }
//        System.out.println();
//        for (int i = 0; i < board.length; i++) {
//            System.out.print((i + 1) + " ");
//            for (int j = 0; j < board[i].length; j++) {
//                System.out.print(board[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
//
//    // Place ships on the board
//    public static void placeShips(Scanner scanner, char[][] grid, int gridSize) {
//        int shipsToPlace = 3;
//        for (int ship = 1; ship <= shipsToPlace; ship++) {
//            while (true) {
//                System.out.println("Enter coordinates for Ship " + ship + " (format: row1,col1 row2,col2 row3,col3):");
//                String input = scanner.nextLine().trim();
//                String[] coordinates = input.split(" ");
//
//                if (coordinates.length != 3) {
//                    System.out.println("You must enter exactly 3 coordinates.");
//                    continue;
//                }
//
//                int[][] shipCoords = new int[3][2];
//                boolean valid = true;
//
//                for (int i = 0; i < 3; i++) {
//                    try {
//                        String[] parts = coordinates[i].split(",");
//                        int row = Integer.parseInt(parts[0].trim()) - 1;
//                        int col = Integer.parseInt(parts[1].trim()) - 1;
//
//                        if (row < 0 || row >= gridSize || col < 0 || col >= gridSize) {
//                            valid = false;
//                            break;
//                        }
//
//                        shipCoords[i][0] = row;
//                        shipCoords[i][1] = col;
//                    } catch (Exception e) {
//                        valid = false;
//                        break;
//                    }
//                }
//
//                if (!valid || !isValidShipPlacement(grid, shipCoords)) {
//                    System.out.println("Invalid ship placement. Coordinates must be consecutive and not overlap.");
//                    continue;
//                }
//
//                for (int[] coord : shipCoords) {
//                    grid[coord[0]][coord[1]] = 'S'; // Mark ship on grid
//                }
//                break;
//            }
//        }
//    }
//
//    // Validate if ship coordinates are consecutive
//    public static boolean isValidShipPlacement(char[][] grid, int[][] coords) {
//        boolean horizontal = coords[0][0] == coords[1][0] && coords[1][0] == coords[2][0];
//        boolean vertical = coords[0][1] == coords[1][1] && coords[1][1] == coords[2][1];
//
//        if (horizontal) {
//            int row = coords[0][0];
//            int startCol = Math.min(coords[0][1], Math.min(coords[1][1], coords[2][1]));
//            int endCol = Math.max(coords[0][1], Math.max(coords[1][1], coords[2][1]));
//            return endCol - startCol == 2;
//        } else if (vertical) {
//            int col = coords[0][1];
//            int startRow = Math.min(coords[0][0], Math.min(coords[1][0], coords[2][0]));
//            int endRow = Math.max(coords[0][0], Math.max(coords[1][0], coords[2][0]));
//            return endRow - startRow == 2;
//        }
//
//        return false;
//    }
//
//    // Handle a player's turn
//    public static boolean takeTurn(Scanner scanner, char[][] board, char[][] ships, int gridSize) {
//        while (true) {
//            System.out.print("Enter attack coordinate (row,column): ");
//            try {
//                String[] input = scanner.nextLine().trim().split(",");
//                int row = Integer.parseInt(input[0].trim()) - 1;
//                int col = Integer.parseInt(input[1].trim()) - 1;
//
//                if (row < 0 || row >= gridSize || col < 0 || col >= gridSize) {
//                    System.out.println("Invalid coordinates. Try again.");
//                    continue;
//                }
//
//                if (board[row][col] != 'X') {
//                    System.out.println("Coordinate already attacked. Try again.");
//                    continue;
//                }
//
//                if (ships[row][col] == 'S') {
//                    System.out.println("Hit!");
//                    board[row][col] = 'H'; // Mark as hit on the board
//                    ships[row][col] = 'X'; // Remove ship part from ships grid
//                } else {
//                    System.out.println("Miss.");
//                    board[row][col] = 'M'; // Mark as miss on the board
//                }
//
//                return checkForWin(ships, gridSize);
//            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
//                System.out.println("Invalid input format. Please enter numbers.");
//            }
//        }
//    }
//
//    // Check if all ships are sunk
//    public static boolean checkForWin(char[][] grid, int gridSize) {
//        for (int i = 0; i < gridSize; i++) {
//            for (int j = 0; j < gridSize; j++) {
//                if (grid[i][j] == 'S') return false;
//            }
//        }
//        return true;
//    }
//
//}
