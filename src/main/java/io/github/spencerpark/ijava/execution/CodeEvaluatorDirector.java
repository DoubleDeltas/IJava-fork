package io.github.spencerpark.ijava.execution;

import io.github.spencerpark.ijava.IJava;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public abstract class CodeEvaluatorDirector {
    private ICodeEvaluatorBuilder builder;

    public CodeEvaluatorDirector(ICodeEvaluatorBuilder builder) {
        this.builder = builder;
    }

    public CodeEvaluator construct() {
        try {
            return builder
                    .addClasspathFromString(System.getenv(IJava.CLASSPATH_KEY))
                    .compilerOptsFromString(System.getenv(IJava.COMPILER_OPTS_KEY))
                    .startupScript(new String(
                            IJava.resource(IJava.DEFAULT_SHELL_INIT_RESOURCE_PATH).readAllBytes(),
                            StandardCharsets.UTF_8)
                    )
                    .startupScriptFiles(System.getenv(IJava.STARTUP_SCRIPTS_KEY))
                    .startupScript(System.getenv(IJava.STARTUP_SCRIPT_KEY))
                    .timeoutFromString(System.getenv(IJava.TIMEOUT_DURATION_KEY))
                    .stdout(null)
                    .stdout(null)
                    .stdin(null)
                    .build();
        }
        catch (IOException ex) {
            return null;
        }
    }
}
