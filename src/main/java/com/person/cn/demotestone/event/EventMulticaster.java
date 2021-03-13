package com.person.cn.demotestone.event;

/**
 * 广播器
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.event
 * @updateUser
 * @date 23:102020/10/25
 */
public interface EventMulticaster {
    /**
     * 广播事件
     * @param event
     */
    void multicasterEvent(WeatherEvent event);

    /**
     *添加监听器
     * @param weatherListener
     */
    void addListener(WeatherListener weatherListener);

    /**
     * 移除监听器
     * @param weatherListener
     */
    void  removerListener(WeatherListener weatherListener);
}
