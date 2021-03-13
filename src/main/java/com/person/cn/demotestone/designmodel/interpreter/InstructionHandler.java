package com.person.cn.demotestone.designmodel.interpreter;

import java.util.Stack;

/**
 * @author ym.y
 * @description 指令处理类：工具类
 * @package com.person.cn.demotestone.designmodel.interpreter
 * @updateUser
 * @date 13:53 2020/12/18
 */
public class InstructionHandler {
    private AbstractNode node;

    public void handle(String instruction) {
        AbstractNode left = null, right = null;
        AbstractNode distance = null, action = null, direction = null;
        //声明一个栈对象用于存储抽象语法树
        Stack<AbstractNode> stack = new Stack();
        //以空格分隔字符串
        String[] words = instruction.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].equalsIgnoreCase("and")) {
                //出栈
                left = stack.pop();
                String word1 = words[++i];
                direction = new DirectionNode(word1);
                String word2 = words[++i];
                action = new ActionNode(word2);
                String word3 = words[++i];
                distance = new DirectionNode(word3);
                right = new SentenceNode(direction, action, distance);
                //将新表达式压入栈中
                stack.push(new AndNode(left, right));
            } else {
                String word1 = words[i];
                direction = new DirectionNode(word1);
                String word2 = words[++i];
                action = new ActionNode(word2);
                String word3 = words[++i];
                distance = new DistanceNode(word3);
                left = new SentenceNode(direction, action, distance);
                //入栈
                stack.push(left);
            }
        }
        this.node = stack.pop();
    }

    public String output() {
        String result = node.interpreter();
        return result;
    }
}
