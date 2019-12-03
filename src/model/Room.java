package model;


public class Room
{
    private  int roomNo;
    private  int price;
    private  String description;
    private  int isAvailable;
    private String type;

    public Room() {
    }

    public Room(int RoomNo,
                int Price,
                String Description,
                int isAvailable)
    {
        this.setRoomNo(RoomNo);
        this.setPrice(Price);
        this.setDescription(Description);
        this.setIsAvailable(isAvailable);
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(int isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
