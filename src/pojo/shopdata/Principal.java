
package pojo.shopdata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Principal {

    @SerializedName("flag")
    @Expose
    private Integer flag;
    @SerializedName("DESCRIPTION")
    @Expose
    private String dESCRIPTION;
    @SerializedName("ADDRESS")
    @Expose
    private String aDDRESS;
    @SerializedName("OPENTIME")
    @Expose
    private String oPENTIME;
    @SerializedName("PX")
    @Expose
    private String pX;
    @SerializedName("PY")
    @Expose
    private String pY;
    @SerializedName("TEL")
    @Expose
    private String tEL;
    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("CLASS")
    @Expose
    private String cLASS;
    @SerializedName("WEBSITE")
    @Expose
    private String wEBSITE;
    @SerializedName("NAME")
    @Expose
    private String nAME;

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getDESCRIPTION() {
        return dESCRIPTION;
    }

    public void setDESCRIPTION(String dESCRIPTION) {
        this.dESCRIPTION = dESCRIPTION;
    }

    public String getADDRESS() {
        return aDDRESS;
    }

    public void setADDRESS(String aDDRESS) {
        this.aDDRESS = aDDRESS;
    }

    public String getOPENTIME() {
        return oPENTIME;
    }

    public void setOPENTIME(String oPENTIME) {
        this.oPENTIME = oPENTIME;
    }

    public String getPX() {
        return pX;
    }

    public void setPX(String pX) {
        this.pX = pX;
    }

    public String getPY() {
        return pY;
    }

    public void setPY(String pY) {
        this.pY = pY;
    }

    public String getTEL() {
        return tEL;
    }

    public void setTEL(String tEL) {
        this.tEL = tEL;
    }

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public String getCLASS() {
        return cLASS;
    }

    public void setCLASS(String cLASS) {
        this.cLASS = cLASS;
    }

    public String getWEBSITE() {
        return wEBSITE;
    }

    public void setWEBSITE(String wEBSITE) {
        this.wEBSITE = wEBSITE;
    }

    public String getNAME() {
        return nAME;
    }

    public void setNAME(String nAME) {
        this.nAME = nAME;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
