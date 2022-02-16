package dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Results {
    private Integer id;
    private String slug;
    private String name;
    private String released;
    private Boolean tba;
    private String background_image;
    private Integer rating;
    private Integer rating_top;
    private EsrbRating esrb_rating;


    public Results() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public Boolean getTba() {
        return tba;
    }

    public void setTba(Boolean tba) {
        this.tba = tba;
    }

    public String getBackground_image() {
        return background_image;
    }

    public void setBackground_image(String background_image) {
        this.background_image = background_image;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getRating_top() {
        return rating_top;
    }

    public void setRating_top(Integer rating_top) {
        this.rating_top = rating_top;
    }

    public EsrbRating getEsrb_rating() {
        return esrb_rating;
    }

    public void setEsrb_rating(EsrbRating esrb_rating) {
        this.esrb_rating = esrb_rating;
    }

    @Override
    public String toString() {
        return "Results{" +
                "\nid=" + id +
                ", \nslug='" + slug + '\'' +
                ", \nname='" + name + '\'' +
                ", \nreleased='" + released + '\'' +
                ", \ntba=" + tba +
                ", \nbackground_image='" + background_image + '\'' +
                ", \nrating=" + rating +
                ", \nrating_top=" + rating_top +
                ", \nesrb_rating=" + esrb_rating +
                "}\n";
    }
}
