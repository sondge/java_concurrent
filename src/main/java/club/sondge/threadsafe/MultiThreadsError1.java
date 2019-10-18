package club.sondge.threadsafe;

import java.util.HashMap;
import java.util.Map;

public class MultiThreadsError1 {
    private Map<String,String> stateMap;

    public MultiThreadsError1() {
        stateMap = new HashMap<>();
        stateMap.put("1","周一");
        stateMap.put("2","周二");
        stateMap.put("3","周三");
        stateMap.put("4","周四");
    }

    public Map<String, String> getStateMap() {
        return stateMap;
    }

    public Map<String, String> copyStateMap() {
        return new HashMap<>(stateMap);
    }


    public static void main(String[] args) {
        MultiThreadsError1 multiThreadsError1 = new MultiThreadsError1();
//        System.out.println("1表示"+multiThreadsError1.getStateMap().get("1"));
//        multiThreadsError1.getStateMap().remove("1");
//        System.out.println("1表示"+multiThreadsError1.getStateMap().get("1"));
        System.out.println("1表示"+multiThreadsError1.copyStateMap().get("1"));
        multiThreadsError1.copyStateMap().remove("1");
        System.out.println("1表示"+multiThreadsError1.copyStateMap().get("1"));
    }
}
