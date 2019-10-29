package com.banksteel.generics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 1)? 通配符类型<? extends T> 表示类型的上界，表示参数化类型的可能是T 或是 T的子类;
   2)<? super T> 表示类型下界（Java Core中叫超类型限定），表示参数化类型是此类型的超类型（父类型），直至Object;
   3)上界<? extends T>不能往里存，只能往外取
   4)下界<? super T> 只能往里存，不能往外取
  
   PECS原则
            最后看一下什么是PECS（Producer Extends Consumer Super）原则，已经很好理解了：
            
            频繁往外读取内容的，适合用上界Extends。
            经常往里插入的，适合用下界Super。
 *
 */
public class Test {
    public static void main(String[] args) {
        List<? extends Father> list = new LinkedList<>();
        //list.add(new Son());
        List<? extends Father> list1 = getFatherList();
        Human human = list1.get(0);
        Father father = list1.get(0);
        Son son = (Son) list1.get(0);
        
        // 下界
        //super只能添加Father和Father的子类，不能添加Father的父类,读取出来的东西只能存放在Object类里
        List<? super Father> list2 = new ArrayList<>();
        list2.add(new Father());
        //list2.add(new Human());//compile error 
        list2.add(new Son());
        
        // 因为下界规定了元素的最小粒度的下限，实际上是放松了容器元素的类型控制。既然元素是Father的基类，那往里存粒度比Father小的都可以。
        // 出于对类型安全的考虑，我们可以加入Father对象或者其任何子类（如Son）对象，但由于编译器并不知道List的内容究竟是Father的哪个超类，因此不允许加入特定的任何超类（如Human）。
        // 而当我们读取的时候，编译器在不知道是什么类型的情况下只能返回Object对象，因为Object是任何Java类的最终祖先类。但这样的话，元素的类型信息就全部丢失了。
       // Father person1 = list2.get(0);//compile error 
       // Son son = list2.get(0);//compile error 
        Object object1 = list2.get(0);
        new Test().testType();
    }
    
    /**
     * 泛型擦除
     */
    public void testType() {
        ArrayList<Integer> collection1 = new ArrayList<Integer>();
        ArrayList<String> collection2 = new ArrayList<String>();

        System.out.println(collection1.getClass() == collection2.getClass());
        // 两者class类型一样,即字节码一致

        System.out.println(collection2.getClass().getName());
        // class均为java.util.ArrayList,并无实际类型参数信息
    }

    private static List<? extends Father> getFatherList() {
        List<Son> list1 = new ArrayList<Son>();
        list1.add(new Son());
        
        return list1;
    }
}


class Human {
}


class Father extends Human {
}


class Son extends Father {
}


class LeiFeng extends Father {
}

class ZhagnSan {
}
