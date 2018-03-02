package com.company.Route;

import com.company.Blocks.Node;
import com.company.Blocks.Signal;
import com.company.Blocks.Lock;

import java.util.List;

public interface Route {
    public int getRouteId();
    public String getstartSignalName();
    public String getEndSignalName();
    public boolean setRoute(final Signal start, final Signal destination);
    public List<Route> conflictsList(final List<Route> allRoutes);
    public List<Node> getPath();
    public Lock getRouteLockState();
}
