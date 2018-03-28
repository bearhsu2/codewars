package idv.kuma._5kyu.int32_to_ipv4;

import java.util.ArrayList;
import java.util.List;

public class Kata {
    public static String longToIP(long ip) {

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add(0, "" + (ip % 256));
            ip /= 256;
        }

        return String.join(".", list);
    }
}
