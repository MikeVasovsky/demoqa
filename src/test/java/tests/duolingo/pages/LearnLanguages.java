package tests.duolingo.pages;

public enum LearnLanguages {
    EN("английский", "Занимайтесь английский всего 5 минут в день. Эффективно и бесплатно!"),
    SPA("испанский","Занимайтесь испанский всего 5 минут в день. Эффективно и бесплатно!"),
    FR("французский","Занимайтесь французский всего 5 минут в день. Эффективно и бесплатно!"),
    ITL("итальянский","Занимайтесь итальянский всего 5 минут в день. Эффективно и бесплатно!");
     LearnLanguages(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String name;
    private String desc;

    public String getLanguage() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}

