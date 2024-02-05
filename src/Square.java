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
    public void drawSquare(Graphics g, int xBuffer, int yBuffer, int length, Image[] theImages, TicTacToeViewer t) {
        g.setColor(Color.black);
        g.drawRect(xBuffer, yBuffer, length, length);
        if(marker.equals("0")) {
            g.drawImage(theImages[0], xBuffer, yBuffer, t);
        }
        else if(marker.equals("X")) {
            g.drawImage(theImages[1], xBuffer, yBuffer, t);
        }
        if(isWinningSquare) {
            g.setColor(Color.green);
            g.fillRect(xBuffer, yBuffer, length, length);
        }
    }

    public String toString() {
        return this.marker;
    }
}
