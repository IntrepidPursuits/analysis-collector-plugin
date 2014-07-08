package hudson.plugins.analysis.collector.handler;

import java.util.Collection;

import org.jvnet.localizer.Localizable;

import com.google.common.collect.Lists;

import hudson.plugins.analysis.collector.AnalysisDescriptor;
import hudson.plugins.analysis.core.AbstractProjectAction;
import hudson.plugins.analysis.core.BuildResult;
import hudson.plugins.analysis.core.PluginDescriptor;
import hudson.plugins.analysis.core.ResultAction;
import hudson.plugins.tasks.*;

/**
 * Handles access to the open tasks plug-in.
 *
 * @author Ulli Hafner
 */
public class TasksHandler implements AnalysisHandler {
    @Override
    public Class<? extends AbstractProjectAction<?>> getProjectActionType() {
        return TasksProjectAction.class;
    }

    @Override
    public String getUrl() {
        return AnalysisDescriptor.TASKS;
    }

    @Override
    public Localizable getDetailHeader() {
        return Messages._Tasks_ProjectAction_Name();
    }

    @Override
    public Class<? extends PluginDescriptor> getDescriptor() {
        return TasksDescriptor.class;
    }

    @Override
    public Collection<? extends Class<? extends ResultAction<? extends BuildResult>>> getResultActions() {
        return Lists.newArrayList(TasksResultAction.class, TasksMavenResultAction.class);
    }
}
