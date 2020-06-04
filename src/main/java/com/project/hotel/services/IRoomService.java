package com.project.hotel.services;

import com.project.hotel.models.Room;

import java.util.List;

public interface IRoomService {

    public List<Room> getRoom();
    public Room getRoomById(String roomId);
    public Boolean deleteRoom(String roomId);
    public void postRoom(Room room);
    public void putRoom(Room room);
    public List<Room> getSearchRooms(Double maxPricePerNight, Double maxPriceForFood,
                                     Integer maxAmountOfBeds, String type);


}
