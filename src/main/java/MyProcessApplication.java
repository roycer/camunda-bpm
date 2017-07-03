
import org.camunda.bpm.application.PostDeploy;
import org.camunda.bpm.application.ProcessApplication;
import org.camunda.bpm.application.impl.EmbeddedProcessApplication;
import org.camunda.bpm.application.impl.ServletProcessApplication;
import org.camunda.bpm.engine.ProcessEngine;

@ProcessApplication
	public class MyProcessApplication extends ServletProcessApplication {

	  @PostDeploy
	  public void onDeploymentFinished(ProcessEngine processEngine) {

	    System.out.println("hola mundo desde CamundaBPMProcessApplication");
	  }
	}