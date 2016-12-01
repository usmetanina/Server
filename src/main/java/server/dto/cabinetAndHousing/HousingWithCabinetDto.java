package server.dto.cabinetAndHousing;

import com.fasterxml.jackson.annotation.JsonProperty;
import server.entity.Cabinet;
import server.entity.Housing;

import java.util.LinkedList;

public class HousingWithCabinetDto {

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

    @JsonProperty("cabinets")
    private LinkedList<CabinetWithEmployeesDto> cabinets = new LinkedList<>();

    public LinkedList<CabinetWithEmployeesDto> getCabinets() {
        return cabinets;
    }

    public void setCabinets(LinkedList<CabinetWithEmployeesDto> cabinets) {
        this.cabinets = cabinets;
    }

    public static HousingWithCabinetDto fromModel(Housing housing) {
        if (housing!=null) {
            HousingWithCabinetDto dto = new HousingWithCabinetDto();
            dto.setId(housing.getId());
            dto.setCity(housing.getCity());
            dto.setHouse(housing.getHouse());
            dto.setNumber(housing.getNumber());
            dto.setStreet(housing.getStreet());
            dto.setTitle(housing.getTitle());

            LinkedList<CabinetWithEmployeesDto> cabinetWithEmployeesDtos = new LinkedList<>();

            for (Cabinet cabinet : housing.getCabinets()) {
                cabinetWithEmployeesDtos.add(CabinetWithEmployeesDto.fromModel(cabinet));
            }
            dto.setCabinets(cabinetWithEmployeesDtos);

            return dto;
        }
        return null;
    }
}