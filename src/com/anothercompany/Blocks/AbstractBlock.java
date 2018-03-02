package com.anothercompany.Blocks;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractBlock implements Block {
//    private final String id;
    private final Map<String, Block> neighbourMap = new HashMap<>();
    private static final String UP_STREAM = "UP";
    private static final String DOWN_STREAM = "DOWN";
    private static final String PLUS_POSITION = "PLUS";
    private static final String MINUS_POSITION = "MINUS";
    private static final String MAINLINE = "MAIN";
    private static final String CLEAR = "CLEAR";
    private static final String OCCUPIED = "OCCUPIED";
    private static final String LEFT = "LEFT";
    private static final String RIGHT = "RIGHT";

    private String status = CLEAR;
    private final String id;

    public AbstractBlock(final String name){
        if (name.trim().isEmpty()){
            throw new IllegalArgumentException("An error has occured");
        }
        this.id = name;
    }


    public String getName(){
        return id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Map getNeighbours() {
        return new HashMap(neighbourMap);
    }

    public static String getUpStream() {
        return UP_STREAM;
    }

    public static String getDownStream() {
        return DOWN_STREAM;
    }

    public static String getPlusPosition() {
        return PLUS_POSITION;
    }

    public static String getMinusPosition() {
        return MINUS_POSITION;
    }

    public static String getMAINLINE() {
        return MAINLINE;
    }

    public static String getCLEAR() {
        return CLEAR;
    }

    public static String getOCCUPIED() {
        return OCCUPIED;
    }

    @Override
    public String getStatus() {
        return status;
    }

    public boolean setStatus(final String setStatus){
          this.status = setStatus;
          return true;
    }
}
