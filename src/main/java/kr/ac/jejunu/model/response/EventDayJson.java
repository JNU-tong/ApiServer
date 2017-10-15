package kr.ac.jejunu.model.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NON_PRIVATE)
public class EventDayJson {
    @JsonProperty("totalResult")
    private int totalResult;

    @JsonProperty("page")
    private int page;

    @JsonProperty("count")
    private int count;

    @JsonProperty("results")
    private ArrayList<EventDayInfo> results = new ArrayList<>();

    public ArrayList<EventDayInfo> getResults() {
        return results;
    }

    public void setResults(ArrayList<EventDayInfo> results) {
        this.results = results;
    }
}
