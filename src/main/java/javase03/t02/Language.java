package javase03.t02;

public enum Language {
    RUSSIAN("ru"),
    ENGLISH("en");

    private String lang;

    Language(String lang){
        this.lang = lang;
    }

    public String getLanguage(){
        return this.lang;
    }

    public static Language getObject(String lang){
        for (Language object : values()) {
            if (object.getLanguage().equals(lang))
                return object;
        }
        return null;
    }
}
