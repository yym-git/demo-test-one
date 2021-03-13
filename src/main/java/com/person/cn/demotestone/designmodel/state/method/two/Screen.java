package com.person.cn.demotestone.designmodel.state.method.two;

/**
 * @author ym.y
 * @description 屏幕类
 * 场景：点击一次屏幕放大2倍，再点击一次放大4倍，再点击则恢复原来的大小
 * @package com.person.cn.demotestone.state.method.two
 * @updateUser
 * @date 13:12 2020/12/17
 */
public class Screen {
    private AbstractState normalState, largerState, largestState, currentState;

    public Screen() {
        normalState = new NormalState();
        largerState = new LargerState();
        largestState = new LargestState();
        currentState = normalState;
    }

    private void setState(AbstractState state) {
        this.currentState = state;
    }

    /**
     * @description   点击屏幕
     * @author ym.y
     * @updateUser
     * @date  13:19 2020/12/17
     */
    public void onClick() {
        this.currentState.display();
        if (this.currentState == normalState) {
            this.setState(largerState);
        } else if (this.currentState == largerState) {
            this.setState(largestState);
        } else if (this.currentState == largestState) {
            this.setState(normalState);
        }
    }
}
