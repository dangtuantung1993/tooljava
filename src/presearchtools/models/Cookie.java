/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presearchtools.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author JMango
 */
public class Cookie {

    @SerializedName("domain")
    @Expose
    private String domain;
    @SerializedName("expirationDate")
    @Expose
    private Double expirationDate;
    @SerializedName("hostOnly")
    @Expose
    private Boolean hostOnly;
    @SerializedName("httpOnly")
    @Expose
    private Boolean httpOnly;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("path")
    @Expose
    private String path;
    @SerializedName("sameSite")
    @Expose
    private String sameSite;
    @SerializedName("secure")
    @Expose
    private Boolean secure;
    @SerializedName("session")
    @Expose
    private Boolean session;
    @SerializedName("storeId")
    @Expose
    private String storeId;
    @SerializedName("value")
    @Expose
    private String value;
    @SerializedName("id")
    @Expose
    private Integer id;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Double getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Double expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Boolean getHostOnly() {
        return hostOnly;
    }

    public void setHostOnly(Boolean hostOnly) {
        this.hostOnly = hostOnly;
    }

    public Boolean getHttpOnly() {
        return httpOnly;
    }

    public void setHttpOnly(Boolean httpOnly) {
        this.httpOnly = httpOnly;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getSameSite() {
        return sameSite;
    }

    public void setSameSite(String sameSite) {
        this.sameSite = sameSite;
    }

    public Boolean getSecure() {
        return secure;
    }

    public void setSecure(Boolean secure) {
        this.secure = secure;
    }

    public Boolean getSession() {
        return session;
    }

    public void setSession(Boolean session) {
        this.session = session;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
