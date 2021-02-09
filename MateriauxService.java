package Service;

import core.entity.Materiaux;

import java.util.List;
import repository.MateriauxRepositoryImpl;

public class MateriauxService {

    private MateriauxRepositoryImpl materiauxRepository;
    
    public MateriauxService(){
        materiauxRepository=new MateriauxRepositoryImpl();
    }
    
    public Materiaux getMateriaux(String nom){
        return materiauxRepository.getByNom(nom);
       
    }
    
    public void updateMateriaux(Materiaux materiaux){
   
        materiauxRepository.update(materiaux);
    }
    
    public List<Materiaux> getListMateriaux(){
        
        return materiauxRepository.list();
    }
}
