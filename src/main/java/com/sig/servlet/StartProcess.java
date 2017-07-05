package com.sig.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.engine.variable.value.ObjectValue;
import org.camunda.spin.json.SpinJsonNode;
import org.camunda.spin.plugin.variable.SpinValues;
import org.camunda.spin.plugin.variable.value.JsonValue;

import static org.camunda.spin.Spin.*;
import static org.camunda.spin.DataFormats.*;

/**
 * Servlet implementation class StartProcess
 */
public class StartProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	Properties propiedades = new Properties();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StartProcess() {
        super();
        try {
        	propiedades.load(getClass().getResourceAsStream("/camunda.properties"));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idBPMN = propiedades.getProperty("idBPMN");
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		
		String numero = request.getParameter("numero");
		String monto = request.getParameter("monto");
		
		if(numero!=null) numero = "1";
		if(monto==null) monto="500";
		
		response.getWriter().append("Start Process with Id: ").append(idBPMN);
	    Map<String, Object> variables = new HashMap<String, Object>();
	    
	    String json = "{\"numero\":"+numero+",\"monto\":"+monto+"}";
	           
	    JsonValue jsonValue = SpinValues.jsonValue(json).create();
		
	    variables.put("expediente", jsonValue);
		processEngine.getRuntimeService().startProcessInstanceByKey(idBPMN,variables);
		
		System.out.println("monto:"+monto+"\tnumero: "+numero);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
