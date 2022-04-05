package utils;

public enum LoanSystemCode {
    PROFILE("Профайл", "Profile"),
    BQ("Бисквит VIP (Москва)", "BQ"),
    CFT2RL("CFT2RL", "CFT"),
    WAY4("WAY4", "WAY");

    private final String systemCode;
    private final String shortSystemCode;

    LoanSystemCode(String systemCode, String shortSystemCode) {

        this.systemCode = systemCode;
        this.shortSystemCode = shortSystemCode;
    }
    public String getShortSystemCode() {
        return shortSystemCode;
    }
    public String getSystemCode() {
        return systemCode;
    }
}
