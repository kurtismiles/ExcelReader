
package model;

//@author Kurtis Miles

public class SecondSheetData {

    String soundType;
    Boolean status;

    public SecondSheetData() {

        soundType = "N/A";

    }

    public String getSound() {

        return soundType;
    }

    public void setSound(String inf_soundType) {

        soundType = inf_soundType;

    }

    public Boolean getStatus() {

        return status;
    }

    public void setStatus(Boolean inf_status) {

        status = inf_status;
    }

}
