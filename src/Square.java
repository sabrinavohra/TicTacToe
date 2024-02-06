// Sabrina Vohra
import java.awt.*;

/**
 * A class written to support the TicTacToe Game.
 *
 * Each Square object is one position of the TicTacToe
 * board. It maintains information on the marker, its
 * location on the board, and whether it is part
 * of the winning set.
 *
 * @author: Nandhini Namasivayam
 * @version: Jan 2023
 */

public class Square {

    private String marker;
    private int row;
    private int col;
    private boolean isWinningSquare;

    /**
     * Constructor to initialize one Square of the
     * TicTacToe board
     * @param row the row the square is in
     * @param col the column the square is in
     */
    public Square(int row, int col) {
        this.row = row;
        this.col = col;

        this.marker = TicTacToe.BLANK;
        this.isWinningSquare = false;
    }

    /******************** Getters and Setters ********************/
    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public void setWinningSquare() {
        this.isWinningSquare = true;
    }

    /**
     * Checks if the square has the BLANK marker
     * @return True if the square is empty, False otherwise
     */
    public boolean isEmpty() {
        return this.marker.equals(TicTacToe.BLANK);
    }

    /**
     * @return the marker for the square
     */
    // method draws each Square
    public void drawSquare(Graphics g, int x, int y, int length, Image[] theImages, TicTacToeViewer t) {
        // Sets color of Square outline to black
        g.setColor(Color.black);
        // Draws rectangle (the base of the square)
        g.drawRect(x, y, length, length);
        // Checks if the square should have an X symbol
        if(marker.equals(TicTacToe.X_MARKER)) {
            // Draws the X symbol within the Square
            g.drawImage(theImages[0], x, y, length, length, t);
        }
        // Checks if the square should have an O symbol
        if(marker.equals(TicTacToe.O_MARKER)) {
            // Draws the O symbol within the square
            g.drawImage(theImages[1], x, y, length, length, t);
        }
        // Checks if Square is a winning Square (meaning the game has been won and this Square is included in winning sequence)
        if(isWinningSquare) {
            // Colors background of Square green
            g.setColor(Color.green);
            g.fillRect(x, y, length, length);
            // Resets color to black
            g.setColor(Color.black);
            // Declares points where messages should print (~ bottom middle)
            int xPrintPoint = 290;
            int yPrintPoint = 650;
            // Checks if the winning Square is X
            if(marker.equals(TicTacToe.X_MARKER)) {
                // Redraws X Image on top
                g.drawImage(theImages[0], x, y, length, length, t);
                // Prints winning message at print point
                g.drawString("X WINS!", xPrintPoint, yPrintPoint);
            }
            // Checks if winning Square is O
            else if(marker.equals(TicTacToe.O_MARKER)) {
                // Redraws O Image on top
                g.drawImage(theImages[1], x, y, length, length, t);
                // Prints winning message at print point
                g.drawString("O WINS!", xPrintPoint, yPrintPoint);
            }
        }
    }

    public String toString() {
        return this.marker;
    }
}
