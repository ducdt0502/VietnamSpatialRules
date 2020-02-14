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
            return 100;
        case "tertiary":
            return ;
         case"secondary":
            return ;
        default:
            return super.getMaxSpeed(highwayTag, _default);
    }
}
     @Override
    public RoadAccess getAccess(String highwayTag, TransportationMode transportationMode, RoadAccess _default) {
        if (transportationMode == TransportationMode.MOTOR_VEHICLE) {
            if (highwayTag.equals("motoway"))
                return RoadAccess.DESTINATION;
        if( transportationMode == TransportationMode.BICYCLE){
            if(highwayTag.equals("motoway))
                return RoadAccess.NO; 
        }
        
                                 }
        return super.getAccess(highwayTag, transportationMode, _default);
    }

    @Override
    public String getId() {
        return Country.DEU.toString();
    }
}
}
