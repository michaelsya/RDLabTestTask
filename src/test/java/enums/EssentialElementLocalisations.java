package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@AllArgsConstructor
@Getter
public enum EssentialElementLocalisations {
    SELECTED_LANGUAGE("English", "Suomi", "Svenska"),
    CHANGE_REGIONAL_SETTINGS_BUTTON("Change", "Vaihda", "Ändra"),
    SHOPPING_CART("Shopping Cart", "Ostoskori", "Varukorg"),
    CATEGORIES("Categories", "Kategoriat", "Kategorier"),
    SIGN_IN("Sign In", "Kirjaudu sisään", "Logga in");

    public String english;
    public String finnish;
    public String swedish;

    public static List<String> getElementsLocalisation(String desiredLanguage) {
        Localisations localisations = Localisations.getLocalisationName(desiredLanguage);
        List<String> localisedList = new ArrayList<>();
        switch (localisations) {
            case ENGLISH:
                Stream.of(EssentialElementLocalisations.values()).forEach(item -> localisedList.add(item.getEnglish()));
                break;
            case FINNISH:
                Stream.of(EssentialElementLocalisations.values()).forEach(item -> localisedList.add(item.getFinnish()));
                break;
            case SWEDISH:
                Stream.of(EssentialElementLocalisations.values()).forEach(item -> localisedList.add(item.getSwedish()));
                break;
        }
        return localisedList;
    }

}
