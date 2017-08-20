package com.github.ppartisan.fishportal.model.common.web;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

class FishbaseItemDeserializer<T> implements JsonDeserializer<T> {

    private static final String DATA = "data";

    private FishbaseItemDeserializer(){}

    static <T> FishbaseItemDeserializer<T> create() {
        return new FishbaseItemDeserializer<>();
    }

    @Override
    public T deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        final JsonElement element = json.getAsJsonObject().getAsJsonArray(DATA).get(0);
        return new Gson().fromJson(element, typeOfT);
    }

}
