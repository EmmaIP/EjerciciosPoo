package com.campusdual.ejercicio5;

public enum Gender {
    FEMALE,
    MALE;

    public static Gender getByString(String genderName) {
        if("m".equals(genderName.trim().toLowerCase())) {
            return FEMALE;
        }
        else if("h".equals(genderName.trim().toLowerCase())){
            return MALE;
        }
        else if ("mujer".equals(genderName.trim().toLowerCase())) {
            return FEMALE;
        }
        else if ("hombre".equals(genderName.trim().toLowerCase())) {
            return MALE;
        }
        else {
            return null;
        }
    }
}
