package revision;

import java.util.*;

//https://leetcode.com/problems/employee-importance/submissions/
public class Graph_lc_employee_importance {
    public int getImportance(List<Employee> emp, int id) {
        HashSet<Integer> visited = new HashSet<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < emp.size(); ++i) {
            map.put(emp.get(i).id, i);
        }
        int c = exploreDFS(emp, id, visited, map);
        return c;
    }

    public int exploreDFS(List<Employee> emp, int id, HashSet<Integer> visited, HashMap<Integer, Integer> map) {
        if (map.get(id) == null || visited.contains(id)) {
            return 0;
        }
        Employee employee = emp.get(map.get(id));
        visited.add(id);
        int c = employee.importance;
        for (int x : employee.subordinates) {
            c += exploreDFS(emp, x, visited, map);
        }
        return c;
    }

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
}
