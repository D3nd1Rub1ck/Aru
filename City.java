import java.util.List;
import java.util.ArrayList;

class City {
    private String name;
    private List<Building> buildings = new ArrayList<>();

    public City(String name) { this.name = "City:" + name; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<Building> getBuildings() { return buildings; }
    public void addBuilding(Building building) { buildings.add(building); }
    public void removeBuilding(Building building) { buildings.remove(building); }

    public Building searchForBuilding(String streetName, String houseNumber) {
        for (Building building : buildings) {
            if (building.getStreetName().equals(streetName) && building.getHouseNumber().equals(houseNumber)) {
                return building;
            }
        }
        return null;
    }

    public void printCity(){
        System.out.printf("This is %s and it have following buildings:\n", this.name);
        for (Building building : buildings) {
            building.printBuilding();
        }
    }

    @Override
    public String toString() {
        return name;
    }
}