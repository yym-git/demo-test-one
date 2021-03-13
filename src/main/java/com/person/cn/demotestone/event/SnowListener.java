package com.person.cn.demotestone.event;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.event
 * @updateUser
 * @date 22:562020/10/25
 */
public class SnowListener implements  WeatherListener {
    @Override
    public void onWeatherEvent(WeatherEvent event) {
        if(event instanceof  SnowWeatherEvent){
            System.out.println("下雪监听器监听到："+event.getWeather());
        }
    }
}
