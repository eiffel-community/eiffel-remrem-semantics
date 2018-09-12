
package com.ericsson.eiffel.semantics.events;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Security {

    @SerializedName("sdm")
    @Expose
    private Sdm sdm;

    public Sdm getSdm() {
        return sdm;
    }

    public void setSdm(Sdm sdm) {
        this.sdm = sdm;
    }

}
