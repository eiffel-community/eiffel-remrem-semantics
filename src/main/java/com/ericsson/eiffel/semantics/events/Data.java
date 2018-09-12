package com.ericsson.eiffel.semantics.events;

import java.util.List;

public interface Data {
    
    /**
     * This method get the event custom data.
     * @return
     */
    public List<CustomData> getCustomData();

}
