package entity;

public class Companies {

    private int id;
    private String name;
    private int sectorID;

    public Companies() {
    }

    public Companies(int id, String name, int sectorID) {
        this.id = id;
        this.name = name;
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

    public int getSectorID() {
        return sectorID;
    }

    public void setSectorID(int sectorID) {
        this.sectorID = sectorID;
    }
}
