package myProject.coursework.petrolExp.mapper;

import myProject.coursework.petrolExp.dto.PetrolExp;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Armine on 06/12/2017.
 */
public class ExpRowMapper implements RowMapper<PetrolExp> {
    @Override
    public PetrolExp mapRow(ResultSet resultSet, int i) throws SQLException {
        Integer id = resultSet.getInt("exp_inf.ID");
        Date date = resultSet.getDate("exp_inf.Date");
        String brand = resultSet.getString("petrol_inf.Brand");
        Integer mileage = resultSet.getInt("exp_inf.Mileage");
        Integer g_quantity = resultSet.getInt("exp_inf.G_quantity");
        Integer price = resultSet.getInt("petrol_inf.Price");
        Integer cost = resultSet.getInt("exp_inf.Cost");
        PetrolExp expenditure = new PetrolExp(id,date,brand,mileage,g_quantity,price,cost);
        return expenditure;
    }
}
