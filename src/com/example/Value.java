
package com.example;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Value {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("ip_address")
    @Expose
    private String ipAddress;
    @SerializedName("search_keywords")
    @Expose
    private List<String> searchKeywords = null;
    @SerializedName("categories")
    @Expose
    private List<Category> categories = null;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("domain")
    @Expose
    private String domain;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("flag")
    @Expose
    private String flag;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("load")
    @Expose
    private Integer load;
    @SerializedName("features")
    @Expose
    private Features features;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public List<String> getSearchKeywords() {
        return searchKeywords;
    }

    public void setSearchKeywords(List<String> searchKeywords) {
        this.searchKeywords = searchKeywords;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Integer getLoad() {
        return load;
    }

    public void setLoad(Integer load) {
        this.load = load;
    }

    public Features getFeatures() {
        return features;
    }

    public void setFeatures(Features features) {
        this.features = features;
    }

}
