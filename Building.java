import java.util.List;
import java.util.ArrayList;

class Building {
    private String name;
    private String streetName;
    private String houseNumber;
    private double basicMonthlyPaymentPerSqM;
    //private static Room rum = new Room("testRoom", 100);
    private List <Room> rooms = new ArrayList<>();
    
    /* 
    public Building(String streetName, String houseNumber, double basicMonthlyPaymentPerSqM) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.basicMonthlyPaymentPerSqM = basicMonthlyPaymentPerSqM;
    }
    */
    
    public Building(String name) {
        this.name = "Building: " + name;
        this.streetName = "streetName";
        this.houseNumber = "houseNumber";
        this.basicMonthlyPaymentPerSqM = 100.0;
    }

    public String getStreetName() { return streetName; }
    public void setStreetName(String streetName) { this.streetName = streetName; }
    public String getHouseNumber() { return houseNumber; }
    public void setHouseNumber(String houseNumber) { this.houseNumber = houseNumber; }
    public double getBasicMonthlyPaymentPerSqM() { return basicMonthlyPaymentPerSqM; }
    public void setBasicMonthlyPaymentPerSqM(double basicMonthlyPaymentPerSqM) { this.basicMonthlyPaymentPerSqM = basicMonthlyPaymentPerSqM; }
    public List< Room > getRooms() { return rooms; }
    public void addRoom(Room room) { rooms.add(room); }
    public void removeRoom(Room room) { rooms.remove(room); }
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    @Override
    public String toString() {
        return name;
    }

    public double getTotalArea() {
        double totalArea = 0;
        for (Room room : rooms) {
            totalArea += room.getArea();
        }
        return totalArea;
    }
    public void printBuilding(){
        System.out.printf("\tBuilding number %s, on Street %s with rooms:\n", this.houseNumber, this.streetName);
        for (Room room : rooms) {
            System.out.print("\t\t");
            room.printRoom();
        }
    }
    

}