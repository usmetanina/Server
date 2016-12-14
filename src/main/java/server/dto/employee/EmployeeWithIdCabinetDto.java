package server.dto.employee;

import com.fasterxml.jackson.annotation.JsonProperty;
import server.entity.Employee;

public class EmployeeWithIdCabinetDto {

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("surname")
    private String surname;

    @JsonProperty("patronymic")
    private String patronymic;

    @JsonProperty("position")
    private String position;

    @JsonProperty("phone")
    private String phoneNumber;

    @JsonProperty("email")
    private String email;

    @JsonProperty("cabinet")
    private Integer cabinet;

    public Integer getCabinet() {
        return cabinet;
    }

    public void setCabinet(Integer cabinet) {
        this.cabinet = cabinet;
    }
/*@JsonProperty("photo")
    private byte[] photo;

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static EmployeeWithIdCabinetDto fromModel(Employee employee) {
        if (employee != null) {
            EmployeeWithIdCabinetDto dto = new EmployeeWithIdCabinetDto();

            dto.setName(employee.getName());
            dto.setPatronymic(employee.getPatronymic());
            dto.setSurname(employee.getSurname());
            dto.setId(employee.getId());
            dto.setEmail(employee.getEmail());
            dto.setPhoneNumber(employee.getPhoneNumber());
            dto.setPosition(employee.getPosition());
            dto.setCabinet(employee.getCabinet().getId());
            //dto.setPhoto(employee.getPhoto());
            return dto;
        }
        else
            return null;
    }
}
