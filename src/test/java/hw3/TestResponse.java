package hw3;

public class TestResponse {
    private static String AddResult;

    public TestResponse(String addResult) {
        AddResult = addResult;
    }

    public static String getAddResult() {
        return AddResult;
    }
}
