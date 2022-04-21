package apiconfigs;

import java.util.HashMap;
import java.util.Map;

public class HeaderConfigs {

    public Map<String,String> defaultHeader(){
        Map<String,String> defaultHeaders = new HashMap<>();
        defaultHeaders.put("Content-Type","application/json");
        return defaultHeaders;
    }
}
