package projectDAO;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonIgnore;

import projectDAO.*;

@Entity
public class Vehicle {

	@Id
	private String regNo;
	
	private int capacity;
	private String driverName;
	@OneToMany(mappedBy="vehicle")
	@JsonIgnore
	private List<VehicleShiftMapping> vehicleShiftMappings; 
	@OneToMany(mappedBy="vehicle")
	@JsonIgnore
	private List<Request> requests;
	
	/**
	 * 
	 */
	public Vehicle() {
		super();
	}


	/**
	 * @param regNo
	 * @param capacity
	 * @param driverName
	 */
	public Vehicle(String regNo, int capacity, String driverName) {
		super();
		this.regNo = regNo;
		this.capacity = capacity;
		this.driverName = driverName;
	}


	/**
	 * @return the regNo
	 */
	public String getRegNo() {
		return regNo;
	}


	/**
	 * @param regNo the regNo to set
	 */
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}


	/**
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}


	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


	/**
	 * @return the driverName
	 */
	public String getDriverName() {
		return driverName;
	}


	/**
	 * @param driverName the driverName to set
	 */
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}


	/**
	 * @return the vehicleShiftMappings
	 */
	public List<VehicleShiftMapping> getVehicleShiftMappings() {
		return vehicleShiftMappings;
	}


	/**
	 * @param vehicleShiftMappings the vehicleShiftMappings to set
	 */
	public void setVehicleShiftMappings(
			List<VehicleShiftMapping> vehicleShiftMappings) {
		this.vehicleShiftMappings = vehicleShiftMappings;
	}


	/**
	 * @return the requests
	 */
	public List<Request> getRequests() {
		return requests;
	}


	/**
	 * @param requests the requests to set
	 */
	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}
	
	
}
