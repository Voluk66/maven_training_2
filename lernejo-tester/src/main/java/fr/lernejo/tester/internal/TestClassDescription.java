package fr.lernejo.tester.internal;


import fr.lernejo.api.TestMethod;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class TestClassDescription {
    Class<?> Classe;
    public TestClassDescription(Class<?> p_Class){
        this.Classe = p_Class;
    }
    public List<Method> listTestMethods(){
        List<Method> result = new ArrayList<>();
        List<Method> pass = List.of(this.Classe.getDeclaredMethods());
        int size = pass.size();
        for (int i = 0 ; i < size; i++){
            if (Modifier.isPublic(pass.get(i).getModifiers())){
                if (pass.get(i).getReturnType().equals(Void.TYPE)) {
                    if (pass.get(i).isAnnotationPresent(TestMethod.class)) {
                        if (pass.get(i).getParameterTypes().length == 0) {
                            result.add(pass.get(i));
                        }
                    }
                }
            }
        }

        return result;
    }
}
