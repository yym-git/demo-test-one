package com.person.cn.demotestone.designmodel.composite;

/**
 * @author ym.y
 * @description 该模式最大的缺点：没办法对容器的构建类型进行控制，
 * 如：视频文件夹中只能保存视频文件，文本文件夹中
 * 只能保存文本文件等
 * @package com.person.cn.demotestone.designmodel.composite
 * @updateUser
 * @date 16:18 2020/12/13
 */
public class Client {
    public static void main(String[] args) {
        AbstractFile file1, file2, file3, file4, file5, folder1, folder2, folder3, folder4;
        folder1 = new Folder("Sunny的资料");
        //图片文件夹
        folder2 = new Folder("图像文件");
        //文本文件夹
        folder3 = new Folder("文本文件");
        //视频文件夹
        folder4 = new Folder("视频文件");
        file1 = new ImageFile("小龙女.jpg");
        file2 = new ImageFile("张无忌.gif");
        file3 = new TextFile("九阴真经.txt");
        file4 = new TextFile("葵花宝典.dco");
        file5 = new VideoFile("笑傲江湖.mp4");
        folder2.add(file1);
        folder2.add(file2);
        folder3.add(file3);
        folder3.add(file4);
        folder4.add(file5);
        //视频文件夹中可以添加图片文件
        folder4.add(file1);
        folder1.add(folder2);
        folder1.add(folder3);
        folder1.add(folder4);
        //从"Sunny的资料"节点开始进行杀毒操作
//        folder1.killVirus();
        //如果只对视频文件进行杀毒,则只需要更改节点即可
        folder3.killVirus();
    }

}
