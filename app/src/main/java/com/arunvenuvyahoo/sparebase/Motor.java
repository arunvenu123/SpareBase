package com.arunvenuvyahoo.sparebase;

public class Motor {
    String makeOfMotor;
    String locationOfmotor;
    String detailsOfMotor;
    String machineUsed;

    public Motor(){

    }

    public Motor(String makeOfMotor, String locationOfmotor, String detailsOfMotor, String machineUsed) {
        this.makeOfMotor = makeOfMotor;
        this.locationOfmotor = locationOfmotor;
        this.detailsOfMotor = detailsOfMotor;
        this.machineUsed = machineUsed;
    }

    public String getMakeOfMotor() {
        return makeOfMotor;
    }

    public String getLocationOfmotor() {
        return locationOfmotor;
    }

    public String getDetailsOfMotor() {
        return detailsOfMotor;
    }

    public String getMachineUsed() {
        return machineUsed;
    }
}
