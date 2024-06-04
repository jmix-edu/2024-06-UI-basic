package com.company.jmixpmflowbase.view.project;

import com.company.jmixpmflowbase.entity.Project;

import com.company.jmixpmflowbase.view.main.MainView;

import com.company.jmixpmflowbase.view.projecttaskslist.ProjectTasksListView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.DialogWindows;
import io.jmix.flowui.component.grid.DataGrid;
import io.jmix.flowui.kit.action.ActionPerformedEvent;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "projects", layout = MainView.class)
@ViewController("Project.list")
@ViewDescriptor("project-list-view.xml")
@LookupComponent("projectsDataGrid")
@DialogMode(width = "64em")
public class ProjectListView extends StandardListView<Project> {


    @Autowired
    private DialogWindows dialogWindows;
    @ViewComponent
    private DataGrid<Project> projectsDataGrid;

    @Subscribe("projectsDataGrid.showTasksDialog")
    public void onProjectsDataGridShowTasksDialog(final ActionPerformedEvent event) {
        DialogWindow<ProjectTasksListView> window = dialogWindows.view(this, ProjectTasksListView.class)
                .build();

        window.getView().setProjectId(projectsDataGrid.getSingleSelectedItem());
        window.setWidth("800px");
        window.setHeight("600px");
        window.setResizable(true);

        window.open();
    }
}