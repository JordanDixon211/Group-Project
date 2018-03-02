package com.company.Blocks;

import java.util.List;

public final class Block extends AbstractNode {
    public String lineStatus;
    public final static String IN_USE = "IN USE";
    public final static String NOT_IN_USE = "NOT IN USE";

    public Block(String name, List<Node> listOfNeighbours) {
        super(name, listOfNeighbours);
        this.lineStatus = NOT_IN_USE;
    }

    @Override
    public boolean setStatus(String setStatus) {
        if (super.getLock().getLockStatus().equals("Locked"))
            return false;

        String toUpper = setStatus.toUpperCase().trim();

        if (toUpper.equals(IN_USE) || toUpper.equals(NOT_IN_USE)){
            this.lineStatus = toUpper;
            return true;
        }

        return false;
    }

    @Override
    public String getStatus() {
        return lineStatus;
    }

}
