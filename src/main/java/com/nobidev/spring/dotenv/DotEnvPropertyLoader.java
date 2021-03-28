package com.nobidev.spring.dotenv;

import com.nobidev.dotenv.DotEnv;

public class DotEnvPropertyLoader {
    private final DotEnv dotenv;

    public DotEnvPropertyLoader() {
        dotenv = DotEnv.configure().ignoreIfMissing().load();
    }

    public Object getValue(String key) {
        return dotenv.get(key);
    }
}
