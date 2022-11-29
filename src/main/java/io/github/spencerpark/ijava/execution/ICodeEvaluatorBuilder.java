package io.github.spencerpark.ijava.execution;

import java.io.InputStream;
import java.io.PrintStream;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.TimeUnit;

public interface ICodeEvaluatorBuilder {
    CodeEvaluatorBuilder addClasspathFromString(String classpath);
    CodeEvaluatorBuilder timeoutFromString(String timeoutUnit);
    CodeEvaluatorBuilder compilerOptsFromString(String opts);
    CodeEvaluatorBuilder stdout(PrintStream out);
    CodeEvaluatorBuilder stderr(PrintStream err);
    CodeEvaluatorBuilder stdin(InputStream in);
    CodeEvaluatorBuilder sysStdout();
    CodeEvaluatorBuilder sysStderr();
    CodeEvaluatorBuilder sysStdin();
    CodeEvaluatorBuilder startupScript(String script);
    CodeEvaluatorBuilder startupScript(InputStream scriptStream);
    CodeEvaluatorBuilder startupScriptFiles(String paths);
    CodeEvaluatorBuilder startupScriptFile(Path path);
    CodeEvaluator build();
}
