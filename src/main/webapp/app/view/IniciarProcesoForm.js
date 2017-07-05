Ext.define('girado.view.IniciarProcesoForm',{
	extend:'Ext.form.Panel',
	xtype: 'IniciarProcesoForm',
	title:'Iniciar Proceso',
	bodyPadding: 5,
	defaultType: 'numberfield',
	url: '/girado/StartProcess',
	method: 'GET',
	items:[
		{
			fieldLabel: 'Numero Expediente',
	        name: 'numero',
	        value:1,
	        minValue: 0,
	        allowBlank: false
		},
		{
			fieldLabel: 'Monto Inicial',
	        name: 'monto',
	        value:500,
	        minValue: 0,
	        allowBlank: false
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
	
