package json;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {

    private ArrayList<JsonPair> pairArray;
    private HashMap<String, JsonPair> nameSet = new HashMap<>();

    public JsonObject(JsonPair... jsonPairs) {
        // ToDo
        pairArray = new ArrayList<>();
        for (JsonPair jsonPair: Arrays.asList(jsonPairs)) {
            if (! nameSet.containsKey(jsonPair.key)) {
                nameSet.put(jsonPair.key, jsonPair);
                pairArray.add(jsonPair);
            }
            else {
                pairArray.set(pairArray.indexOf(nameSet.get(jsonPair.key)), jsonPair);
            }
        }
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
        if (resString.length() != 1) {
            resString.delete(resString.length() - 2, resString.length() - 1);
        }
        resString.append("}");
        return resString.toString();
    }

    public void add(JsonPair jsonPair) {
        // ToDo
        if (! nameSet.containsKey(jsonPair.key)) {
            nameSet.put(jsonPair.key, jsonPair);
            pairArray.add(jsonPair);
        }
        else {
            pairArray.set(pairArray.indexOf(nameSet.get(jsonPair.key)), jsonPair);
        }
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

    public boolean contains(String name) {
        return nameSet.containsKey(name);
    }

    public JsonObject projection(String... names) {
        // ToDo
        JsonObject newJsonObject = new JsonObject();
        for (String name: Arrays.asList(names)) {
            if (newJsonObject.contains(name)) {
                newJsonObject.add(pairArray.get(pairArray.indexOf(nameSet.get(name))));
            }
        }
        return newJsonObject;
    }
}
