package myProject.coursework.petrolExp.mapper;

import myProject.coursework.petrolExp.dto.DateDiff;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Armine on 15/12/2017.
 */
public class DateDiffMapper implements RowMapper<DateDiff> {
    @Override
    public DateDiff mapRow(ResultSet resultSet, int i) throws SQLException {
        int dateDiff = resultSet.getInt("dateDiff");
        DateDiff dateDiff1 = new DateDiff(dateDiff);
        return dateDiff1;
    }
}
