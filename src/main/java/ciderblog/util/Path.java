package app.util;

import lombok.*;

public class Path {

    // The @Getter methods are needed in order to access
    // the variables from Velocity Templates
    public static class Web {
        @Getter public static final String INDEX = "/index/";
    }

    public static class Template {
        public final static String INDEX = "/velocity/index/index.vm";
    }

}
