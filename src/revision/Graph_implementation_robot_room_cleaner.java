package revision;

import javafx.util.Pair;
import java.util.*;

public class Graph_implementation_robot_room_cleaner {
    public void cleanRoom(Robot robot) {
        HashSet<String> visited = new HashSet<String>();
        int[][]dir = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        cleanInner(0, 0, 0, robot, visited, dir);
    }

    public void cleanInner(int i, int j, int d, Robot robot, HashSet<String> visited, int[][]dir) {
        visited.add(i + "*" + j);
        robot.clean();

        for (int k = 0; k < 4; ++k) {
            int newd = (d + k) % 4;
            int newi = i + dir[newd][0];
            int newj = j + dir[newd][1];
            String next = newi + "*" + newj;
            if (!visited.contains(next) && robot.move()) {
                cleanInner(newi, newj, newd, robot, visited, dir);
                robot.turnLeft();
            } else {
                robot.turnRight();
            }
        }
        robot.turnLeft();
        robot.turnLeft();
        robot.move();
    }

    interface Robot {
        public boolean move();
        public void turnLeft();
        public void turnRight();
        public void clean();
    }
}
