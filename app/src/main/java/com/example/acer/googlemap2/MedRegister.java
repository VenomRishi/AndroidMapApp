package com.example.acer.googlemap2;

public class MedRegister {
    String allergies,medcond,medication,pregnent,ma,mfci,language;
    public MedRegister()
    {


    }
    public MedRegister(String allergies,String medcond,String medication,String pregnent,String ma,String mfci,String language)
    {
        this.allergies=allergies;
        this.medcond=medcond;
        this.medication=medication;
        this.pregnent=pregnent;
        this.ma=ma;
        this.mfci=mfci;
        this.language=language;

    }

    public String getAllergies() {
        return allergies;
    }

    public String getMedcond() {
        return medcond;
    }

    public String getMedication() {
        return medication;
    }

    public String getPregnent() {
        return pregnent;
    }

    public String getMa() {
        return ma;
    }

    public String getMfci() {
        return mfci;
    }

    public String getLanguage() {
        return language;
    }
}

