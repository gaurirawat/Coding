package revision;

import java.util.HashMap;
//https://leetcode.com/problems/logger-rate-limiter/submissions/
public class Implementation_lc_logger_rate_limiter {
    class Logger {
        HashMap<String, Integer> map;
        /** Initialize your data structure here. */
        public Logger() {
            map = new HashMap<String, Integer>();
        }

        /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
         If this method returns false, the message will not be printed.
         The timestamp is in seconds granularity. */
        public boolean shouldPrintMessage(int timestamp, String message) {
            if(map.get(message) == null || map.get(message) + 10 <= timestamp) {
                map.put(message, timestamp);
                return true;
            }
            return false;
        }
    }
}
