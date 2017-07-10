package com.sig.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.spin.plugin.variable.value.JsonValue;

/**
 * Servlet implementation class GetProcess
 */
public class GetProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetProcess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		List <ProcessInstance> instances = processEngine.getRuntimeService().createProcessInstanceQuery().processDefinitionKey("pGiradoPagado").list();
		List<org.camunda.bpm.engine.task.Task> tasks = processEngine.getTaskService().createTaskQuery().list();
		//error -> processEngine.getRuntimeService().getVariablesTyped("expediente");
		
		PrintWriter pw = response.getWriter();
		
		pw.append("Served at: ").append(request.getContextPath()+"\n");
		
		pw.append("\n[process Instance]\n\n");
		
		for(ProcessInstance i : instances ){
			pw.append("\tidProccessInstance: "+i.getId()+"\n");
		}
		
		pw.append("\n[tasks]\n");
		for(org.camunda.bpm.engine.task.Task i : tasks){
			
			pw.append(
					"\n\tidProccessInstance:"+i.getProcessInstanceId() + 
					"\n\tidParentTask:" + i.getParentTaskId() + 
					"\n\tidTask: "+i.getId() +
					"\n\tname:"+i.getName() +
					"\n\tassignee:"+i.getAssignee() +
					"\n");
		}
		
		pw.append("\n[variable]\n\n");
		
		//processEngine.getTaskService().complete("99edb6af-6347-11e7-8890-0c84dcaa2fad");
		//processEngine.getTaskService().deleteTask("6afdc13d-6339-11e7-849a-0c84dcaa2fad");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
