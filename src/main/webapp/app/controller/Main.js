Ext.define('girado.controller.Main', {
    extend: 'Ext.app.Controller',
    init: function(application){
    	this.control({
    		'IniciarProcesoForm button[action=init]':{
    			 click: this.iniciarProceso
    		}
    	});
    },
    iniciarProceso: function(button){
    	var form = button.up('form').getForm();
    	
    	if(form.isValid()){
    		form.submit({
    			success: function(form,action){
    				Ext.Msg.alert('Success','Cargo Proceso');
    			},
    			failure: function(form,action){
    				Ext.Msg.alert('Failed','No se pudo Cargar Proceso');
    			}
    		});
    	}
 
    }
});
