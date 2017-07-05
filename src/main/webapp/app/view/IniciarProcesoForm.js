Ext.define('girado.view.IniciarProcesoForm',{
	extend:'Ext.form.Panel',
	xtype: 'IniciarProcesoForm',
	title:'Iniciar Procesos',
	bodyPadding: 5,
	defaultType: 'numberfield',
	url: '/girado/StartProcess',
	items:[
		{
			fieldLabel: 'Numero Expediente',
	        name: 'numero'
		},
		{
			fieldLabel: 'Monto Inicial',
	        name: 'monto'
		}
	],
	buttons: [
		{
			text: 'Iniciar Proceso',
			action: 'init'
		}
	],
	renderTo: Ext.getBody()
});
	
