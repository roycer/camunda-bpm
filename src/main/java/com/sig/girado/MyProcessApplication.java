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

		LOGGER.log(Level.INFO, "\n\n\tGirado:[" + processEngine.getName()+"]\n");

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

		LOGGER.log(Level.INFO, "\n\n\t*[Proccess Engine API]\n"+
				"\n\t"+repositoryService.toString()+
				"\n\t"+repositoryService.toString()+
				"\n\t"+runtimeService.toString()+
				"\n\t"+taskService.toString()+
				"\n\t"+identityService.toString()+
				"\n\t"+formService.toString()+
				"\n\t"+historyService.toString()+
				"\n\t"+managementService.toString()+
				"\n\t"+filterService.toString()+
				"\n\t"+externalTaskService.toString()+
				"\n\t"+caseService.toString()+
				"\n\t"+decisionService.toString()+"\n");

	}
}