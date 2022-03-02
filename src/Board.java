import java.sql.SQLOutput;

public class Board {

    private char cell[][];
    public static char ISEMPTY = ' ';


    //Constructor
    public Board() {
        this.cell = new char[3][3];
        createBoard();

    }

    private void createBoard() {
        for (int rows = 0; rows < cell.length; rows++) {
            for (int cols = 0; cols < cell.length; cols++) {
                cell[rows][cols] = ISEMPTY;

            }
        }
    }


    //Metodos
    public void print() {
        System.out.println(" " + "1 " + "2 " + "3");
        for (int rows = 0; rows < cell.length; rows++) {
            System.out.print(rows + 1);
            for (int cols = 0; cols < cell.length; cols++) {
                System.out.print(cell[rows][cols] + " ");

            }
            System.out.println();

        }

    }

    public void shoot(int row, int col, int player) {
        if (player == 1) {
            this.cell[row][col] = 'X';
        } else {
            this.cell[row][col] = '0';
        }
    }


    public boolean isAvailableCell(int row, int col) {
        return cell[row][col] == ISEMPTY;
    }

    public boolean wins() {
        return horizontalCheck() || verticalCheck() || diagonalCheck();
    }

    public boolean isDraw() {
        for (int rows = 0; rows < cell.length; rows++) {
            for (int cols = 0; cols < cell.length; cols++) {
                if (cell[rows][cols] == ISEMPTY) {
                    return false;
                }
            }
        }
        System.out.println("You draw!");
        return true;
    }

    public boolean horizontalCheck() {
        int counterX = 0;
        int counter0 = 0;

        for (int rows = 0; rows < cell.length; rows++) {
            for (int cols = 0; cols < cell.length; cols++) {
                if (cell[rows][cols] != ISEMPTY) {
                    if (cell[rows][cols] == 'X') {
                        counterX++;
                    }
                    if (cell[rows][cols] == '0') {
                        counter0++;
                    }
                }
            }

            if (counterX == 3) {
                System.out.println("Player 1 win!");
                return true;
            }
            if (counter0 == 3) {
                System.out.println("Player 2 win!");
                return true;
            }
            counter0 = 0;
            counterX = 0;
        }
        return false;
    }

    private boolean diagonalCheck() {
        if ((cell[0][0] == 'X' && cell[1][1] == 'X' && cell[2][2] == 'X') ||
        (cell[2][0] == 'X' && cell[1][1] == 'X' && cell[0][2] == 'X')) {
            System.out.println("Player 1 wins!");
            return true;
        } if ((cell[2][0] == '0' && cell[1][1] == '0' && cell[0][2] == '0') ||
                (cell[0][0] == '0' && cell[1][1] == '0' && cell[2][2] == '0')){
            System.out.println("Player 2 wins!");
            return true;
        } else {
            return false;
        }

    }

    private boolean verticalCheck () {
        int counterX = 0;
        int counter0 = 0;
        for (int cols = 0; cols < cell.length; cols++) {
            for (int rows = 0; rows < cell.length; rows++) {
                if (cell[rows][cols] != ISEMPTY) {
                    if (cell[rows][cols] == 'X') {
                        counterX++;
                    }
                    if (cell[rows][cols] == '0') {
                        counter0++;
                    }
                }
            }

            if (counterX == 3) {
                System.out.println("Player 1 win!");
                return true;
            }
            if (counter0 == 3) {
                System.out.println("Player 2 win!");
                return true;
            }
            counter0 = 0;
            counterX = 0;
        }
        return false;
    }

}






