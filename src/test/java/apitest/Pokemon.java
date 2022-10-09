package apitest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties
public class Pokemon {
    @JsonProperty ("name")
    private String name;
    @JsonProperty("url")
    private String url;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
