package com.anothercompany.Blocks;

import java.util.Map;

public interface Block {
    public String getId();
    public Map getNeighbours();
    public Block getNeighbour(final String positionn);
    public String getStatus();
    public boolean setStatus(final String setStatus);
    public String getName();
}
