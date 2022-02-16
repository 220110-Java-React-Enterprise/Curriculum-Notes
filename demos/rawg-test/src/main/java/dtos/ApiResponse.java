package dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ApiResponse {
    private Integer count;
    private String next;
    private String previous;
    private List<Results> results;

    public ApiResponse() {
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "\ncount=" + count +
                ", \nnext='" + next + '\'' +
                ", \nprevious='" + previous + '\'' +
                ", \nresults=" + results +
                "}\n";
    }
}
