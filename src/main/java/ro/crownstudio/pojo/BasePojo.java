package ro.crownstudio.pojo;

import com.google.gson.GsonBuilder;

public class BasePojo {

    public String toJson() {
        return new GsonBuilder().serializeNulls().create().toJson(this);
    }
}
