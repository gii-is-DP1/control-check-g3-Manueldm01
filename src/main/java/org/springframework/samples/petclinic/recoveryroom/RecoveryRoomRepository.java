package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RecoveryRoomRepository extends CrudRepository<RecoveryRoom, Integer>{
	@Query("SELECT r FROM RecoveryRoom r")
	List<RecoveryRoom> findAll();
    
	@Query("SELECT r FROM RecoveryRoomType r")
    List<RecoveryRoomType> findAllRecoveryRoomTypes();
	
    Optional<RecoveryRoom> findById(int id);
    RecoveryRoom save(RecoveryRoom p);
    
    @Query("SELECT recoveryroomtype FROM RecoveryRoomType recoveryroomtype WHERE recoveryroomtype.name=:name")
    RecoveryRoomType getRecoveryRoomType(String name);
    
    @Query("SELECT recoveryroom FROM RecoveryRoom recoveryroom WHERE recoveryroom.size>:size")
    List<RecoveryRoom> findBySizeMoreThan(double size);
}
