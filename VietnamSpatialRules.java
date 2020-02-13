package com.graphhopper.routing.util.spatialrules.countries;

import com.graphhopper.routing.profiles.Country;
import com.graphhopper.routing.profiles.RoadAccess;
import com.graphhopper.routing.util.spatialrules.DefaultSpatialRule;
import com.graphhopper.routing.util.spatialrules.TransportationMode;

public double getMaxSpeed(String highwayTag, double _default) {
    // As defined in: https://wiki.openstreetmap.org/wiki/OSM_tags_for_routing/Maxspeed#Motorcar
    switch (highwayTag) {
        case "motorway":
        case "trunk":
            return Integer.MAX_VALUE;
        case "residential":
            return 100;
        case "living_street":
            return 4;
        default:
            return super.getMaxSpeed(highwayTag, _default);