package entity;

public class Classes {
    Integer id;
    String number;
    String code;

    public Classes() {
    }
    public Classes(String number, String code) {
        this.number = number;
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Classes(Integer id, String number, String code) {
        this.id = id;
        this.number = number;
        this.code = code;
    }
}
