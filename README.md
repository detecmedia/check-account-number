# Check Account Number

Kontonummer prüfen in Java.

befindet sich noch im Aufbau. 

include from github

##### Add the repository in the pom.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd"
        >
    <!--...-->
    <properties>
        <!--...-->
        <!-- Edit here the version -->
        <check-account-number.version>0.0.1</check-account-number.version>
        <!--...-->
    </properties>
    
    <modelVersion>4.0.0</modelVersion>
    <groupId>de.detecmedia</groupId>
    <artifactId>demo</artifactId>
    <version>1.0-SNAPSHOT</version>
    
    <repositories>
        <!--...-->
        <repository>
            <id>checkaccountnumber-mvn-repo</id>
            <url>https://raw.github.com/detecmedia/check-account-number/mvn-repo/</url>
            <snapshots>
                <enabled>true</enabled>
                <updatePolicy>always</updatePolicy>
            </snapshots>
        </repository>
        <!--...-->
    </repositories>
        
    <dependencies>
        <!--...-->
        <dependency>
            <groupId>de.detecmedia</groupId>
            <artifactId>check-account-number</artifactId>
            <version>${check-account-number.version}</version>
        </dependency>
        <!--...-->
    </dependencies>
    <!--...-->
</project>
```

##### Example
```java
package de.detecmedia.demo;

import de.detecmedia.checkaccountnumber.CheckAccountNumber;

public class Main {

    public static void main(String[] args) {

        String method = "00";

        ClassLoader classLoader = Main.class.getClassLoader();

        Class aClass = null;
        try {
            aClass = classLoader.loadClass(
                    "de.detecmedia.checkaccountnumber.Method" + method);

            CheckAccountNumber checkAccountNumber =
                    (CheckAccountNumber) aClass.newInstance();

            checkAccountNumber.setAccountNumber("9290701");
            System.out.println(checkAccountNumber.test());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e ) {
            e.printStackTrace();
        }

    }
}


```

