//imports
import java.util.Scanner;
import java.util.Random;

//begins Minesweeper class
public class Minesweeper {
    //begins main method
    public static void main(String[] args) throws Exception {
        //==================================================================================================//
        //initialization of basefield, numField, and playerView arrays
        
        //creating baseField array
        Random random = new Random();
        int randomRow = random.nextInt(4);
        int randomCol = random.nextInt(4);
        String[][] baseField = {
            {" "," "," "," "," "},
            {" "," "," "," "," "},
            {" "," "," "," "," "},
            {" "," "," "," "," "},
            {" "," "," "," "," "}
        };

        //initializing total number of bombs and flags, then randomly placing them in the baseField array
        int bombTotal = 10;
        int flagTotal = 1;

        while(bombTotal > 0) {
            if(baseField[randomRow][randomCol] == " ") {
                bombTotal -= 1;
                baseField[randomRow][randomCol] = "X";
            }
            randomRow = random.nextInt(5);
            randomCol = random.nextInt(5);
        }

        while(flagTotal > 0) {
            randomRow = random.nextInt(5);
            randomCol = random.nextInt(5);

            if(baseField[randomRow][randomCol] == " ") {
                flagTotal -= 1;
                baseField[randomRow][randomCol] = "F";
            }
        }

        //creating numField array, which represents the number of bombs adjacent to each space, including diagonallay adjacent ones and not counting the space itself:
            int[][] numField = new int[5][5];
            int bombNum;
            for(int row=0; row<5; row++) {
                for(int col=0; col<5; col++) {
                    bombNum = 0;

                    //checks if there is a row above the current row inside baseField array
                    if((row-1)>=0) {
                        //checks if there is a column to the left of current column inside baseField array
                        if((col-1)>=0) {
                            //value in top-left cell is added to bombNum
                            if(baseField[row-1][col-1] == "X") {
                                bombNum += 1;
                            };
                        }
                        //value in top-center cell is added to bombNum
                        if(baseField[row-1][col] == "X") {
                            bombNum += 1;
                        };

                        //checks if there is a column to the right of current column inside baseField array
                        if((col+1)<5) {
                            //value in top-right cell is added to bombNum
                            if(baseField[row-1][col+1] == "X") {
                                bombNum += 1;
                            };
                        }
                    }
                    //checks if there is a column to the left of current column inside baseField array
                    if((col-1)>=0) {
                        //value in center-left cell is added to bombNum
                        if(baseField[row][col-1] == "X") {
                            bombNum += 1;
                        };
                    }

                    //checks if there is a column to the left of current column inside baseField array
                    if((col+1)<5) {
                        //value in center-right cell is added to bombNum
                        if(baseField[row][col+1] == "X") {
                            bombNum += 1;
                        };
                    }

                    //checks if there is a row below the current row inside baseField array
                    if((row+1)<5) {
                        //checks if there is a column to the left of the current column inside baseField array
                        if((col-1)>=0) {
                            //value in bottom-left cell is added to bombNum
                            if(baseField[row+1][col-1] == "X") {
                                bombNum += 1;
                            };
                        }
                        
                        //value in bottom-center cell is added to bombNum
                        if(baseField[row+1][col] == "X") {
                            bombNum += 1;
                        };

                        //checks if there is a colun to the left of the current column inside baseField array
                        if((col+1)<5) {
                            //value in bottom-right cell is added to bombNum
                            if(baseField[row+1][col+1] == "X") {
                                bombNum += 1;
                            };
                        }
                    }

                    //putting current bombNum into playerView array
                    numField[row][col] = bombNum;
                }
            }
        
        //initializing playerView array
        String[][]playerView = {
            {" "," ","1","2","3","4","5"," "},
            {" ","-","-","-","-","-","-","-"},
            {"A","|"," "," "," "," "," ","|"},
            {"B","|"," "," "," "," "," ","|"},
            {"C","|"," "," "," "," "," ","|"},
            {"D","|"," "," "," "," "," ","|"},
            {"E","|"," "," "," "," "," ","|"},
            {" ","=","=","=","=","=","=","="},
            {" ","-","-","-","-","-","-","-"}
        };

        //creating and initializing some variables:
        boolean flagFound = false;
        int lives = 3;
        String rowInput;
        String rowInputUppercase;
        int rowActual;
        int colInput;
        int colActual;

        //creating scan object for player input
        Scanner scan = new Scanner(System.in);


        //=============================================================================//
        //main gameplay loop

        while(lives > 0 && flagFound == false) {
            //prints initial playerView array
            printArray(playerView);
            System.out.println("You have " + lives + " lives left.");

            //player input: row
            System.out.println("Enter the row letter you wish to select (A-E):");
            rowInput = scan.next();
            rowInputUppercase = rowInput.toUpperCase();
            //checks if player input is valid
            rowActual = validateInput(rowInputUppercase);
            while (rowActual > 4) {
                System.out.println("Invalid input. Please try again.");
                rowInput = scan.next();
                rowActual = validateInput(rowInputUppercase);
            }

            //player input: column number
            System.out.println("Enter the column number you wish to select (1-5):");
            colInput = scan.nextInt();
            //checks if player input is valid
            colActual = validateInput(colInput);
            while (colActual > 4) {
                System.out.println("Invalid input. Please try again.");
                colInput = scan.nextInt();
                colActual = validateInput(colInput);

            }

            //checks and updates playerView array, as well as lives and flagFound variables
            //2 is added to rowActual and colActual values to account for the playerView array being larger, with the field "spaces" the player is filling in being indeces 2-6 instead of 0-4
            if(playerView[rowActual+2][colActual+2] == " ") {
                updateArray(rowActual, colActual, playerView, numField, baseField);
                if(baseField[rowActual][colActual] == "X") {
                    lives -= 1;
                }
            }
            if(playerView[rowActual+2][colActual+2] == "F") {
                flagFound = true;
            }
        }

        //==================================================================================//
        //endgame scenarios:

        //victory!
        if(flagFound == true) {
            System.out.println();
            printArray(playerView);
            System.out.println();
            System.out.println("==================================================");
            System.out.println("Congrats, you found the flag!! A winner is you! :D");
            scan.close();
        }

        //game over (lives == 0)
        else {
            System.out.println();
            printArray(playerView);
            System.out.println();
            System.out.println("=================================");
            System.out.println("You have 0 lives left. GAME OVER.");
            System.out.println("Better luck next time!");
            scan.close();
        }
    }

