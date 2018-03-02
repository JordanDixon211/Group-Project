package com.company.Railway;

import com.company.Blocks.Node;
import com.company.Blocks.Signal;
import com.company.Route.Route;

import java.util.List;
import java.util.Queue;

public interface Railway {
    public List<Node> getRailwayModel();
    public List<Node> currentStatusOfNodes();
    public void nextStep();
    public boolean startNewRoute(final Signal start,final Signal end);
    public boolean startRoute(Route route);
    public List<Route> activeRoutes();
    public Queue<Route> awaitingRoutes();

}
