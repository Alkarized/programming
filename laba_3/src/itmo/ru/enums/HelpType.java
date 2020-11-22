package itmo.ru.enums;

public enum HelpType {
    PACK_THINGS("укладывать вещи"),
    GET_DRESSED("одеваться");

    private final String help;
    public String getHelp(){
        return help;
    }
    private HelpType(String help){
        this.help = help;
    }
}
