package com.pattern.template;

public abstract class Game {

    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    void openSteam(){
        System.out.println("open steam.");
    }

    /**
     * 模板,这里的play方法使用final修饰的原因是为了不让子类重写，
     * 模板模式需要定义一个骨架，也就是该方法中有固定的抽象或者已实现的方法，对于抽象的，需要子类去进行实现
     * 由此也可以看出模板模式的弊端，框架里的方法必须固定，也就是说，必须是已确定的流程才能使用模板模式
     *
     *
     * 对模板模式的初步理解：
     * 定义一个抽象类去限定该模式的框架，内部定义一个final方法设计该版本的框架，例如，转账的步骤是，打开支付宝，输入转账金额，点击转账按钮，提示转账成功
     * 例如，唐僧取经，需要经历99 81难，这81个难关就是框架
     * 例如，人的一生，出生，读书，结婚，生子，死亡，只是每一个人的出生不同、读的学校不同、和不同的人结婚、死的方式不一样
     *
     *
     *
     */
    public final void play(){
        openSteam();

        //初始化游戏
        initialize();

        //开始游戏
        startPlay();

        //结束游戏
        endPlay();
    }
}
