$(function () {
            $("#log_table").datagrid({
                height:'390',
                //width: '870',
               // nowrap: true,
                //striped: true,
                url: 'logsJson.action',
                columns: [[{
                    field: 'src.id',
                    title: '源账户',
                    width: fixWidth(0.2),
                    //sortable:true,
                    formatter: function (value, row) {
                    	//alert("row.src.id"+row.src.id);
                        return row.src.id ;
                    }
                }, {
                    field: 'des.id',
                    title: '目的账户',
                    width: fixWidth(0.2),
                    formatter: function (value, row) {
                        return row.des.id;
                    }
                }, {
                    field: 'money',
                    title: '金额',
                    width: fixWidth(0.2)
                }, {
                    field: 'date',
                    title: '时间',
                    width: fixWidth(0.3)
                },{
                    field: 'type',
                    title: '操作',
                    width: fixWidth(0.1)
                }]],
                pagination: true,
                rownumbers: true
            });
        });

function fixWidth(percent)  
{  
    return document.body.clientWidth * percent ; //这里你可以自己做调整  
} 