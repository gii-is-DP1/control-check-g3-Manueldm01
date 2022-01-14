package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecoveryRoomService {
	
	@Autowired
	RecoveryRoomRepository recoveryroomrepo;
	
    public List<RecoveryRoom> getAll(){
        return this.recoveryroomrepo.findAll();
    }

    public List<RecoveryRoomType> getAllRecoveryRoomTypes(){
        return this.recoveryroomrepo.findAllRecoveryRoomTypes();
    }

    public RecoveryRoomType getRecoveryRoomType(String typeName) {
        return this.recoveryroomrepo.getRecoveryRoomType(typeName);
    }

    public List<RecoveryRoom> getRecoveryRoomsBiggerThan(double size) {
        return this.recoveryroomrepo.findBySizeMoreThan(size);
    }

    public RecoveryRoom save(RecoveryRoom p) {
        return this.recoveryroomrepo.save(p);       
    }

    
}
