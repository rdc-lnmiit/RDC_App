package com.example.android.rdc;

public class SchemeModal {
    private String schemeName;
    private String schemeType;

    public SchemeModal() {

    }

    public SchemeModal(String schemeName, String schemeType)
    {
        this.schemeName=schemeName;
        this.schemeType=schemeType;
    }

    public String getSchemeName() {
        return schemeName;
    }

    public String getSchemeType() {
        return schemeType;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }

    public void setSchemeType(String schemeType) {
        this.schemeType = schemeType;
    }
}
