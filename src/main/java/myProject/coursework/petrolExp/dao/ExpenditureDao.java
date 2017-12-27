package myProject.coursework.petrolExp.dao;

        import myProject.coursework.petrolExp.dto.Expenditure;
        import myProject.coursework.petrolExp.dto.Petrol;
        import myProject.coursework.petrolExp.dto.PetrolExp;
        import myProject.coursework.petrolExp.mapper.DateDiffMapper;
        import myProject.coursework.petrolExp.mapper.ExpRow2Mapper;
        import myProject.coursework.petrolExp.mapper.ExpRowMapper;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.jdbc.core.JdbcTemplate;
        import org.springframework.jdbc.support.GeneratedKeyHolder;
        import org.springframework.stereotype.Repository;

        import java.sql.Date;
        import java.sql.PreparedStatement;
        import java.util.List;

/**
 * Created by Armine on 05/12/2017.
 */
@Repository
public class ExpenditureDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ExpenditureDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<PetrolExp> loadALL() {
        final String sql = "select exp_inf.Date, exp_inf.ID, petrol_inf.Brand," +
                "exp_inf.Mileage, petrol_inf.Price,exp_inf.G_quantity,exp_inf.Cost from exp_inf INNER JOIN petrol_inf ON exp_inf.Brand = petrol_inf.Brand";
        return jdbcTemplate.query(sql, new ExpRowMapper());

    }

    public void addExp(PetrolExp petrolExp) {
        final String sql = "insert into exp_inf(Date, Brand, Mileage, G_quantity,Cost) values(?,?,?,?,?)";
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDate(1, petrolExp.getDate());
            ps.setString(2, petrolExp.getBrand());
            ps.setInt(3, petrolExp.getMileage());
            ps.setInt(4, petrolExp.getG_quantity());
            ps.setInt(5, petrolExp.getCost());

            return ps;
        }, holder);


    }

    public void addPetrol(Petrol petrol) {
        final String sql = "insert into petrol_inf( Brand,Price) values(?,?)";
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, petrol.getBrand());
            ps.setInt(2, petrol.getPrice());


            return ps;
        }, holder);
    }

    public int milBetween(Date sqlStartDate1, Date sqlStartDate2) {
        final String sql1 = "select * from exp_inf where Date = ?";
        Expenditure expenditure1 =  jdbcTemplate.queryForObject(sql1,new ExpRow2Mapper(),sqlStartDate2);
        final String sql2 = "select * from exp_inf where Date = ?";
        Expenditure expenditure2 =  jdbcTemplate.queryForObject(sql2,new ExpRow2Mapper(),sqlStartDate1);
        int milBetween = expenditure2.getMileage()-expenditure1.getMileage();
        return milBetween;
    }

    public float milPerGal(String brand) {
        final String sql1 = "select * from exp_inf where Brand = ? LIMIT 1";
        Expenditure expenditure1 =  jdbcTemplate.queryForObject(sql1,new ExpRow2Mapper(),brand);
        Integer id = expenditure1.getId();
        final String sql2 = "select * from exp_inf where ID = (select min(ID) from exp_inf where ID> ?)";
        Expenditure expenditure2 =  jdbcTemplate.queryForObject(sql2,new ExpRow2Mapper(),id);
        float milPerGal = (expenditure2.getMileage() - expenditure1.getMileage())/expenditure1.getQuantity();
        return milPerGal;
    }

    public float costPerMile(String brand) {
        final String sql1 = "select * from exp_inf where Brand = ? LIMIT 1";
        Expenditure expenditure1 =  jdbcTemplate.queryForObject(sql1,new ExpRow2Mapper(),brand);
        Integer id = expenditure1.getId();
        final String sql2 = "select * from exp_inf where ID = (select min(ID) from exp_inf where ID> ?)";
        Expenditure expenditure2 =  jdbcTemplate.queryForObject(sql2,new ExpRow2Mapper(),id);
        float costPerMile = expenditure1.getCost()/(expenditure2.getMileage() - expenditure1.getMileage());
        return costPerMile;
    }

    public int oneDayCost(Date date) {
        final String sql = "select * from exp_inf where Date = ?";
        List<Expenditure> expenditures = jdbcTemplate.query(sql,new ExpRow2Mapper(),date);
        int cost = 0;
        for( Expenditure expenditure : expenditures){
            cost += expenditure.getCost();
        }
        return cost;
    }

    public float timeSpent(String brand) {
        final String sql1 = "select * from exp_inf where Brand = ? LIMIT 1";
        Expenditure expenditure1 =  jdbcTemplate.queryForObject(sql1,new ExpRow2Mapper(),brand);
        Integer id = expenditure1.getId();
        final String sql2 = "select * from exp_inf where ID = (select min(ID) from exp_inf where ID> ?)";
        Expenditure expenditure2 =  jdbcTemplate.queryForObject(sql2,new ExpRow2Mapper(),id);
        Date[] dates = {expenditure2.getDate(),expenditure1.getDate()};
        final String sql3 = "SELECT DATEDIFF(?, ?) AS dateDiff";
        int dateDiff = jdbcTemplate.queryForObject(sql3,new DateDiffMapper(),dates).getDateDiff();
        float timeSpent = expenditure1.getQuantity()/dateDiff;
        return timeSpent;
    }
}
