package json;

/**
 * Created by Andrii_Rodionov on 1/4/2017.
 */
public class JsonBoolean extends Json {

    private boolean value;

    public JsonBoolean(Boolean bool) {
        // ToDo
        value = bool;
    }

    @Override
    public String toJson() {
        // ToDo
        if (value) {
            return "true";
        }
        return "false";
    }
}
