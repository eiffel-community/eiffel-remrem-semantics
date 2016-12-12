
package com.ericsson.eiffel.remrem.semantics.events;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Change {

    /**
     * 
     */
    @SerializedName("insertions")
    @Expose
    private Integer insertions;
    /**
     * 
     */
    @SerializedName("deletions")
    @Expose
    private Integer deletions;
    /**
     * 
     */
    @SerializedName("files")
    @Expose
    private String files;
    /**
     * 
     */
    @SerializedName("details")
    @Expose
    private String details;
    /**
     * 
     */
    @SerializedName("tracker")
    @Expose
    private String tracker;
    /**
     * 
     */
    @SerializedName("id")
    @Expose
    private String id;

    /**
     * 
     * @return
     *     The insertions
     */
    public Integer getInsertions() {
        return insertions;
    }

    /**
     * 
     * @param insertions
     *     The insertions
     */
    public void setInsertions(Integer insertions) {
        this.insertions = insertions;
    }

    /**
     * 
     * @return
     *     The deletions
     */
    public Integer getDeletions() {
        return deletions;
    }

    /**
     * 
     * @param deletions
     *     The deletions
     */
    public void setDeletions(Integer deletions) {
        this.deletions = deletions;
    }

    /**
     * 
     * @return
     *     The files
     */
    public String getFiles() {
        return files;
    }

    /**
     * 
     * @param files
     *     The files
     */
    public void setFiles(String files) {
        this.files = files;
    }

    /**
     * 
     * @return
     *     The details
     */
    public String getDetails() {
        return details;
    }

    /**
     * 
     * @param details
     *     The details
     */
    public void setDetails(String details) {
        this.details = details;
    }

    /**
     * 
     * @return
     *     The tracker
     */
    public String getTracker() {
        return tracker;
    }

    /**
     * 
     * @param tracker
     *     The tracker
     */
    public void setTracker(String tracker) {
        this.tracker = tracker;
    }

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

}
