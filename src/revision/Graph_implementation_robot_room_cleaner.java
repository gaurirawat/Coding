package revision;

import javafx.util.Pair;
import java.util.*;

public class Graph_implementation_robot_room_cleaner {
    HashSet<String> visited;

    public void cleanRoom(Robot robot) {
        visited = new HashSet<String>();
        cleanInner(robot, 0, 0, 0);
    }

    public void cleanInner(Robot robot, int i, int j, int d) {
        visited.add(i + "-" + j);
        robot.clean();

        int[][] dir = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for(int k = 0; k < 4; ++k) {
            int newd = (d + k) % 4;
            int newi = i + dir[newd][0];
            int newj = j + dir[newd][1];
            String newS = newi + "-" + newj;
            if(!visited.contains(newS) && robot.move()) {
                cleanInner(robot, newi, newj, newd);
                resetToCurrDir(robot);
            }
            robot.turnRight();
        }
    }

    public void resetToCurrDir(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

    interface Robot {
        public boolean move();
        public void turnLeft();
        public void turnRight();
        public void clean();
    }
}
