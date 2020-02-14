package com.graphhopper.routing.util.spatialrules.countries;

import com.graphhopper.routing.profiles.Country;
import com.graphhopper.routing.profiles.RoadAccess;
import com.graphhopper.routing.util.spatialrules.DefaultSpatialRule;
import com.graphhopper.routing.util.spatialrules.TransportationMode;

public class VietnamSpatialRule extends DefaultSpatialRule {

public double getMaxSpeed(String highwayTag, double _default) {
    // As defined in: https://wiki.openstreetmap.org/wiki/OSM_tags_for_routing/Maxspeed#Motorcar
    switch (highwayTag) {
        case "motorway":
            return 120;
        case "residential":
            return 80;
        case "tertiary":
            return 60;
         case"secondary":
            return 50;
        default:
            return super.getMaxSpeed(highwayTag, _default);
    }
}
     @Override
  public RoadAccess getAccess(String highwayTag, TransportationMode transportationMode, RoadAccess _default) {
        if (transportationMode == TransportationMode.MOTOR_VEHICLE) {
            if (highwayTag.equals("motorway"))
                return RoadAccess.DESTINATION;
        }
        if(transportationMode == TransportationMode.BIYCLE){
            if(hightwayTag.equals("motoway"))
                return RoadAccess.NO;
        }

        return super.getAccess(highwayTag, transportationMode, _default);
    }
   @Override
    public String getId() {
        throw new UnsupportedOperationException("No id for the DefaultSpatialRule");
    }
}
