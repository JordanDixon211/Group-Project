package com.company.Blocks;

import java.util.List;

public final class Point extends AbstractNode{
    private final static String MINUS = "MINUS";
    private final static String PLUS = "PLUS";
    private String pointStatus;

    public Point(String name, List<Node> listOfNeighbours) {
        super(name, listOfNeighbours);
        pointStatus = "Plus";
    }

    @Override
    public boolean setStatus(String setStatus) {
        if (super.getLock().getLockStatus().equals("Locked"))
            return false;

        String toUpper = setStatus.toUpperCase().trim();

        if (toUpper.equals(MINUS) || toUpper.equals(PLUS)){
            this.pointStatus = toUpper;
            return true;
        }

        return false;
    }


    @Override
    public String getStatus() {
        return pointStatus;
    }

}
