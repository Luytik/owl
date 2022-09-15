package owl.models;

public enum MeasurementUnit {
    //1. UkraineName.
    g("Грам"), kg("Кілограм"), t("Тонна"), l("Літр"), ml("Мілілітр"), pc("Штуки");

    private final String UkrName;

    MeasurementUnit(String UkrName) {
        this.UkrName = UkrName;
    }

    public String getUnitName() {
        return UkrName;
    }
}
