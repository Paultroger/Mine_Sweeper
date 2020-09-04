import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

/* Georg: call class MineSweeperUserPlayBoard.java .
This class generates a new Game. */
public class MineSweeperBoard {
    
    private int height, width, difficulty;
    private int[][] backEnd;
    private char[][] tableTop; 

    public MineSweeperUserBoard(int height, int width, int difficulty) {
        this.height = height;
        this.width = width;
        this.difficulty = difficulty;
        /* Keyword "this" indicates, that we are dealing
        with an instance variable. */
        this.backEnd = new int[height][width];
        this.tableTop = new char[height][width];
        initializeTableTop();
        placeBomb(); 
    }
    
    public void initializeTableTop() {
        for (int i = 0; i < height; i++) {
            Arrays.fill(tableTop[i], 'x');
        }
    }
    
    // This method returns a String containing the Table Top.    
    public String displayTableTop() {
        StringBuilder sb = new StringBuilder().append("    ");
        String text = "";
        for (int i = 0; i < width; i++) {
            sb.append(i+1).append("   ");
        }
        sb.append("\n");
        for (int j = 0; j < height; j ++) {
            sb.append(j+1).append("   ");
            // If the number has to digit, one space character is removed.
            if (j > 8)
                sb.delete(3 , 4);
            for (char value : tableTop[j]) {
                sb.append(value).append("   ");
            }
            text = text + "\n" + sb.toString();
            sb.setLength(0);
        }
        return text;
    }

    // This method returns a String containing the back end. Main purpose is testing.
    public String displayBackEnd() {
        StringBuilder sb = new StringBuilder();
        String text = "";
        for (int i = 0; i < height; i ++) {
            sb.append("   ");
            for (int value : backEnd[i]) {
                sb.append(value).append("   ");
            }
            text = text + "\n" + sb.toString();
            sb.setLength(0);
        }
        return text;
    }
    
    /* Initializes the BackEnd with a sufficient number of bombs.
    This method should return a String array at some point. */
    public void placeBomb() {
        int i = 0;
        while (i < difficulty) {
            Random rand = new Random();
            int y = rand.nextInt(height);
            int x = rand.nextInt(width);
            if (backEnd[y][x] == 0) { 
                backEnd[y][x] = 1;
                i++;
            }
        }
    }

    public void changeChar(int y, int x, char symbol){
        switch (symbol) {
            case 'B':   if (tableTop[y][x] == 'B')
                        tableTop[y][x] = 'x';
                else
                        tableTop[y][x] = 'B';
                break;
            case 'i':   tableTop[y][x] = inspectCell(y , x);
                        break;
            default:    break;
        }
    }

    // This method inspects a cell.
    public char inspectCell(int y, int x) {
        return (char)(scan(y , x) + '0');
    }

    // This method counts the bombs in the neighbouring cells.
    public int scan(int y, int x) {
        int[][] bombRadar = new int[][]{
            { y-1 , x-1 },
            { y-1 , x },
            { y-1 , x+1 },
            { y , x-1 },
            { y , x+1 },
            { y+1 , x-1 },
            { y+1 , x },
            { y+1 , x+1 },
        };
        int sum = 0;
        for (int[] subIntList : bombRadar) {
            sum = sum + count(subIntList);
        }

        return sum;
    }

    // This method actually detects wheter a given cell has a bomb or not.
    public int count(int[] xrp) {
        if (xrp[0] < 0 || xrp[0] > 8 || xrp[1] < 0 || xrp[1] > 8)
            return 0;
        else {
            return backEnd[xrp[0]][xrp[1]];
        }
    }
    
    // This method count's the empty = not inspected AND not marked cells.
    public boolean gameOver() {
        int cells = 0;
        for (char[] subIntList : tableTop) {
            for (char testChar : subIntList) {
                if (testChar == 'x')
                    cells++;
            }
        }
    return cells == 0;
    }
}