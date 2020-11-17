package itmo.ru.others;

public class Phone {
    private String type;
    private String model;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type == null) {
            type = "Смартфон";
        } else {
            this.type = type;
        }
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if(model == null){
            this.model = "pocoX3";
        } else {
            this.model = model;
        }
    }

    @Override
    public String toString() {
        return getType();
    }

    @Override
    public boolean equals(Object phone) {
        return this.model.equals(((Phone) phone).getModel())
                && this.getType().equals(((Phone) phone).getType());
    }

    public Phone(String type, String model) {
        setType(type);
        setModel(model);
    }

    public Phone() {
        setModel(null);
        setType(null);
    }
}
