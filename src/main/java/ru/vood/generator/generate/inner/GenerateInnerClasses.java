package ru.vood.generator.generate.inner;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.codehaus.mojo.jaxb2.javageneration.XjcMojo;

public class GenerateInnerClasses {

    public static void main(String[] args) throws MojoFailureException, MojoExecutionException {
        generate();
    }

    static void generate() throws MojoFailureException, MojoExecutionException {
        XjcMojo xjcMojo = new VoodXjcMojo();
        xjcMojo.execute();

    }
}
