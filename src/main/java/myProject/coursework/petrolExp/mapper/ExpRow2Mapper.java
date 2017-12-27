package myProject.coursework.petrolExp.mapper;

import myProject.coursework.petrolExp.dto.Expenditure;
import myProject.coursework.petrolExp.dto.PetrolExp;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Armine on 12/12/2017.
 */
public class ExpRow2Mapper implements RowMapper<Expenditure> {
    @Override
    public Expenditure mapRow(ResultSet resultSet, int i) throws SQLException {
        Integer id = resultSet.getInt("ID");
        Date date = resultSet.getDate("Date");
        String brand = resultSet.getString("Brand");
        Integer mileage = resultSet.getInt("Mileage");
        Integer g_quantity = resultSet.getInt("G_quantity");
        Integer cost = resultSet.getInt("Cost");
        Expenditure expenditure = new Expenditure(id,date,brand,mileage,g_quantity,cost);
        return expenditure;
    }
}
