package tn.esprit.springboot.repository;


import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.springboot.entity.User;



@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	
	@Query("SELECT AVG(u.salaire) from User u")
	float retrievemoysalaire();

	@Query("SELECT COUNT(u.salaire)*AVG(u.salaire) from User u")
	float retrievesommesalaire();
	
	@Query("SELECT MAX(u.salaire) from User u")
	float retrievemaxsalaire();
	
	@Query("SELECT u.role FROM User u where  u.idUser =:id")
	public String getUserRole(@Param("id")int id);
	
	@Query("SELECT CONCAT(u.username,CONCAT(' ',u.lastNameUser)) FROM User u where  u.stateUser =TRUE")
	public List<String> getUsersFromActivated();
	
	@Query("SELECT CONCAT(u.username,CONCAT(' ',u.lastNameUser)) FROM User u where  u.stateUser =FALSE")
	public List<String> getUsersFromDisabled();
	
	@Query("Select u FROM User u where u.role= :role")
	List<User> findAllByRole(@Param("role") User user);

	@Query("SELECT e.username,e.emailUser FROM User e")
	List<String> getAllClientNames();
	
	@Query("SELECT e.phoneNumberUser,e.adressUser FROM User e GROUP BY e.adressUser")
	List<String> getphonegroupbyadress();
	

}

