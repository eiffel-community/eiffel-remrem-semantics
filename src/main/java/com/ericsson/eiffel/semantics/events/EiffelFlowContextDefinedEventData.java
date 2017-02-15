
package com.ericsson.eiffel.semantics.events;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EiffelFlowContextDefinedEventData {

    @SerializedName("product")
    @Expose
    private String product;
    @SerializedName("project")
    @Expose
    private String project;
    @SerializedName("program")
    @Expose
    private String program;
    @SerializedName("track")
    @Expose
    private String track;
    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("customData")
    @Expose
    private List<CustomData> customData = new ArrayList<CustomData>();

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<CustomData> getCustomData() {
        return customData;
    }

    public void setCustomData(List<CustomData> customData) {
        this.customData = customData;
    }

}
