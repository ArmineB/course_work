package myProject.coursework.petrolExp.service;

import myProject.coursework.petrolExp.dao.ExpenditureDao;
import myProject.coursework.petrolExp.dto.Petrol;
import myProject.coursework.petrolExp.dto.PetrolExp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * Created by Armine on 06/12/2017.
 */
@Service
public class ExpenditureService {
    private final ExpenditureDao expenditureDao;

    @Autowired
    public ExpenditureService(ExpenditureDao expenditureDao) {
        this.expenditureDao = expenditureDao;
    }

    public List<PetrolExp> loadAll() {
        return expenditureDao.loadALL();
    }

    public void addExp(PetrolExp petrolExp) {
        expenditureDao.addExp(petrolExp);
    }

    public void addPetrol(PetrolExp petrolExp) {
        Petrol petrol = new Petrol(petrolExp.getBrand(),petrolExp.getPrice());
        expenditureDao.addPetrol(petrol);
    }

    public int milBetween(Date sqlStartDate1, Date sqlStartDate2) {
       return expenditureDao.milBetween(sqlStartDate1,sqlStartDate2);
    }
    public float milPerGal(String brand) {
        return expenditureDao.milPerGal(brand);
    }

    public float costPerMile(String brand) {
        return expenditureDao.costPerMile(brand);
    }

    public int oneDayCost(Date sqlStartDate) {
        return expenditureDao.oneDayCost(sqlStartDate);
    }

    public float timeSpent(String brand) {
        return expenditureDao.timeSpent(brand);
    }
}
