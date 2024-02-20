class Room {
    private String name;
    private int roomNumber;
    private double area;
    private Building building;
    private static int numberCount = 0;

    public Room(String name, double area) {
        numberCount =+ 1;
        this.roomNumber = numberCount;
        this.area = area;
        this.name = "Room: " + name;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getRoomNumber() { return roomNumber; }
    public void setRoomNumber(int roomNumber) { this.roomNumber = roomNumber; }
    public double getArea() { return area; }
    public void setArea(double area) { this.area = area; }
    public Building getBuilding() { return building; }
    public void setBuilding(Building building) { this.building = building; }

    public void printRoom(){
        System.out.printf("Room number %d, with area of %f\n", this.roomNumber, this.area);
    }

    @Override
    public String toString() {
        return name;
    }
}