// Sabrina Vohra
import javax.swing.JFrame;
import java.awt.*;
import javax.swing.ImageIcon;

public class TicTacToeViewer extends JFrame{
    // Declares instance variables
    // Declares window height and width
    private static final int WINDOW_HEIGHT = 700;
    private static final int WINDOW_WIDTH = 700;
    // Sets side length of Square
    private static final int SIDE_LENGTH = 180;
    // Provides buffer for X and Y axes so board is centered / not touching the side of the window
    private static final int X_BUFFER = 40;
    private static final int Y_BUFFER = 60;
    // Declares a 2-D Array of Squares as the board
    private Square[][] board;
    // Declares an array to hold the X and O images
    private Image[] theImages;
    // Declares the TicTacToe Object
    private TicTacToe it;

    // Initializes constructor
    public TicTacToeViewer(TicTacToe it, Square[][] board) {
        // Sets TicTacToe Object to inputted TicTacToe Object
        this.it = it;
        // Declares four primary front end initializations
        // Sets window size
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        // Sets title of window
        this.setTitle("TicTacToe");
        // Makes window exit when closed (game won't run in background)
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Makes window visible for viewer
        this.setVisible(true);
        // Sets board to board inputted into constructor
        this.board = board;
        // Sets size of Image Array
        theImages = new Image[2];
        // Initializes X and O images
        theImages[0] = new ImageIcon("Resources/anyar.png").getImage();
        theImages[1] = new ImageIcon("Resources/kirinold.png").getImage();
    }

    // Paints the board accordingly
    public void paint(Graphics g) {
        // Sets board to board that's been created in TicTacToe
        board = it.getBoard();
        // Sets background color to white and fills window
        g.setColor(Color.white);
        g.fillRect(0,0, WINDOW_WIDTH, WINDOW_HEIGHT);
        // Resets color to black
        g.setColor(Color.black);
        // Traverses through row
        for(int i = 0; i < board.length; i++) {
            // Creates String to print for colum and row numbers
            String print = i + "";
            // Draws column and row numbers above / to the side of the middle of each Square
            g.drawString(print, (X_BUFFER) + (SIDE_LENGTH * i) + SIDE_LENGTH / 2, Y_BUFFER - 10);
            g.drawString(print, X_BUFFER / 2, Y_BUFFER + (SIDE_LENGTH * i) + SIDE_LENGTH / 2);
            // Sets x-coordinate for each Square's beginning
            int y = Y_BUFFER + (i * SIDE_LENGTH);
            // Traverses through column
            for(int j = 0; j < board[0].length; j++) {
                // Sets y-coordinate for each Square's beginning
                int x = X_BUFFER + (j * SIDE_LENGTH);
                // Calls drawSquare() method to draw each Square accordingly
                board[i][j].drawSquare(g, x, y, SIDE_LENGTH, theImages, this);
                // Checks for a tie
                if(it.checkTie()) {
                    // Initializes centered coordinate points
                    int xPrintPoint = 290;
                    int yPrintPoint = 650;
                    // Prints tie message at center coordinates
                    g.drawString("IT'S A TIE!", xPrintPoint, yPrintPoint);
                }
            }
        }
    }
}
