
package com.ericsson.eiffel.remrem.semantics.events;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FlowContextDefinedData {

    /**
     * 
     */
    @SerializedName("product")
    @Expose
    private String product;
    /**
     * 
     */
    @SerializedName("project")
    @Expose
    private String project;
    /**
     * 
     */
    @SerializedName("program")
    @Expose
    private String program;
    /**
     * 
     */
    @SerializedName("track")
    @Expose
    private String track;
    /**
     * 
     */
    @SerializedName("version")
    @Expose
    private String version;
    /**
     * 
     */
    @SerializedName("customData")
    @Expose
    private List<CustomData> customData = new ArrayList<CustomData>();

    /**
     * 
     * @return
     *     The product
     */
    public String getProduct() {
        return product;
    }

    /**
     * 
     * @param product
     *     The product
     */
    public void setProduct(String product) {
        this.product = product;
    }

    /**
     * 
     * @return
     *     The project
     */
    public String getProject() {
        return project;
    }

    /**
     * 
     * @param project
     *     The project
     */
    public void setProject(String project) {
        this.project = project;
    }

    /**
     * 
     * @return
     *     The program
     */
    public String getProgram() {
        return program;
    }

    /**
     * 
     * @param program
     *     The program
     */
    public void setProgram(String program) {
        this.program = program;
    }

    /**
     * 
     * @return
     *     The track
     */
    public String getTrack() {
        return track;
    }

    /**
     * 
     * @param track
     *     The track
     */
    public void setTrack(String track) {
        this.track = track;
    }

    /**
     * 
     * @return
     *     The version
     */
    public String getVersion() {
        return version;
    }

    /**
     * 
     * @param version
     *     The version
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * 
     * @return
     *     The customData
     */
    public List<CustomData> getCustomData() {
        return customData;
    }

    /**
     * 
     * @param customData
     *     The customData
     */
    public void setCustomData(List<CustomData> customData) {
        this.customData = customData;
    }

}
