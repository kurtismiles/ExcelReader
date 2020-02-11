package model;

//@author Kurtis Miles

public class FirstSheetData {

    String soundType;
    String description;
    int score;
    Boolean status;
    String coefficient;

    public FirstSheetData() {

        soundType = "N/A";
        description = "N/A";
        score = 99;
        String coefficient = "N/A";
        status = null;

    }

    public String getSound() {

        return soundType;
    }

    public void setSound(String inf_soundType) {

        soundType = inf_soundType;

    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String inf_description) {

        description = inf_description;

    }

    public int getScore() {

        return score;
    }

    public void setScore(int inf_score) {

        score = inf_score;
    }

    public Boolean getStatus() {

        return status;
    }

    public void setStatus(Boolean inf_status) {

        status = inf_status;
    }

    public String getCoefficient() {

        return coefficient;
    }

    public String calculateCoefficient() {

        if ((status == true && score == 1) || (status ==false && score == 5)) {

            coefficient = "0";
        } else if ((status == true && score == 2) || (status == false && score == 4)) {

            coefficient = "0.25";
        } else if (score == 3) {

            coefficient = ".5";
        } else if ((status == true && score == 4) || (status == false && score == 2)) {

            coefficient = "0.75";
        } else if ((status == true && score == 5) || (status == false && score == 1)) {

            coefficient = "1.0";
            
        } else {
            coefficient = "2.0";
        }

        return coefficient;

    }
}
