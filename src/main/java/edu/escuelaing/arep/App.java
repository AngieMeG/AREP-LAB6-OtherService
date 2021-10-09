package edu.escuelaing.arep;

import static spark.Spark.*;

/**
 * Sever class that displays a Hello Message
 * @author Angie Medina
 * @version 1.0
 *
 */
public class App {
    /**
     * Main method of the hello service
     * @param args, args needed by the service
     */
    public static void main( String[] args ){
        port(getPort());
        staticFileLocation("/public");
        secure("keystores/ecikeystore.p12", "123456", "keystores/myTrustStore", "123456");
        get("/helloService", (req, res) -> {
            return "Hello World! from the Hello Service";
        });
    }

    /**
     * This method reads the default port as specified by the PORT variable in
     * the environment.
     *
     * Heroku provides the port automatically so you need this to run the
     * project on Heroku.
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4568;
    }
}
