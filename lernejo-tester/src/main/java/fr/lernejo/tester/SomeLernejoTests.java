package fr.lernejo.tester;

import fr.lernejo.api.TestMethod;

public class SomeLernejoTests {


    @TestMethod
    public void ok(){

    }
    @TestMethod
    public void ko(){
        new IllegalStateException();
    }

    public void none(){

    }
}
