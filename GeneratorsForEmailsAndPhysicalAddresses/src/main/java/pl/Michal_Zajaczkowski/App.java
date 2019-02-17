package pl.Michal_Zajaczkowski;

import pl.Michal_Zajaczkowski.Generator.Generator;

public class App
{
    public static void main( String[] args ) {
        Generator generator = new Generator();
        String generatorText = generator.getRandomString();
        System.out.println(generator.addDomain(generatorText));
    }
}
