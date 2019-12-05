package json;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {

    private List<JsonPair> pairArray;

    public JsonObject(JsonPair... jsonPairs) {
        // ToDo
        pairArray = Arrays.asList(jsonPairs);
    }

    @Override
    public String toJson() {
        // ToDo
        StringBuilder resString;
        resString = new StringBuilder("{");
        for (JsonPair iterPair: pairArray) {
            resString.append("'").append(iterPair.key).append("': ");
            resString.append(iterPair.value.toJson()).append(", ");
        }
        resString.append("}");
        return resString.toString();
    }

    public void add(JsonPair jsonPair) {
        // ToDo
        pairArray.add(jsonPair);
    }

    public Json find(String name) {
        // ToDo
        for (JsonPair iterPair: pairArray) {
            if (iterPair.key.equals(name)) {
                return iterPair.value;
            }
        }
        return null;
    }

    public JsonObject projection(String... names) {
        // ToDo
        return null;
    }
}
