package com.linesum.example.controller;

import com.linesum.example.bean.Hotel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 宾馆controller
 * @author wdongsen@linesum.com
 * @data 2017-07-10 14:43
 */
@RestController
@RequestMapping("/hotel")
@Api("HotelController相关api")
public class HotelController {

    @ApiOperation("获取酒店Hotel信息：getHotelWithQueryParameter")
    @RequestMapping(value="/getHotelWithQueryParameter",method= RequestMethod.GET)
    public Hotel getHotelWithQueryParameter(@RequestParam("hotelname") String hotelname) throws InterruptedException {
        Thread.sleep(5000);
        return new Hotel(1314, "玫瑰酒店");
    }

    @ApiOperation("获取酒店Hotel信息：getHotelList")
    @RequestMapping(value="/getHotelList",method=RequestMethod.POST)
    public List<Hotel> getHotelList() {
        List<Hotel> hotelList = new ArrayList<>();
        hotelList.add(new Hotel(1314, "玫瑰酒店"));
        hotelList.add(new Hotel(2046, "2046酒店"));
        return hotelList;
    }

    @ApiOperation("获取酒店Hotel信息：getHotelListWithBody")
    @RequestMapping(value="/getHotelListWithBody",method=RequestMethod.POST)
    public List<Hotel> getHotelListWithBody(@RequestBody Hotel hotel) {
        List<Hotel> hotelList = new ArrayList<>();
        if(hotel.getName().equals("武林酒店")){
            hotelList.add(new Hotel(13141, "玫瑰酒店1"));
            hotelList.add(new Hotel(20461, "2046酒店1"));
            return hotelList;
        }
        hotelList.add(new Hotel(1314, "玫瑰酒店"));
        hotelList.add(new Hotel(2046, "2046酒店"));
        return hotelList;
    }
}
