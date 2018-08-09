package com.demo.doc.api;

import com.alibaba.fastjson.JSONObject;
import com.demo.doc.service.BillService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@EnableAutoConfiguration
@RequestMapping("/bill")
public class BillApi {

    @Resource
    private BillService billService;

    @RequestMapping(value = "/addbill", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public  String addBill(@RequestBody JSONObject jsonParam){

        if (jsonParam.containsKey("roomid")){
            long roomid = jsonParam.getLongValue("roomid");
            String r_bdate = jsonParam.getString("r_bdate");
            String r_edate = jsonParam.getString("r_edate");
            double r_price = jsonParam.getDoubleValue("r_price");

            String w_bdate = jsonParam.getString("w_bdate");
            String w_edate = jsonParam.getString("w_edate");
            double w_price = jsonParam.getDoubleValue("w_price");
            double w_bqty = jsonParam.getDoubleValue("w_bqty");
            double w_eqty = jsonParam.getDoubleValue("w_eqty");

            String e_bdate = jsonParam.getString("e_bdate");
            String e_edate = jsonParam.getString("e_edate");
            double e_price = jsonParam.getDoubleValue("e_price");
            double e_bqty = jsonParam.getDoubleValue("e_bqty");
            double e_eqty = jsonParam.getDoubleValue("e_eqty");

            String s_bdate = jsonParam.getString("s_bdate");
            String s_edate = jsonParam.getString("s_edate");
            double s_price = jsonParam.getDoubleValue("s_price");
            billService.addBill(roomid,r_bdate,r_edate,r_price,w_bdate,w_edate,w_bqty,w_eqty,w_price,e_bdate,e_edate,e_bqty,e_eqty,
                    e_price,s_bdate,s_edate,s_price);


        }else {

        }
        return "";
    }

    @RequestMapping("/getlast")
    public Map getLastData(@RequestParam(value = "id") long roomId){
        return billService.getLastData(roomId);
    }

    @RequestMapping("/getprint")
    public List getLastData(@RequestParam(value = "ids") String roomIds){
        return billService.getPrint(roomIds);
    }
}
