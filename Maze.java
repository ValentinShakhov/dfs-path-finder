public class Maze {

    public static void main(String[] args) {
        int result = numSteps(0, 0, new int[][]{{0, 1, 0, 0},
                                                            {0, 0, 0, 1},
                                                            {0, 1, 0, 3},
                                                            {0, 1, 0, 1},
                                                            {0, 1, 0, 1},
                                                            {0, 0, 0, 0}}, 0);
        System.out.println(result);
    }

    private static int numSteps(final int curX, final int curY, final int[][] maze, final int numSteps) {
        print(maze, curX, curY);

        if (maze[curY][curX] == 3) {
            System.out.println(numSteps);
        }

        setVisited(curX, curY, maze);

        final int northY = curY - 1;
        if (canGoNorth(curX, northY, maze)) {
            numSteps(curX, northY, maze, numSteps + 1);
        }

        final int eastX = curX + 1;
        if (canGoEast(eastX, curY, maze)) {
            numSteps(eastX, curY, maze, numSteps + 1);
        }

        final int southY = curY + 1;
        if (canGoSouth(curX, southY, maze)) {
            numSteps(curX, southY, maze, numSteps + 1);
        }

        final int westX = curX - 1;
        if (canGoWest(westX, curY, maze)) {
            numSteps(westX, curY, maze, numSteps + 1);
        }

        setUnVisited(curX, curY, maze);

        return 0;
    }

    private static void print(final int[][] maze, final int curX, final int curY) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (i == curY && j == curX) {
                    System.out.print("# ");
                } else if (maze[i][j] == 2) {
                    System.out.print("* ");
                } else {
                    System.out.print(maze[i][j] + " ");
                }
            }
            System.out.println("");
        }
        System.out.println("");
    }

    private static void setVisited(final int x, final int y, final int[][] maze) {
        if (maze[y][x] == 3) {
            maze[y][x] = 4;
        } else {
            maze[y][x] = 2;
        }
    }

    private static void setUnVisited(final int x, final int y, final int[][] maze) {
        if (maze[y][x] == 4) {
            maze[y][x] = 3;
        } else {
            maze[y][x] = 0;
        }
    }

    private static boolean canGoNorth(final int curX, final int northY, final int[][] maze) {
        return northY >= 0 && maze[northY][curX] != 1 && maze[northY][curX] != 2;
    }

    private static boolean canGoEast(final int eastX, final int curY, final int[][] maze) {
        return eastX != maze[curY].length && maze[curY][eastX] != 1 && maze[curY][eastX] != 2;
    }

    private static boolean canGoSouth(final int curX, final int southY, final int[][] maze) {
        return southY != maze.length && maze[southY][curX] != 1 && maze[southY][curX] != 2;
    }

    private static boolean canGoWest(final int westX, final int curY, final int[][] maze) {
        return westX >= 0 && maze[curY][westX] != 1 && maze[curY][westX] != 2;
    }
}
