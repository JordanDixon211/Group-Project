package com.anothercompany.Railway;

import com.anothercompany.Blocks.Block;
import com.anothercompany.Signal.Signal;
import com.anothercompany.Route.Route;

import java.util.List;
import java.util.Queue;

public interface Railway {
    public List<Block> getRailwayModel();
    public List<Block> currentStatusOfNodes();
    public void nextStep();
    public boolean startNewRoute(final Signal start, final Signal end);
    public boolean startRoute(Route route);
    public List<Route> activeRoutes();
    public Queue<Route> awaitingRoutes();

}
