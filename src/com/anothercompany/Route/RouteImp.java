package com.anothercompany.Route;

import com.anothercompany.Blocks.Block;
import com.anothercompany.Blocks.Point;
import com.anothercompany.Blocks.Section;
import com.anothercompany.Railway.Railway;
import com.anothercompany.Lock.Lock;
import com.anothercompany.Signal.Signal;

import javax.xml.soap.Node;
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
        Signal findEndSignal = null;
        List<Block> theRoute = new ArrayList<>();
        List<Block> railwayModel = model.getRailwayModel();
        //find a route from start to end using the current railway model.
        if (railwayModel != null) {
            //go through the model and find a route from signal one to signal 2
            if (direction.toLowerCase().equals("up")) {
                //get current block we are at, can be either a section or a point, when we are at a point we check both minus and
                //plus positions if our block is not found we then go past those.
                //once a route is found, traverse backwards to then try solve how to protect
                //our route.
                for (int i = 0; i < railwayModel.size(); i++) {
                    Block block = railwayModel.get(i);

                    if (block instanceof Section) {
                        boolean changed = false;
                        Section section = (Section) block;
                        if (section.getS1().equals(start)) {
                            findStartSignal = section.getS1();
                            changed = true;
                        } else if (section.getS2().equals(start)) {
                            findStartSignal = section.getS2();
                            changed = true;
                        }

                        if (!changed){
                            if (section.getS1().equals(end)) {
                                findEndSignal = section.getS1();
                            } else if (section.getS2().equals(end)) {
                                findEndSignal = section.getS2();
                            }
                        }
                    } else if (block instanceof Point) {
                        //now check both directions, check what is on the minus side of the current path.
                        //then check what is on the positive side.
                        boolean changed = false;
                        int staticI = i + 3;
                        for (int j = i + 1; i < staticI ; i++){
                            Section nextBlock = (Section) railwayModel.get(j);
                            if (nextBlock.getPosition().equals("Minus")
                                    && nextBlock.getS1().equals(start) && nextBlock.getS1().getAccessDirection().equals("Up")){
                                findStartSignal = nextBlock.getS1();
                                changed = true;
                            }

                            else if (nextBlock.getPosition().equals("Minus")
                                    && nextBlock.getS1().equals(start) && nextBlock.getS2().getAccessDirection().equals("Up")){
                                findStartSignal = nextBlock.getS1();
                                changed = true;
                            }

                            else if (nextBlock.getPosition().equals("Plus")
                                    && nextBlock.getS1().equals(start) && nextBlock.getS1().getAccessDirection().equals("Up")){
                                findStartSignal = nextBlock.getS1();
                                changed = true;
                            }

                            else if (nextBlock.getPosition().equals("Plus")
                                    && nextBlock.getS1().equals(start) && nextBlock.getS2().getAccessDirection().equals("Up")){
                                findStartSignal = nextBlock.getS1();
                                changed = true;
                            }

                            if (!changed){
                                if (nextBlock.getPosition().equals("Minus")
                                        && nextBlock.getS1().equals(end) && nextBlock.getS1().getAccessDirection().equals("Up")){
                                    findEndSignal = nextBlock.getS1();
                                }

                                else if (nextBlock.getPosition().equals("Minus")
                                        && nextBlock.getS1().equals(end) && nextBlock.getS2().getAccessDirection().equals("Up")){
                                    findEndSignal = nextBlock.getS1();
                                }

                                else if (nextBlock.getPosition().equals("Plus")
                                        && nextBlock.getS1().equals(end) && nextBlock.getS1().getAccessDirection().equals("Up")){
                                    findEndSignal = nextBlock.getS1();
                                }

                                else if (nextBlock.getPosition().equals("Plus")
                                        && nextBlock.getS1().equals(end) && nextBlock.getS2().getAccessDirection().equals("Up")){
                                    findEndSignal = nextBlock.getS1();
                                }
                            }
                        }
                    }
                }
                if (findStartSignal == null)
                    throw new IllegalStateException("To define a route a start signal must exist!");


            }else if (direction.toLowerCase().equals("down")){

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
