package entity;

public class Companies {

    private int id;
    private String name;
    private String password;
    private int sectorID;

    public Companies() {
    }

    public Companies(int id, String name, String password, int sectorID) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.sectorID = sectorID;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSectorID() {
        return sectorID;
    }

    public void setSectorID(int sectorID) {
        this.sectorID = sectorID;
    }
}
