package com.project.hotel.controller;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.project.hotel.models.Reservation;
import com.project.hotel.models.Role;
import com.project.hotel.models.Room;
import com.project.hotel.services.IReservationService;
import com.project.hotel.services.IRoleService;
import com.project.hotel.services.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.hotel.models.User;
import com.project.hotel.services.IUserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class HotelController {

	@Autowired
	private IUserService iUserService;

	@Autowired
	private IRoleService iRoleService;

	@Autowired
	private IRoomService iRoomService;

	@Autowired
	private IReservationService iReservationService;
	
	@RequestMapping(value = "/postUser", method = RequestMethod.POST)
	@ResponseBody
	public void postUser(@ModelAttribute User user) {

		
		iUserService.postUser(user);

	}
	
	@RequestMapping(value = "/getUsers", method = RequestMethod.GET)
	@ResponseBody
	public List<User> getUsers() {
		
		
		return iUserService.getUsers();

	}
	
	@RequestMapping(value = "/getUsersById", method = RequestMethod.GET)
	@ResponseBody
	public User getUsersById(@RequestParam("Id") String id) {
		
		
		return iUserService.getUsersById(id);
	}

	@RequestMapping(value = "/getUserByEmailAndPass", method = RequestMethod.GET)
	@ResponseBody
	public User getUserByEmailAndPass(@RequestParam("email") String email,
										@RequestParam("password") String password) {



		return iUserService.getUserByEmailAndPassword(email,password);

	}

	@RequestMapping(value = "/putPassword", method = RequestMethod.PUT)
	@ResponseBody
	public void putPassword(@RequestParam("id") String id, @RequestParam("password") String password) {

		iUserService.putPassword(id, password);

	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE)
	@ResponseBody
	public Boolean deleteUser(@RequestParam("id") String id) {

		return iUserService.deleteUser(id);

	}

	@RequestMapping(value = "/postRole", method = RequestMethod.POST)
	@ResponseBody
	public void postRole(@ModelAttribute Role role) {



		iRoleService.postRole(role);

	}

	@RequestMapping(value = "/getRoles", method = RequestMethod.GET)
	@ResponseBody
	public List<Role> getRoles(@ModelAttribute Role role) {



		return iRoleService.getRoles();

	}
	//5eca9ef4bf824a6544b732a5 USER
	@RequestMapping(value = "/deleteRole", method = RequestMethod.DELETE)
	@ResponseBody
	public Boolean deleteRole(@RequestParam("id") String id) {



		return iRoleService.deleteRole(id);

	}

	@RequestMapping(value = "/putUserRole", method = RequestMethod.PUT)
	@ResponseBody
	public void putUserRole(@RequestParam("userId") String userId, @RequestParam("roleName") String roleName) {

		iUserService.putUserRole(userId, roleName);


	}

	@RequestMapping(value = "/getRoom", method = RequestMethod.GET)
	@ResponseBody
	public List<Room> getRoom() {

		return iRoomService.getRoom();


	}

	@RequestMapping(value = "/getRoomById", method = RequestMethod.GET)
	@ResponseBody
	public Room getRoomById(@RequestParam("roomId") String roomId) {

		return iRoomService.getRoomById(roomId);


	}
	@RequestMapping(value = "/getSearchRooms", method = RequestMethod.GET)
	@ResponseBody
	public List<Room> getSearchRooms(@RequestParam("maxPricePerNight") String maxPricePerNight,
									 @RequestParam("maxPriceForFood")String maxPriceForFood,
									 @RequestParam("maxAmountOfBeds") String maxAmountOfBeds,
									 @RequestParam("type") String type) {

		return iRoomService.getSearchRooms(Double.parseDouble(maxPricePerNight),
				Double.parseDouble(maxPriceForFood),
				Integer.parseInt(maxAmountOfBeds),type);


	}

	@RequestMapping(value = "/deleteRoom", method = RequestMethod.DELETE)
	@ResponseBody
	public Boolean deleteRoom(@RequestParam("roomId") String roomId) {

		return iRoomService.deleteRoom(roomId);


	}

	@RequestMapping(value = "/postRoom", method = RequestMethod.POST)
	@ResponseBody
	public void postRoom(@ModelAttribute Room room) {

		iRoomService.postRoom(room);


	}

	@RequestMapping(value = "/putRoom", method = RequestMethod.PUT)
	@ResponseBody
	public void putRoom(@ModelAttribute Room room) {

		iRoomService.putRoom(room);


	}

	@RequestMapping(value = "/getReservations", method = RequestMethod.GET)
	@ResponseBody
	public List<Reservation> getReservations() {

		return iReservationService.getReservations();


	}

	@RequestMapping(value = "/getReservationsByUser", method = RequestMethod.GET)
	@ResponseBody
	public List<Reservation> getReservationsByUser(@RequestParam("userId") String userId) {

		return iReservationService.getReservationsByUser(userId);


	}

	@RequestMapping(value = "/getReservationsByRoom", method = RequestMethod.GET)
	@ResponseBody
	public List<Reservation> getReservationsByRoom(@RequestParam("roomId") String roomId) {

		return iReservationService.getReservationsByRoom(roomId);


	}

	@RequestMapping(value = "/getReservationsByRoomAndUser", method = RequestMethod.GET)
	@ResponseBody
	public List<Reservation> getReservationsByRoomAndUser(@RequestParam("roomId") String roomId,
														  @RequestParam("userId") String userId) {

		return iReservationService.getReservationsByRoomAndUser(roomId,userId);


	}

	@RequestMapping(value = "/getReservationById", method = RequestMethod.GET)
	@ResponseBody
	public Reservation getReservationById(@RequestParam("reservationId") String reservationId) {

		return iReservationService.getReservationById(reservationId);

	}

	@RequestMapping(value = "/deleteReservation", method = RequestMethod.DELETE)
	@ResponseBody
	public Boolean deleteReservation(@RequestParam("reservationId") String reservationId) {

		return iReservationService.deleteReservation(reservationId);


	}

	@RequestMapping(value = "/postReservation", method = RequestMethod.POST)
	@ResponseBody
	public void postReservation(@RequestParam("roomId") String roomId,
								@RequestParam("userId") String userId,@ModelAttribute Reservation reservation) {

		iReservationService.postReservation(roomId, userId, reservation);


	}

	@RequestMapping(value = "/putReservation", method = RequestMethod.PUT)
	@ResponseBody
	public void putReservation(@ModelAttribute Reservation reservation) {

		iReservationService.putReservation(reservation);


	}


	
}
