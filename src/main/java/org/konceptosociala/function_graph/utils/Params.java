package org.konceptosociala.function_graph.utils;

import java.util.HashMap;

public class Params extends HashMap<String, Double> {
    public Params() {
        put("a", 4.23);
        put("b", 2.35);
        put("tMin", -15.0);
        put("tMax", 20.0);
        put("step", 0.1);
    }
}
