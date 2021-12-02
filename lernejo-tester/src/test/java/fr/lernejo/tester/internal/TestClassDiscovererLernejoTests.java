package fr.lernejo.tester.internal;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TestClassDiscovererLernejoTests {
    @Test
    public void testPart5(){
        TestClassDiscoverer Testclass = new TestClassDiscoverer("fr.lernejo.tester");
        List<TestClassDescription> pass = Testclass.listTestClass();
        List<TestClassDescription> ref = new ArrayList<>();
        for (TestClassDescription classe : pass){
            
        }
    }

}
