// Sabrina Vohra
import javax.swing.JFrame;
import java.awt.*;
import javax.swing.ImageIcon;

public class TicTacToeViewer extends JFrame{
        // TODO: Complete this class
        private static final int WINDOW_HEIGHT = 700;
        private static final int WINDOW_WIDTH = 700;
        private static final int SIDE_LENGTH = 180;
        private static final int X_BUFFER = 40;
        private static final int Y_BUFFER = 60;
        private Square[][] board;
        private Image[] theImages;

    public TicTacToeViewer(Square[][] board) {
        this.setSize(WINDOW_HEIGHT, WINDOW_WIDTH);
        this.setTitle("TicTacToe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.board = board;
        theImages = new Image[2];
        theImages[0] = new ImageIcon("Resources/X.png").getImage();
        theImages[1] = new ImageIcon("Resources/O.png").getImage();
    }

    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0,0, WINDOW_WIDTH, WINDOW_HEIGHT);
        g.setColor(Color.black);
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                String print = i + "";
                g.drawString(print, (X_BUFFER) + (SIDE_LENGTH * i) + SIDE_LENGTH / 2, Y_BUFFER - 10);
                g.drawString(print, X_BUFFER / 2, Y_BUFFER + (SIDE_LENGTH * i) + SIDE_LENGTH / 2);
                board[i][j].drawSquare(g, X_BUFFER + (SIDE_LENGTH * i), Y_BUFFER + (SIDE_LENGTH * j), SIDE_LENGTH, theImages, this);
            }
        }
    }
}
