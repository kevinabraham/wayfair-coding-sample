package projectDAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import projectEntity.*;


@Path("/vehicle")
public class VehicleDAO {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("CS5200DBMS");
	
	public void createVehicle(Vehicle newVehicle){
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		em.persist(newVehicle);
		
	    em.getTransaction().commit();
		em.close();
	}
	
	@GET
	@Path("/VMAP/{regno}")
	@Produces(MediaType.APPLICATION_JSON)
	
	public List<VehicleShiftMapping> getMappingForVehicle(@PathParam("regno") String regno){
		List<VehicleShiftMapping> vehicleShiftMappings = new ArrayList<VehicleShiftMapping>();
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		Vehicle vehicle = em.find(Vehicle.class, regno);
		
		vehicleShiftMappings = vehicle.getVehicleShiftMappings();
		
		em.getTransaction().commit();
		em.close();		
		
		return vehicleShiftMappings;
	}

	@GET
	@Path("/ALLVEH")
	@Produces(MediaType.APPLICATION_JSON)
	
	public List<Vehicle> getAllVehicle(){
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		Query query = em.createQuery("select vehicle from Vehicle vehicle");
		vehicles = query.getResultList();
		
		em.getTransaction().commit();
		em.close();		
		
		return vehicles;
	}
	
	
	public static void main(String[] args) {
		VehicleDAO vehicleDAO = new VehicleDAO();
		Vehicle newVehicle = new Vehicle();
		List<VehicleShiftMapping> vehicleShiftMappings = new ArrayList<VehicleShiftMapping>();
		
		//vehicleShiftMappings = vehicleDAO.getMappingForVehicle("MA125");
		
		//for(VehicleShiftMapping v : vehicleShiftMappings){
		//	System.out.println(v.getShift());
		//}
		
		
		newVehicle.setRegNo("MA125");
		newVehicle.setDriverName("John");
		newVehicle.setCapacity(5);
		
		//vehicleDAO.createVehicle(newVehicle);
		
		newVehicle.setRegNo("MA500");
		newVehicle.setDriverName("Mike");
		newVehicle.setCapacity(5);
		
		//vehicleDAO.createVehicle(newVehicle);
		
		newVehicle.setRegNo("MA700");
		newVehicle.setDriverName("Nik");
		newVehicle.setCapacity(5);
		
		//vehicleDAO.createVehicle(newVehicle);
		
	}

}
