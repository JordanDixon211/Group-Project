package com.anothercompany.Blocks;
import com.anothercompany.Signal.Signal;

import java.awt.*;
import java.util.Map;

public class Section extends AbstractBlock {
    private Signal s1;
    private Signal s2;
    private Section down;
    private Section up;

    public Section(final String name,final Section down,final Section up) {
        super(name);

        if (down != null){
            Signal s1 = Signal.createSignal("Down");
            this.s1 = s1;
        }

        if (up != null){
            Signal s2 =  Signal.createSignal("Up");
            this.s2 = s2;
        }
        this.down = down;
        this.up = up;
    }

    @Override
    public Block getNeighbour(String positionn) {
        if (positionn.toLowerCase().trim().equals("left"))
            return down;

        if (positionn.toLowerCase().trim().equals("right"))
            return up;

        return null;
    }

    public boolean setUpNeightbour(final Section up){
        this.up = up;
        Signal s2 =  Signal.createSignal("Up");
        this.s2 = s2;
        return this.up == up;
    }

    public boolean setDownNeightbour(final Section down){
        this.down = down;
        Signal s1 =  Signal.createSignal("Down");
        this.s1 = s1;
        return this.down == down;
    }

    public String toString(){
        return "Section: " + this.getId() + " Status: " + this.getStatus();
    }

    public Signal getS1() {
        return s1;
    }

    public Signal getS2() {
        return s2;
    }

    public Section getDown() {
        return down;
    }

    public Section getUp() {
        return up;
    }

}
