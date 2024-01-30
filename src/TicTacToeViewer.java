import javax.swing.JFrame;
public class TicTacToeViewer implements JFrame{
    // TODO: Complete this class
    private static final int WINDOW_HEIGHT = 800;
    private static final int WINDOW_WIDTH = 600;
    private static final int SIDE_LENGTH = 20;
    private static final int X_BUFFER = 40;
    private static final int Y_BUFFER = 50;

    public TicTacToeViewer() {
        this.setSize(WINDOW_HEIGHT, WINDOW_WIDTH);
        this.setTitle("TicTacToe");
        this.setDefaultCloseOperation("JFrame.EXIT_ON_CLOSE");
        this.setVisible(true);
    }
}
