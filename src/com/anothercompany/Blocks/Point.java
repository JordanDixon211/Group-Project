package com.anothercompany.Blocks;
/**
 * this java file is the point
 * input value is a String id and a Map neighbourMap,
 *             in neighbourMap with 3 value means the point have 3 neighbour
 *             one is back and the other two are MINUS and PLUS
 * Return value is a Block neighbour
 *                 means that branch is no train there
 *                 if the return value is null, means some thing wrong in input value
 */

import java.util.Map;

public class Point extends AbstractBlock{
    private final static String MINUS = "MINUS";
    private final static String PLUS = "PLUS";
    private String pointStatus;
    private Map<String, Block> neighbourMap;

    public Point(String name) {
        super(name);
    }


    //部分返回值block， 更为sction更为合理 some of the return value is block, but change to sction is better
    public Block createPoint(Map<String, Block> neighbourMap, String signal) {
        if (neighbourMap.size() == 3) {
            this.neighbourMap = neighbourMap;
            if (signal.equals(MINUS) || signal.equals(PLUS)) {
                Block neighbour = neighbourMap.get(MINUS);
                String isTrain = isTrain(neighbour);
                if (isTrain.equals("CLEAR")) {
                    return neighbour;
                }
                neighbour = neighbourMap.get(PLUS);
                isTrain = isTrain(neighbour);
                if (isTrain.equals("CLEAR")) {
                    return neighbour;
                }
            }

        } else {
            System.out.println("neighbours number wrong");
            return null;
        }
        return null;

    }

    public String isTrain(Block block)
    {
        return block.getStatus();
    }

    @Override
    public Block getNeighbour(String positionn) {
        return null;
    }

    @Override
    public String getStatus() {
        return pointStatus;
    }


}
