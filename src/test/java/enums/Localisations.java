package enums;

import lombok.Getter;

@Getter
public enum Localisations {
    ENGLISH("English", "English"),
    FINNISH("Finnish", "Suomi"),
    SWEDISH("Swedish", "Svenska");

    public String originalName;
    public String alternativeName;

    Localisations(String originalName, String alternativeName) {
        this.originalName = originalName;
        this.alternativeName = alternativeName;
    }

    public static Localisations getLocalisationName(String itemName) {
        for (Localisations item : Localisations.values()) {
            if (item.getOriginalName().equalsIgnoreCase(itemName) || item.getAlternativeName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        throw new IllegalStateException("Localisation (language) not found, supported localisations:\nEnglish\nFinnish\nSwedish");
    }


}
