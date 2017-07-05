package com.sig.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.spin.plugin.variable.SpinValues;
import org.camunda.spin.plugin.variable.value.JsonValue;

/**
 * Servlet implementation class StartProcess
 */
public class StartProcess extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static Logger LOGGER = Logger.getLogger(StartProcess.class.getName());
	Properties propiedades = new Properties();
	
    public StartProcess() {
        super();
        try {
        	propiedades.load(getClass().getResourceAsStream("/camunda.properties"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idBPMN = propiedades.getProperty("idBPMN");
		String numero = request.getParameter("numero");
		String monto = request.getParameter("monto");
		
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		Map<String, Object> variables = new HashMap<String, Object>();
		
		if(numero==null) numero = "1";
		if(monto==null) monto="500";
		
	    String json = "{\"numero\":"+numero+",\"monto\":"+monto+"}";
	    JsonValue jsonValue = SpinValues.jsonValue(json).create();
	    
	    variables.put("expediente", jsonValue);
		String idProcessInstance = processEngine.getRuntimeService().startProcessInstanceByKey(idBPMN,variables).getProcessInstanceId();
		LOGGER.log(Level.INFO,"idBPMN:"+idBPMN+"\n\tidProcessInstance: "+idProcessInstance+"\n\tmonto:"+monto+"\n\tnumero: "+numero+"\n");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
