package server.dto.cabinetAndHousing;

import com.fasterxml.jackson.annotation.JsonProperty;
import server.entity.Housing;

public class HousingDto {

    @JsonProperty("id")
    private int id;

    @JsonProperty("number")
    private String number;

    @JsonProperty("title")
    private String title;

    @JsonProperty("city")
    private String city;

    @JsonProperty("street")
    private String street;

    @JsonProperty("house")
    private String house;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public static HousingDto fromModel(Housing housing) {
        if (housing!=null) {
            HousingDto dto = new HousingDto();
            dto.setId(housing.getId());
            dto.setCity(housing.getCity());
            dto.setHouse(housing.getHouse());
            dto.setNumber(housing.getNumber());
            dto.setStreet(housing.getStreet());
            dto.setTitle(housing.getTitle());
            return dto;
        }
        return null;
    }
}