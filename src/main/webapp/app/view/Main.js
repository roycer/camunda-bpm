Ext.define('girado.view.Main', {
    extend: 'Ext.container.Container',
    requires:[
        'Ext.layout.container.Border'
    ],
    
    xtype: 'app-main',

    layout: {
        type: 'border'
    },

    items: [{
        xtype: 'IniciarProcesoForm',
    }]
});