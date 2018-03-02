package com.company.Blocks;


import java.util.Map;

public interface Node {
    public String getName();

    public Map getNeighbours();

    public boolean setNeighbour(final Node newnode, final String position);

    public int getNeighbourCount();

    public boolean setStatus(String setStatus);

    public String getStatus();
}