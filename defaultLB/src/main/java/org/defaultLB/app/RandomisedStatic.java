package org.defaultLB.app;

import org.onosproject.net.PortNumber;

import java.util.*;

public class RandomisedStatic implements PortingAlgorithm {
    Iterator<PortNumber> iterator;

    public RandomisedStatic() {
        iterator = null;
    }

    @Override
    public PortNumber out(Set<PortNumber> outPorts) {
        if (outPorts == null || outPorts.size() == 0) {
            return null;
        } else if (iterator == null || !iterator.hasNext()) {
            List<PortNumber> outPortsList = new ArrayList<PortNumber>();
            outPortsList.addAll(outPorts);
            Collections.shuffle(outPortsList);
            iterator = outPortsList.iterator();
        }
        return iterator.next();
    }
}