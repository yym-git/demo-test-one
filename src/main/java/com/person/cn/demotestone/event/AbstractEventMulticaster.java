package com.person.cn.demotestone.event;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.event
 * @updateUser
 * @date 23:142020/10/25
 */
public   abstract class AbstractEventMulticaster implements  EventMulticaster {
    private List<WeatherListener> weatherListenerList = new ArrayList<>();
    @Override
    public void multicasterEvent(WeatherEvent event) {
        doStart();
        weatherListenerList.forEach(i->i.onWeatherEvent(event));
        doEnd();
    }

    @Override
    public void addListener(WeatherListener weatherListener) {
        weatherListenerList.add(weatherListener);
    }

    @Override
    public void removerListener(WeatherListener weatherListener) {
        weatherListenerList.remove(weatherListener);
    }

    abstract  void  doStart();
    abstract  void  doEnd();
}
