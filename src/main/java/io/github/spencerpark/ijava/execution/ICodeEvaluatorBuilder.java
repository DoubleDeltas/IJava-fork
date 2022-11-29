package io.github.spencerpark.ijava.execution;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

public interface ICodeEvaluatorBuilder {
    CodeEvaluatorBuilder addClasspathFromString(String classpath);
    CodeEvaluatorBuilder timeoutFromString(String timeoutUnit);
    CodeEvaluatorBuilder compilerOpts(List<String> opts);
    CodeEvaluatorBuilder stdout(PrintStream out);
    CodeEvaluatorBuilder stderr(PrintStream err);
    CodeEvaluatorBuilder stdin(InputStream in);
    CodeEvaluatorBuilder startupScript(String script);
    CodeEvaluator build();
}

