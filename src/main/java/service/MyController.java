package service;

import dao.Dao;
import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

@Controller

public class MyController {


    Dao dao;
    @Autowired

    public void setDao(Dao dao)
    {
        this.dao=dao;
    }




    @RequestMapping(value = "/check.com" ,method = RequestMethod.GET)
    public String Login(Model model)
    {

        Customer customer=new Customer();
        model.addAttribute("user",customer);

        return "burgerpoint";
    }

@RequestMapping(value="/checkb.com",method = RequestMethod.POST)

       public String check(HttpServletRequest request,  @ModelAttribute("customer")  Customer customer,
                           BindingResult errors,
                           Model model, HttpServletResponse response) throws ServletException, IOException {

    if (errors.hasErrors()) {
        System.out.println("errors"+errors.getTarget()+errors.getModel());
        return "burgerpoint";
    }
            String firstname=request.getParameter("firstname");
            String burgers[] =request.getParameterValues("burger");
    System.out.println(burgers);
            ArrayList<String> choice=new ArrayList<>();

            String customization[]=request.getParameterValues("customization");


            String size=request.getParameter("burgerSize");

            ArrayList<String> choices=new ArrayList<>();
    String burger1="";
    String custom="";
            int sum=0;
            int toppingAdded=10;
            int totalsum=30;
            ArrayList<String> choiceBurger=new ArrayList<>();

            if(burgers== null)
            {
                return "burgerNotFound";
            }

            for(int i=0;i<burgers.length;i++)
            {
                choice.add(burgers[i]);
            }

            for(int i=0;i<burgers.length;i++)
            {/*ArrayList<String> payment=new ArrayList<>();
               payment.add(burgers[i]);
               for(int j=0;j<payment.get(i).length();j++)
               {

               }*/
                int burger;

                burger=Integer.parseInt(burgers[i]);
                sum=sum+burger;

            }
    for(int i=0;i<burgers.length;i++)
    {
       burger1=burger1+burgers[i]+" ";

    }
    for(int i=0;i<customization.length;i++)
    {
        custom=custom+customization[i]+" ";

    }
    customer.setBurgers(burger1);
    customer.setCustomizations(custom);
    for (String b: choice) {
        switch (b){
            case "60":
                choiceBurger.add("Fishburger");
                break;
            case "50":
                choiceBurger.add("ChickenBurger: &#8377 50");
                break;

            case "100":
                choiceBurger.add("ClassicBurger: &#8377 100");
                break;

            case "150":
                choiceBurger.add("DoubleBurger: &#8377 150");
                break;

            case "40":
                choiceBurger.add("Fries: &#8377 40");
                break;



        }
    }




           /* if(burgers.length>1)
            {
                for (int i=0;i<choice.size();i++)
                {

                }
            }*/

    if(size == null)
    {
        return "sizeBurgur";
    }
    else {

        if (size.equals("Large")) {
            totalsum = totalsum + sum + toppingAdded;
        } else {
            totalsum = sum + toppingAdded;
        }
    }


            ArrayList<String> topping=new ArrayList<>();
            for(int i=0;i<customization.length;i++)
            {
                topping.add(customization[i]);
            }

            ArrayList<String> burgerchoice=new ArrayList<>();

            for(int i=0;i<choiceBurger.size();i++)
            {
                burgerchoice.add(choiceBurger.get(i));
            }


            Customer customer1=new Customer();

            model.addAttribute("BuyerName",firstname);
            model.addAttribute("BurgerChosen",choiceBurger);
            model.addAttribute("sum",sum);
            model.addAttribute("toppingAdded",toppingAdded);
            model.addAttribute("ToppingCustomization",topping);
            model.addAttribute("size",size);
            model.addAttribute("GrandTotal",totalsum);


            customer1.setFirstname(firstname);
            String choices1="";
            for(int i=0;i<choiceBurger.size();i++)
            {
               choices1=choices1+choiceBurger.get(i)+" ";
                System.out.println(choiceBurger.get(i));
            }
            customer1.setBurgers(choices1);
            customer1.setBurger(choice);
            customer1.setCustomization(topping);
            customer1.setBurgerSize(size);





            /*
            if(firstname!=null)
            {
                RequestDispatcher rd=request.getRequestDispatcher("bill");
                rd.include(request, response);
            }*/
    try {
        dao.insert(customer);
    }
    catch (Exception e)
    {
        System.out.println(e);
    }
            return "bill";
        }
    @RequestMapping({"/recheck.do"})
    public String Recheck() {
        return "Hellorecheck";
    }

}
