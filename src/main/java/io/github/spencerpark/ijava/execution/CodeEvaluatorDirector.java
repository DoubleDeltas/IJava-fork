package io.github.spencerpark.ijava.execution;

import io.github.spencerpark.ijava.IJava;

public class CodeEvaluatorDirector {
    private ICodeEvaluatorBuilder builder;

    public CodeEvaluatorDirector(ICodeEvaluatorBuilder builder) {
        this.builder = builder;
    }

    public void construct() {
        builder
                .addClasspathFromString(System.getenv(IJava.CLASSPATH_KEY))
                .compilerOptsFromString(System.getenv(IJava.COMPILER_OPTS_KEY))
                .startupScript(IJava.resource(IJava.DEFAULT_SHELL_INIT_RESOURCE_PATH))
                .startupScriptFiles(System.getenv(IJava.STARTUP_SCRIPTS_KEY))
                .startupScript(System.getenv(IJava.STARTUP_SCRIPT_KEY))
                .timeoutFromString(System.getenv(IJava.TIMEOUT_DURATION_KEY))
                .sysStdout()
                .sysStderr()
                .sysStdin()
                .build();
    }
}
