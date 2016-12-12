
package com.ericsson.eiffel.remrem.semantics.events;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EiffelTestSuiteStartedEvent
    extends Event
{

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("meta")
    @Expose
    private Meta meta;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("data")
    @Expose
    private TestSuiteStartedData data;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("links")
    @Expose
    private List<Link> links = new ArrayList<Link>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The meta
     */
    public Meta getMeta() {
        return meta;
    }

    /**
     * 
     * (Required)
     * 
     * @param meta
     *     The meta
     */
    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The data
     */
    public TestSuiteStartedData getData() {
        return data;
    }

    /**
     * 
     * (Required)
     * 
     * @param data
     *     The data
     */
    public void setData(TestSuiteStartedData data) {
        this.data = data;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The links
     */
    public List<Link> getLinks() {
        return links;
    }

    /**
     * 
     * (Required)
     * 
     * @param links
     *     The links
     */
    public void setLinks(List<Link> links) {
        this.links = links;
    }

}
