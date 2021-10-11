package edu.escuelaing.arep;

import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
        port(getPort());
        staticFileLocation("/public");
        secure("keystores/ecikeystore.p12", "123456", "keystores/myTrustStore", "123456");
        get("/helloService", (req, res) -> {
            return "Hello World! from the Hello Service";
        });
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4568;
    }
}
