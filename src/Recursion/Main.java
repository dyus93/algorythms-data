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

    public static void main(String[] args) {
        int[][] desk = new int[8][8];
        knightMoves(desk, 1, 0, 1);
        printDesk(desk);
    }
}
