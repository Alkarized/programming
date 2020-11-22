package itmo.ru.enums;

public enum Instructions {
    FASTEN_THE_TOP_BUTTON(", чтобы он не забыл застегнуть верхнюю пуговицу на пальто, а то продует!"),
    CAREFULLY_CROSS_THE_STREET(", чтобы он осторожно переходил улицу!"),
    DO_NOT_SMOKE_ON_AN_EMPTY_STOMACH(", чтобы он не курил натощак!");

    private final String inst;

    public String getInst(){
        return inst;
    }

    private Instructions(String inst) {
        this.inst = inst;
    }
}

