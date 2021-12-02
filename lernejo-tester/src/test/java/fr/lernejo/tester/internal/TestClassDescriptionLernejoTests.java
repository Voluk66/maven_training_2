package fr.lernejo.tester.internal;

import fr.lernejo.tester.SomeLernejoTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
public class TestClassDescriptionLernejoTests {
    TestClassDescription classtest = new TestClassDescription(SomeLernejoTests.class);

    public static void main(String[] args) {
        TestClassDescriptionLernejoTests test = new TestClassDescriptionLernejoTests();
        test.test();
    }
    @Test
    void test()  {
        List<Method> listTest = this.classtest.listTestMethods();

        List<Method> Listref = new ArrayList<>();
        System.out.println("Debut du test");
        int size = listTest.size();
        try {
            Listref.add(this.classtest.Classe.getDeclaredMethod("ok"));
            Listref.add(this.classtest.Classe.getDeclaredMethod("ko"));
            int size2 = listTest.size();
            assertThat(size).isEqualTo(size2);
            assertThat(Listref.get(0)).isEqualTo(listTest.get(0));
            assertThat(Listref.get(1)).isEqualTo(listTest.get(1));
            for (int i = 0; i < size ; i++){
                System.out.println(listTest.get(i).toString());
            }
            System.out.println("Fin de test");
        }catch (NoSuchMethodException e){
            e.printStackTrace();
        }



        }

}
