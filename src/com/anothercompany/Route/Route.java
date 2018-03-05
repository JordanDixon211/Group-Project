package com.anothercompany.Route;

import com.anothercompany.Blocks.Block;
import com.anothercompany.Lock.Lock;

import java.util.List;

public interface Route {
    public String getRouteId();
    public String getstartSignalName();
    public String getEndSignalName();
    public List<Route> conflictsList(final List<Route> allRoutes);
    public List<Block> getPath();
    public Lock getRouteLockState();
}
