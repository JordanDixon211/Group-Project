package com.company.Blocks;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractNode implements Node {
    private final String name;
    private final Map<String, Node> neighbourMap = new HashMap<>();
    private static final String LEFT_NODE = "LEFT";
    private static final String RIGHT_NODE = "RIGHT";
    private static final String OTHER_NODE = "OTHER NODE";
    //can tell if its a path or not easily.
    private final int neighbourCount;
    private final Lock lockStatus = new Lock();

    public AbstractNode(final String name, final List<Node> listOfNeighbours){
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Please supply a name");
        }

        if (listOfNeighbours.size() < 1){
            throw new IllegalArgumentException("a node must have at least one neighbour!");
        }

        this.name = name;
        if (listOfNeighbours.size() == 2){
            neighbourMap.put(LEFT_NODE, listOfNeighbours.get(0));
            neighbourMap.put(RIGHT_NODE, listOfNeighbours.get(1));
            neighbourMap.put(OTHER_NODE, null);
            this.neighbourCount = 2;
        }else if(listOfNeighbours.size() == 3){
            neighbourMap.put(LEFT_NODE, listOfNeighbours.get(0));
            neighbourMap.put(RIGHT_NODE, listOfNeighbours.get(1));
            neighbourMap.put(OTHER_NODE,  listOfNeighbours.get(2));
            this.neighbourCount = 3;
        }else{
            neighbourMap.put(LEFT_NODE, listOfNeighbours.get(0));
            neighbourMap.put(RIGHT_NODE, listOfNeighbours.get(1));
            neighbourMap.put(OTHER_NODE,  listOfNeighbours.get(2));
            this.neighbourCount = 1;
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Map getNeighbours() {
        return neighbourMap ;
    }

    @Override
    public boolean setNeighbour(Node newnode, String position) {
        if (neighbourMap.containsKey(position)) {
            neighbourMap.put(position, newnode);
            return true;
        }

        return false;
    }

    @Override
    public int getNeighbourCount() {
        return neighbourCount;
    }



    public Lock getLock(){
        return lockStatus;
    }

}
