package com.person.cn.demotestone.event;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.event
 * @updateUser
 * @date 23:262020/10/25
 */
public class TestMulticaster {
    public static void main(String[] args) {
        WeatherEventMulticaster eventMulticaster = new WeatherEventMulticaster();
        RainListener  rainListener = new RainListener();
        SnowListener snowListener = new SnowListener();
        eventMulticaster.addListener(rainListener);
        eventMulticaster.addListener(snowListener);
        eventMulticaster.multicasterEvent(new RainWeatherEvent());
        eventMulticaster.multicasterEvent(new SnowWeatherEvent());
        eventMulticaster.removerListener(rainListener);
        eventMulticaster.multicasterEvent(new RainWeatherEvent());
        eventMulticaster.multicasterEvent(new SnowWeatherEvent());

    }
}
