package io.github.spencerpark.ijava.execution;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

public interface ICodeEvaluatorBuilder {
    CodeEvaluatorBuilder addClasspathFromString(String classpath);
    CodeEvaluatorBuilder timeout(long timeout, TimeUnit timeoutUnit);
    CodeEvaluatorBuilder compilerOpts(List<String> opts);
    CodeEvaluatorBuilder stdout(PrintStream out);
    CodeEvaluatorBuilder stderr(PrintStream err);
    CodeEvaluatorBuilder stdin(InputStream in);
    CodeEvaluatorBuilder startupScript(String script);
    CodeEvaluator build();
}
