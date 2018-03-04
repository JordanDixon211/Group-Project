package com.anothercompany.Signal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Signal {
    private final static Map<String, Signal>  objectMap = new HashMap<>();
    private String status = CLEAR;
    private final String name;
    private String accessDirection;
    private static int id = 1;
    private final static String STOP = "STOP";
    private final static String CLEAR = "CLEAR";

    Signal(String accessDirection){
        if (accessDirection.toLowerCase().equals("up"))
            this.accessDirection = "Up";

        if (accessDirection.toLowerCase().equals("down"))
            this.accessDirection = "Down";

        this.name = "S" + id;
        id += 1;
    }

    public static Signal createSignal(final String accessDirection){
        Signal s = new Signal(accessDirection);
        objectMap.put(s.getName(), s);

        return objectMap.get(s.getName());
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (status.toLowerCase().equals(STOP))
            this.status = STOP;

        if (status.toLowerCase().equals(CLEAR))
            this.status = CLEAR;
    }

    public static Map<String, Signal> getObjectMap() {
        return objectMap;
    }

    public String getName() {
        return name;
    }

    public String getAccessDirection() {
        return accessDirection;
    }

    public static int getId() {
        return id;
    }

    public String toString(){
        return "Signal Name: " + this.getName() + " Access Direction: " + this.getAccessDirection() + " State: " + this.getStatus();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Signal signal = (Signal) o;
        return Objects.equals(name, signal.name);
    }

    @Override
    public int hashCode() {
        int hc = 57;
        return Objects.hash(name) * hc;
    }
}