    //================================================================//
    //----------------------------------------------------------------//
    //methods:

    //prints playerView array
    static void printArray (String[][] x) {
        for (int row=0; row<8; row++) {
            for (int col=0; col<8; col++) {
                System.out.print(x[row][col]);
            }
        System.out.println();
        }
    }

    //validates player input (two versions, one for int (column input) and one for String (row input)):
    //validating column number from player
    static int validateInput(int input) {
        switch (input) {
                case 1:
                    return 0;

                case 2:
                    return 1;

                case 3:
                    return 2;

                case 4:
                    return 3;

                case 5:
                    return 4;
        
                default:
                    return 999;
            }
    }

    //validating row letter from player
    static int validateInput(String input) {
        switch (input) {
                case "A":
                    return 0;

                case "B":
                    return 1;

                case "C":
                    return 2;

                case "D":
                    return 3;

                case "E":
                    return 4;
        
                default:
                    return 999;
            }
    }

    //updating playerView array: first checks if space player selected is available, then updates lives and playerView accordingly
    //x = playerView, y = numField, z = baseField
    static void updateArray (int row, int col, String[][] x, int[][] y, String[][] z) {
        if(z[row][col] == "X" || z[row][col] == "F") {
            x[row+2][col+2] = z[row][col];
        }
        else {
            x[row+2][col+2] = String.valueOf(y[row][col]);
        }
    }

    //updates number of lives left
    static int updateLives(int row, int col, String[][]z, int livesCurrent, boolean emptySpace) {
        if(z[row][col] == "X" && emptySpace == true) {
            livesCurrent -= 1;
        }
        return livesCurrent;
    }
}
