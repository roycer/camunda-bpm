package com.sig.girado;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.camunda.bpm.application.PostDeploy;
import org.camunda.bpm.application.ProcessApplication;
import org.camunda.bpm.application.impl.ServletProcessApplication;
import org.camunda.bpm.engine.CaseService;
import org.camunda.bpm.engine.DecisionService;
import org.camunda.bpm.engine.ExternalTaskService;
import org.camunda.bpm.engine.FilterService;
import org.camunda.bpm.engine.FormService;
import org.camunda.bpm.engine.HistoryService;
import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.ManagementService;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;

@ProcessApplication
public class MyProcessApplication extends ServletProcessApplication {

	private static Logger LOGGER = Logger.getLogger(MyProcessApplication.class.getName());

	@PostDeploy
	public void onDeploymentFinished(ProcessEngine processEngine) {

		LOGGER.log(Level.INFO, "\nGirado: " + processEngine.getName());

		RepositoryService repositoryService = processEngine.getRepositoryService();
		RuntimeService runtimeService = processEngine.getRuntimeService();
		TaskService taskService = processEngine.getTaskService();
		IdentityService identityService = processEngine.getIdentityService();
		FormService formService = processEngine.getFormService();
		HistoryService historyService = processEngine.getHistoryService();
		ManagementService managementService = processEngine.getManagementService();
		FilterService filterService = processEngine.getFilterService();
		ExternalTaskService externalTaskService = processEngine.getExternalTaskService();
		CaseService caseService = processEngine.getCaseService();
		DecisionService decisionService = processEngine.getDecisionService();

		LOGGER.log(Level.INFO, repositoryService.toString());
		LOGGER.log(Level.INFO, repositoryService.toString());
		LOGGER.log(Level.INFO, runtimeService.toString());
		LOGGER.log(Level.INFO, taskService.toString());
		LOGGER.log(Level.INFO, identityService.toString());
		LOGGER.log(Level.INFO, formService.toString());
		LOGGER.log(Level.INFO, historyService.toString());
		LOGGER.log(Level.INFO, managementService.toString());
		LOGGER.log(Level.INFO, filterService.toString());
		LOGGER.log(Level.INFO, externalTaskService.toString());
		LOGGER.log(Level.INFO, caseService.toString());
		LOGGER.log(Level.INFO, decisionService.toString());

	}
	}