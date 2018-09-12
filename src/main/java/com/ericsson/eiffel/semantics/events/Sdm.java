
package com.ericsson.eiffel.semantics.events;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sdm {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("authorIdentity")
    @Expose
    private String authorIdentity;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("encryptedDigest")
    @Expose
    private String encryptedDigest;

    /**
     * 
     * (Required)
     * 
     */
    public String getAuthorIdentity() {
        return authorIdentity;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setAuthorIdentity(String authorIdentity) {
        this.authorIdentity = authorIdentity;
    }

    /**
     * 
     * (Required)
     * 
     */
    public String getEncryptedDigest() {
        return encryptedDigest;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setEncryptedDigest(String encryptedDigest) {
        this.encryptedDigest = encryptedDigest;
    }

}
