package com.person.cn.demotestone.iocom.nio.watchservice;

import java.nio.file.Path;
import java.nio.file.WatchEvent;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.iocom.nio
 * @updateUser
 * @date 12:222020/12/9
 */
public interface FileWatchedListener {
    void onCreated(WatchEvent<Path> watchEvent);

    void onDeleted(WatchEvent<Path> watchEvent);

    void onModified(WatchEvent<Path> watchEvent);

    void onOverflowed(WatchEvent<Path> watchEvent);
}
