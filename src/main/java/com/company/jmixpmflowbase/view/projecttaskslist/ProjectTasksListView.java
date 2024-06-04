package com.company.jmixpmflowbase.view.projecttaskslist;


import com.company.jmixpmflowbase.entity.Project;
import com.company.jmixpmflowbase.entity.Task;
import com.company.jmixpmflowbase.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.model.CollectionLoader;
import io.jmix.flowui.view.StandardView;
import io.jmix.flowui.view.ViewComponent;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;
import org.springframework.lang.Nullable;


@Route(value = "project-tasks-list-view", layout = MainView.class)
@ViewController("ProjectTasksListView")
@ViewDescriptor("project-tasks-list-view.xml")
public class ProjectTasksListView extends StandardView {

    @ViewComponent
    private CollectionLoader<Task> tasksDl;

    public void setProjectId (@Nullable Project project) {
        if (project != null) {
            tasksDl.setParameter("id", project.getId());
        } else {
            tasksDl.removeParameter("id");
        }

        tasksDl.load();
    }
}