package com.andi.nms.business.constant;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class BusinessConstant {
    public static Map<Integer,String> AUTHORITY_MAP = Collections.synchronizedMap(new HashMap<Integer,String>());

    static {
        AUTHORITY_MAP.put(1,"view");
        AUTHORITY_MAP.put(2,"update");
        AUTHORITY_MAP.put(4,"del");
        AUTHORITY_MAP.put(8,"add");
    }
}
