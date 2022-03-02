import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        int player = 1;
        int row, col;

        Scanner inputValue = new Scanner(System.in);


        while(!board.wins() && !board.isDraw()) {
            System.out.println("GAME IN PROGRESS..");
            System.out.println("Player " + player + " shoot!");
            board.print();

            System.out.println("Introduce a col to shoot in");
            col = inputValue.nextInt() - 1;
            System.out.println("Introduce a row to shoot in");
            row = inputValue.nextInt() - 1;


            if (board.isAvailableCell(row, col)) {
                board.shoot(row, col, player);
                if (player == 1) {
                    player = 2;
                } else {
                    player = 1;
                }
            }else {
                System.out.println("The cell is not empty, try to shoot again.");
            }
        }
    }
}


