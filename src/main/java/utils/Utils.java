package utils;

import io.github.cdimascio.dotenv.Dotenv;

public class Utils {
    public static Dotenv dotEnv(){
        return Dotenv.configure()
                .ignoreIfMalformed()
                .ignoreIfMissing()
                .load();
    }
}
