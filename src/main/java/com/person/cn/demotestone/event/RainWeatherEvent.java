package com.person.cn.demotestone.event;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.event
 * @updateUser
 * @date 22:522020/10/25
 */
public class RainWeatherEvent extends WeatherEvent {
    @Override
    public String getWeather() {
        return "下雨了";
    }
}
