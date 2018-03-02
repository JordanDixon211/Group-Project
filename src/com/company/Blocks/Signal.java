package com.company.Blocks;

import java.util.List;

public final class Signal extends AbstractNode {
    private final static String STOP = "STOP";
    private final static String CLEAR = "CLEAR";
    private final static String UP = "UP";
    private final static String DOWN = "DOWN";
    //Starts off as all signs are clear/ready for use.
    private String currentStatus = CLEAR;
    private final String directon;

    public Signal(String name, List<Node> listOfNeighbours, String directon) {
        super(name, listOfNeighbours);
        if (directon == null || directon.isEmpty()){
            throw new IllegalArgumentException("please supply correct arguments for direction");
        }

        if (directon.toUpperCase().equals(UP) || directon.toUpperCase().equals(DOWN))
            this.directon = directon;
        else
            throw new IllegalArgumentException("please supply correct names for direction: either UP or DOWN");
    }

    @Override
    public boolean setStatus(final String newStatus) {
        if (super.getLock().getLockStatus().equals("Locked"))
            return false;

        String upper = newStatus.toUpperCase();
        if (upper.equals(STOP) || upper.equals(CLEAR)){
            this.currentStatus = upper;
            return true;
        }
        return false;
    }

    @Override
    public String getStatus() {
        return currentStatus;
    }

    public String getDirection(){
        return directon;
    }
}
