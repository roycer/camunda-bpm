package com.sig.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.impl.util.json.JSONObject;
import org.camunda.spin.json.SpinJsonNode;
import org.camunda.spin.plugin.variable.value.JsonValue;

public class Delegate_EnviarDatosMEF implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execution) throws Exception {

		JsonValue expediente = execution.getVariableTyped("expediente");
		System.out.println(expediente);
		execution.setVariable("expediente", expediente);
		
	}

}
