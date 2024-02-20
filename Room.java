class Room {
    private int roomNumber;
    private double area;
    private Building building;

    public Room(int roomNumber, double area) {
        this.roomNumber = roomNumber;
        this.area = area;
    }
    public int getRoomNumber() { return roomNumber; }
    public void setRoomNumber(int roomNumber) { this.roomNumber = roomNumber; }
    public double getArea() { return area; }
    public void setArea(double area) { this.area = area; }
    public Building getBuilding() { return building; }
    public void setBuilding(Building building) { this.building = building; }

    public void printRoom(){
        System.out.printf("Room number %d, with area of %f\n", this.roomNumber, this.area);
    }
}