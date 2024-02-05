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
    public void drawSquare(Graphics g, int x, int y, int length, Image[] theImages, TicTacToeViewer t) {
        g.setColor(Color.black);
        g.drawRect(x, y, length, length);
        if(marker.equals(TicTacToe.X_MARKER)) {
            g.drawImage(theImages[0], x, y, length, length, t);
        }
        if(marker.equals(TicTacToe.O_MARKER)) {
            g.drawImage(theImages[1], x, y, length, length, t);
        }
        if(isWinningSquare) {
            g.setColor(Color.green);
            g.fillRect(x, y, length, length);
            g.setColor(Color.black);
            int xPrintPoint = 290;
            int yPrintPoint = 650;
            if(marker.equals(TicTacToe.X_MARKER)) {
                g.drawImage(theImages[0], x, y, length, length, t);
                g.drawString("X WINS!", xPrintPoint, yPrintPoint);
            }
            else if(marker.equals(TicTacToe.O_MARKER)) {
                g.drawImage(theImages[1], x, y, length, length, t);
                g.drawString("O WINS!", xPrintPoint, yPrintPoint);
            }
        }
    }

    public String toString() {
        return this.marker;
    }
}
