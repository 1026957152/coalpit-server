package com.coalvalue.web;


import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yunpxu on 1/7/2015.
 * Step 1: Login flow
 * Step 2: Register flow
 * Step 3: Reset password flow
 */
@Controller
@RequestMapping("live")
public class LiveController extends BaseController {




    private Set streams = new HashSet<>();
    //Step 1.1: render login UI
    @RequestMapping(value = "/sign_in-login", method = RequestMethod.GET)
    @ResponseBody
    public Map login(HttpSession session,
                        @RequestParam(value = "return_to", required = false) String return_to,
                        Map<String, Object> model) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("status", true);

/*
        TulingApiProcess httpClient = new TulingApiProcess();
        httpClient.getTulingResult();*/

        return result;

    }


    //Step 1.1: render login UI
    @RequestMapping(value = "/room/id/speak", method = RequestMethod.POST)
    @ResponseBody
    public Map respons(@RequestBody JSONObject jsonObj,
                     @RequestParam(value = "steamNamer", required = false) String streamName,
                     @RequestParam(value = "body", required = false) String body,


                     Map<String, Object> model,HttpServletResponse response, HttpServletRequest request) {

        streams.add(streamName);


        Map<String, Object> result = new HashMap<String, Object>();
        result.put("status", true);



        return result;

    }

    @RequestMapping(value = "/getStreams", method = RequestMethod.GET)
    @ResponseBody
    public Map getStreams(HttpSession session,
                     @RequestParam(value = "return_to", required = false) String return_to,
                     Map<String, Object> model) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("status", true);
        result.put("date", streams);
        return result;

    }

    /**
     * 验证邮箱地址是否正确
     * @param email
     * @return
     */
    public static boolean checkEmail(String email){
        boolean flag = false;
        try{
            String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        }catch(Exception e){
            flag = false;
        }

        return flag;
    }
    /**
     * 验证手机号码
     * @param mobiles
     * @return  [0-9]{5,9}
     */
    public static boolean isMobileNO(String mobiles){
        boolean flag = false;
        try{
            Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
            Matcher m = p.matcher(mobiles);
            flag = m.matches();
        }catch(Exception e){
            flag = false;
        }
        return flag;
    }

    public static boolean isNum(String number){
        boolean flag = false;
        try{
            Pattern p = Pattern.compile("^[0-9]{5}$");
            Matcher m = p.matcher(number);
            flag = m.matches();
        }catch(Exception e){
            flag = false;
        }
        return flag;
    }
}
