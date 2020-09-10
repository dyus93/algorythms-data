package Recursion;

public class Main {
    private static int power(int a, int b){
        int result = 1;
        for (int i = 0; i < b; i++) {
            result *= a;
        }
        return result;
    }

    private static int powerRec(int a, int b){
        return (b == 0) ? 1 : powerRec(a, b - 1) * a;
    }

//

    private static int routes(int x, int y){
        if (x == 0 || y == 0)
            return 1;
        else
            return routes(x -1, y) + routes(x, y -1);
    }

// Chess knight(ход конем);

    private static int[][] kMoves ={
                    {-2, 1}, {-1, 2}, {1, 2}, {2, 1},
                    {2, -1}, {1, -2}, {-1, -2}, {-2, -1}
    };

    private static boolean isPossible(int[][] desk, int x, int y){
        return x >= 0 && x < desk.length &&
                y >= 0 && y < desk.length &&
                desk[x][y] == 0;
    }

    private static boolean knightMoves(int[][] desk, int currX, int currY, int move){
        desk[currX][currY] = move;
        if (move > desk.length * desk[0].length - 1) return true;

        int nextX, nextY;
        for (int i = 0; i < 7; i++){
            nextX = currX + kMoves[i][0];
            nextY = currY + kMoves[i][1];
            if (isPossible(desk, nextX, nextY) &&
                knightMoves(desk, nextX, nextY, move + 1))
                    return true;
        }
        desk[currX][currY] = 0;
        return false;
    }

    private static void printDesk(int[][] desk){
        for (int i = 0; i < desk.length; i++){
            for (int j = 0; j < desk[0].length ; j++){
            System.out.printf("%3d", desk[i][j]);
            }
            System.out.println();
        }
    }

    //  8 queens

    private static int[][] board = new int[8][8];
    private static void printBoard(){
        for(int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean checkQueen(int x, int y){
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if (board[i][j] != 0)
                    if (!(i == x && j == y)){
                        if (i - x == 0 || j - y == 0) return false;
                        if (Math.abs(i - x) == Math.abs(j - y)) return false;
                    }
            }
        }
        return true;
    }

    private static boolean checkBoard(){
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++) {
                if (board[i][j] != 0)
                    if (!checkQueen(i, j))
                        return false;
            }
        }
        return true;
    }

    private static boolean queens(int n){
        if (!checkBoard()) return false;
        if (n == 9) return true;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 0){
                    board[i][j] = n;
                    if (queens(n + 1))
                        return true;
                    board[i][j] = 0;
                }
            }
        }
        return false;
    }

    //  hanoi tower

    private static int operations = 0;
    private static void put(int from, int to){
        System.out.printf("%d -> %d | ", from, to);
        if (++operations % 10 == 0)
            System.out.print('\n');
    }

    private static void tower(int height, int from, int to){
        int temp = from ^ to;
        if (height == 1){
            put(from, to);
        }else {
            tower(height - 1, from, temp);
            put(from, to);
            tower(height - 1, temp, to);
        }
    }

    public static void main(String[] args) {
        int[][] desk = new int[8][8];
        knightMoves(desk, 1, 0, 1);
        printDesk(desk);
        queens(1);
        printBoard();
        tower(5, 1, 3);
        System.out.println("\noperations: " + operations);
    }
}
