
package com.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Features {

    @SerializedName("ikev2")
    @Expose
    private Boolean ikev2;
    @SerializedName("openvpn_udp")
    @Expose
    private Boolean openvpnUdp;
    @SerializedName("openvpn_tcp")
    @Expose
    private Boolean openvpnTcp;
    @SerializedName("socks")
    @Expose
    private Boolean socks;
    @SerializedName("proxy")
    @Expose
    private Boolean proxy;
    @SerializedName("pptp")
    @Expose
    private Boolean pptp;
    @SerializedName("l2tp")
    @Expose
    private Boolean l2tp;
    @SerializedName("openvpn_xor_udp")
    @Expose
    private Boolean openvpnXorUdp;
    @SerializedName("openvpn_xor_tcp")
    @Expose
    private Boolean openvpnXorTcp;
    @SerializedName("proxy_cybersec")
    @Expose
    private Boolean proxyCybersec;
    @SerializedName("proxy_ssl")
    @Expose
    private Boolean proxySsl;
    @SerializedName("proxy_ssl_cybersec")
    @Expose
    private Boolean proxySslCybersec;

    public Boolean getIkev2() {
        return ikev2;
    }

    public void setIkev2(Boolean ikev2) {
        this.ikev2 = ikev2;
    }

    public Boolean getOpenvpnUdp() {
        return openvpnUdp;
    }

    public void setOpenvpnUdp(Boolean openvpnUdp) {
        this.openvpnUdp = openvpnUdp;
    }

    public Boolean getOpenvpnTcp() {
        return openvpnTcp;
    }

    public void setOpenvpnTcp(Boolean openvpnTcp) {
        this.openvpnTcp = openvpnTcp;
    }

    public Boolean getSocks() {
        return socks;
    }

    public void setSocks(Boolean socks) {
        this.socks = socks;
    }

    public Boolean getProxy() {
        return proxy;
    }

    public void setProxy(Boolean proxy) {
        this.proxy = proxy;
    }

    public Boolean getPptp() {
        return pptp;
    }

    public void setPptp(Boolean pptp) {
        this.pptp = pptp;
    }

    public Boolean getL2tp() {
        return l2tp;
    }

    public void setL2tp(Boolean l2tp) {
        this.l2tp = l2tp;
    }

    public Boolean getOpenvpnXorUdp() {
        return openvpnXorUdp;
    }

    public void setOpenvpnXorUdp(Boolean openvpnXorUdp) {
        this.openvpnXorUdp = openvpnXorUdp;
    }

    public Boolean getOpenvpnXorTcp() {
        return openvpnXorTcp;
    }

    public void setOpenvpnXorTcp(Boolean openvpnXorTcp) {
        this.openvpnXorTcp = openvpnXorTcp;
    }

    public Boolean getProxyCybersec() {
        return proxyCybersec;
    }

    public void setProxyCybersec(Boolean proxyCybersec) {
        this.proxyCybersec = proxyCybersec;
    }

    public Boolean getProxySsl() {
        return proxySsl;
    }

    public void setProxySsl(Boolean proxySsl) {
        this.proxySsl = proxySsl;
    }

    public Boolean getProxySslCybersec() {
        return proxySslCybersec;
    }

    public void setProxySslCybersec(Boolean proxySslCybersec) {
        this.proxySslCybersec = proxySslCybersec;
    }

}
