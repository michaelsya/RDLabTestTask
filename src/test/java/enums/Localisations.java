package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Localisations {
    ENGLISH("English", "English"),
    FINNISH("Finnish", "Suomi"),
    SWEDISH("Swedish", "Svenska");

    public String originalName;
    public String alternativeName;

    public static Localisations getLocalisationName(String itemName) {
        for (Localisations item : Localisations.values()) {
            if (item.getOriginalName().equalsIgnoreCase(itemName) || item.getAlternativeName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        throw new IllegalStateException("Localisation (language) not found, supported localisations:\nEnglish\nFinnish\nSwedish");
    }


}
