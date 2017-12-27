package myProject.coursework.petrolExp.controller;

import myProject.coursework.petrolExp.dto.PetrolExp;
import myProject.coursework.petrolExp.service.ExpenditureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Armine on 05/12/2017.
 */
@Controller
@RequestMapping("/")
public class PetrolExpController {
   private List<PetrolExp> expenditureList;
   private final ExpenditureService expenditureService;

    @Autowired
    public PetrolExpController(ExpenditureService expenditureService) {
        this.expenditureService = expenditureService;
        expenditureList=expenditureService.loadAll();
    }

    @RequestMapping("/")
    public ModelAndView homepage(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("expenditureList", expenditureList);
        return modelAndView;
    }

    @RequestMapping( value = "/add", method = RequestMethod.POST)
    public  ModelAndView addExp(HttpServletRequest req)throws Exception{
        String startDate=req.getParameter("date");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = sdf1.parse(startDate);
        java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
        String brand = req.getParameter("brand");
        int mileage = Integer.parseInt(req.getParameter("mileage"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        int price = Integer.parseInt(req.getParameter("price"));
        int cost = Integer.parseInt(req.getParameter("cost"));
        PetrolExp petrolExp = new PetrolExp(sqlStartDate,brand,mileage,quantity,price,cost);

       expenditureService.addExp(petrolExp);
       ModelAndView modelAndView = new ModelAndView("add");
       return modelAndView;
    }

    @RequestMapping(value = "/milBetween", method = RequestMethod.POST)
    public ModelAndView milBetween(HttpServletRequest req) throws Exception{
        String startDate1=req.getParameter("date1");
        SimpleDateFormat sdf11 = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = sdf11.parse(startDate1);
        java.sql.Date sqlStartDate1 = new java.sql.Date(date.getTime());

        String startDate2=req.getParameter("date2");
        SimpleDateFormat sdf12 = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date2 = sdf12.parse(startDate2);
        java.sql.Date sqlStartDate2 = new java.sql.Date(date2.getTime());
        int milBetween = expenditureService.milBetween(sqlStartDate1,sqlStartDate2);
        ModelAndView modelAndView = new ModelAndView("mileageBetween");

        modelAndView.addObject("milBetween",milBetween);
        return modelAndView;
    }

    @RequestMapping(value = "/milPerGal", method = RequestMethod.POST)
    public ModelAndView milPerGal(HttpServletRequest req){
        String brand = req.getParameter("petBrand");
        float milPerGal = expenditureService.milPerGal(brand);
        ModelAndView modelAndView = new ModelAndView("milPerGallon");

        modelAndView.addObject("milPerGal",milPerGal);
        return modelAndView;
    }

    @RequestMapping(value = "/costPerMile", method = RequestMethod.POST)
    public ModelAndView costPerMile(HttpServletRequest req){
        String brand = req.getParameter("petBrand2");
        float costPerMile = expenditureService.costPerMile(brand);
        ModelAndView modelAndView = new ModelAndView("costMilPerMile");

        modelAndView.addObject("costPerMile",costPerMile);
        return modelAndView;
    }

    @RequestMapping(value = "/oneDayCost", method = RequestMethod.POST)
    public ModelAndView oneDayCost(HttpServletRequest req) throws Exception{
        String startDate1=req.getParameter("date3");
        SimpleDateFormat sdf11 = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = sdf11.parse(startDate1);
        java.sql.Date sqlStartDate1 = new java.sql.Date(date.getTime());

        int oneDayCost = expenditureService.oneDayCost(sqlStartDate1);
        ModelAndView modelAndView = new ModelAndView("OneDayCost");

        modelAndView.addObject("oneDayCost",oneDayCost);
        return modelAndView;
    }

    @RequestMapping(value = "/timeSpent", method = RequestMethod.POST)
    public ModelAndView timeSpent(HttpServletRequest req){
        String brand = req.getParameter("petBrand3");
        float timeSpent = expenditureService.timeSpent(brand);
        ModelAndView modelAndView = new ModelAndView("timeSpentG");

        modelAndView.addObject("timeSpent",timeSpent);
        return modelAndView;
    }

}
