package com.example.herokuappdemo.controller;

import com.example.herokuappdemo.DAO.ProductEntityDAO;
import com.example.herokuappdemo.DAO.UserDAO;
import com.example.herokuappdemo.entity.ProductEntity;
import com.example.herokuappdemo.entity.User;
import com.example.herokuappdemo.service.MailSenderService;
import com.example.herokuappdemo.service.MovieRequestService;
import com.example.herokuappdemo.service.QRGeneratorService;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Controller
public class MainController {
    @Autowired
    ProductEntityDAO productEntityDAO;
    @Autowired
    UserDAO userDAO;
    @Autowired
    MovieRequestService movieRequestService;
    @Autowired
    private MailSenderService mailSender;

    @GetMapping("/xxx")
    @ResponseBody
    public String getMainPage() {


        System.out.println("Yazdı");
        List<ProductEntity> listEveryone = productEntityDAO.findAll();
        return listEveryone.toString();

    }

    @GetMapping("/login")
    public String getIndex() {

        return "index";
    }

    @GetMapping("/")
    public String getMainPages() {
        final String uri = "https://api3.binance.com/api/v3/time";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        System.out.println(result);
        return "landingpage";
    }

    @GetMapping("/getquery")
    public String homePage() {

        return "akinjquery";
    }

    @GetMapping("/register")
    public String registerPage() {


        return "registerpage";
    }


    @PostMapping("/registernow")
    public String registerPost(@RequestParam(value = "username", required = false) String username,
                               @RequestParam(value = "password", required = false) String password) {


        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String enCodedPassowrd = bCryptPasswordEncoder.encode(password);

        User user = new User(username, enCodedPassowrd, "user", true);
        userDAO.save(user);
        User user32 = userDAO.findByUserName("aknkya");
        /*  if(userDAO.findByUserName(username) !=null && !userDAO.findByUserName(username).getUserName().isEmpty()){


              mailSender.sendMail("akn_kya@hotmail.com","Yeni üye kaydı",username+"  Isımlı Uye Sısteme Kayıt Olmustur Sıfresı: "+ password);
              List<User> userList= userDAO.findAll();
              mailSender.sendMail("akn_kya@hotmail.com","uye listesi",userList.toString());
              System.out.println(userList.toString());

              return "index";
         }*/


        return "index";
    }

    @GetMapping("/qr")
    public String getQRCode(Model model) {

        byte[] image = new byte[0];
        try {

            // Generate and Return Qr Code in Byte Array
            image = QRGeneratorService.getQRCodeImage("https://www.facebook.com/", 250, 250);

            // Generate and Save Qr Code Image in static/image folder


        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
        String qrcode = Base64.getEncoder().encodeToString(image);

        model.addAttribute("qrcode", qrcode);
        return "qrcode";
    }

    @GetMapping("/oyun")
    public String getOyun() {

        return "oyun";

    }

    @GetMapping("/d3")
    public String getd3(Model model) throws URISyntaxException {


        movieRequestService.getList();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        for (int i = 0; i < 100; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(1, 500 + 1);
            arrayList.add(randomNum);
        }

        model.addAttribute("datalar", arrayList);

        return "d3";
    }


    @GetMapping("/getusers")
    public String getUserPage(Model model) {
        List<User> users = userDAO.findAll();
        model.addAttribute("users", users);
        return "userlist";
    }

}
