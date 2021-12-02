package fr.lernejo.tester.internal;

import fr.lernejo.api.TestMethod;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TestClassDiscoverer {
    String Package_name;
    public TestClassDiscoverer(String p_name){
        this.Package_name = p_name;
    }
   public List<TestClassDescription> listTestClass(){
        List<TestClassDescription> result = new ArrayList<>();
        Reflections reflections = new Reflections(this.Package_name, new SubTypesScanner(false));
        Set<Class<?>> allTypes = reflections.getSubTypesOf(Object.class);
        for (Class<?> classe : allTypes){
            if (classe.isAnnotationPresent(TestMethod.class) && classe.getName().contains("LernejoTests")){
                result.add(new TestClassDescription(classe));
            }
        }
        return result;
    }
}
