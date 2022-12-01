package io.github.spencerpark.ijava;

import io.github.spencerpark.ijava.execution.CompilationException;
import io.github.spencerpark.ijava.execution.EvaluationInterruptedException;
import io.github.spencerpark.ijava.execution.EvaluationTimeoutException;
import io.github.spencerpark.ijava.execution.IncompleteSourceException;
import io.github.spencerpark.jupyter.kernel.BaseKernel;
import jdk.jshell.EvalException;
import jdk.jshell.UnresolvedReferenceException;

import java.util.LinkedList;
import java.util.List;

public abstract class KernelExceptionFlow extends BaseKernel {

    public final List<String> formatError(Exception e) {
        List<String> fmt = new LinkedList<>();
        if (e instanceof CompilationException) {
            return formatCompilationException((CompilationException) e);
        } else if (e instanceof IncompleteSourceException) {
            return formatIncompleteSourceException((IncompleteSourceException) e);
        } else if (e instanceof EvalException) {
            return formatEvalException((EvalException) e);
        } else if (e instanceof UnresolvedReferenceException) {
            return formatUnresolvedReferenceException(((UnresolvedReferenceException) e));
        } else if (e instanceof EvaluationTimeoutException) {
            return formatEvaluationTimeoutException((EvaluationTimeoutException) e);
        } else if (e instanceof EvaluationInterruptedException) {
            return formatEvaluationInterruptedException((EvaluationInterruptedException) e);
        } else {
            fmt.addAll(super.formatError(e));
        }
        fmt.add("\n 오류 생성자 - 소요 팀프로젝트!!");
        return fmt;
    }
    abstract public List<String> formatCompilationException(CompilationException e);
    abstract public List<String> formatIncompleteSourceException(IncompleteSourceException e);
    abstract public List<String> formatEvalException(EvalException e);
    abstract public List<String> formatUnresolvedReferenceException(UnresolvedReferenceException e);
    abstract public List<String> formatEvaluationTimeoutException(EvaluationTimeoutException e);
    abstract public List<String> formatEvaluationInterruptedException(EvaluationInterruptedException e);
}
