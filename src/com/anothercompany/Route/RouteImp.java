package com.anothercompany.Route;

import com.anothercompany.Blocks.Block;
import com.anothercompany.Blocks.Section;
import com.anothercompany.Railway.Railway;
import com.anothercompany.Lock.Lock;
import com.anothercompany.Signal.Signal;

import java.util.ArrayList;
import java.util.List;

public class RouteImp implements Route {
    private final Signal start;
    private final Signal end;
    private final List<Route> conflictsList = new ArrayList();
    private final String routeId;
    private static int id = 1;
    Lock lock = new Lock();

    public RouteImp(final Signal start, final Signal end, final Route routeList, final Railway model, final String direction){
        this.start = start;
        this.end = end;
        this.routeId = "R" + id;
        id = id + 1;

        Signal findStartSignal = null;
        int index = 0;



        //find a route from start to end using the current railway model.
        if (model != null){
            //go through the model and find a route from signal one to signal 2
            for (Block block: model.getRailwayModel()){
                if (block instanceof Section){
                    Section section = (Section) block;
                    if (section.equals(section.getS1().getName())){
                        findStartSignal = section.getS1();
                        break;
                    }else if (section.equals(section.getS2().getName())){
                        findStartSignal = section.getS2();
                        break;
                    }
                    index = index + 1;
                }
            }
            if (findStartSignal == null)
                throw new IllegalStateException("To define a route a start signal must exist!");

            int currentIndex = index;
            while (true){

            }

        }
    }

    @Override
    public String getRouteId() {
        return this.routeId;
    }

    @Override
    public String getstartSignalName() {
        return start.getName();
    }

    @Override
    public String getEndSignalName() {
        return end.getName();
    }

    public boolean addRoute(Route route){
        return conflictsList.add(route);
    }

    @Override
    public List<Route> conflictsList(List<Route> allRoutes) {
        return conflictsList;
    }

    @Override
    public List<Block> getPath() {
        return null;
    }

    @Override
    public Lock getRouteLockState() {
        return null;
    }
}
