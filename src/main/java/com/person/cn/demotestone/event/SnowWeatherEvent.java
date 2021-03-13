package com.person.cn.demotestone.event;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.event
 * @updateUser
 * @date 22:512020/10/25
 */
public class SnowWeatherEvent extends WeatherEvent {
    @Override
    public String getWeather() {
        return "下雪了";
    }
}
