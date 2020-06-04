package com.project.hotel.services;

import com.project.hotel.models.Room;
import com.project.hotel.models.User;
import com.project.hotel.repositories.RoomRepository;
import io.reactivex.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService implements IRoomService{

    @Autowired
    RoomRepository roomRepository;

    @Override
    public List<Room> getRoom() {
        return roomRepository.findAll();
    }

    @Override
    public Room getRoomById(String roomId) {
        return roomRepository.findById(roomId).get();
    }

    @Override
    public Boolean deleteRoom(String roomId) {
        roomRepository.deleteById(roomId);

        return roomRepository.existsById(roomId) == false;
    }

    @Override
    public void postRoom(Room room) {
        roomRepository.save(room);
    }

    @Override
    public void putRoom(Room room) {
        roomRepository.save(room);
    }

    @Override
    public List<Room> getSearchRooms(Double maxPricePerNight, Double maxPriceForFood,
                                     Integer maxAmountOfBeds, String type){

        List<Room> rooms = roomRepository.findAll();
        Observable<List<Room>> observer = Observable.just(rooms);
        List<Room> rooms1 = observer.flatMap(Observable::fromIterable)
                .filter(s -> s.getMaxAmountOfBeds() <= maxAmountOfBeds
                        && s.getType().toString().equals(type)
                        && s.getPriceForFood() <= maxPriceForFood
                        && s.getPricePerNight()<= maxPricePerNight
        )
                .toList().blockingGet();

        return rooms1;
    }
}
