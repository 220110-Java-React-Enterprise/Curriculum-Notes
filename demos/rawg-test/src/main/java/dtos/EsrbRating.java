package dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class EsrbRating {
    Integer id;
    String slug;
    String name;

    public EsrbRating() {
    }

    public EsrbRating(String slug, String name) {
        this.slug = slug;
        this.name = name;
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

    @Override
    public String toString() {
        return "EsrbRating{" +
                "\nid=" + id +
                ", \nslug='" + slug + '\'' +
                ", \nname='" + name + '\'' +
                "}\n";
    }
}
