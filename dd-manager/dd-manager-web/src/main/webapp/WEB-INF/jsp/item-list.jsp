<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<table id="dg"></table>
<script>

    var toolbar=[{
        iconCls: 'icon-add',
        text:'新增',
        handler: function(){alert('新增按钮')}
    },{
        iconCls: 'icon-remove',
        text:'删除',
        handler: function(){
            var selections = $('#dg').datagrid('getSelections');
            if(selections.length==0){
                $.messager.alert('提示','请至少选中一条');
                return;
            }
            $.messager.confirm('确认','您确定要删除吗？',function(r){
               if(r){
                   var ids = [];
                   for(var i=0;i<selections.length;i++){
                       ids.push(selections[i].id);
                   }
                   $.post(
                       'items/batch',
                       {'ids[]':ids},
                       function(data){
                           $('#dg').datagrid('reload');
                       },
                       'json'
                   );
               }
            });
        }
    },{
        iconCls: 'icon-edit',
        text:'编辑',
        handler: function(){alert('编辑按钮')}
    },{
        iconCls: 'icon-up',
        text:'上架',
        handler: function(){
            var selections = $('#dg').datagrid('getSelections');
            if(selections.length==0){
                $.messager.alert('提示','请至少选中一条');
                return;
            }
            $.messager.confirm('确认','您确定要上架吗？',function(r){
                if(r){
                    var ids = [];
                    for(var i=0;i<selections.length;i++){
                        ids.push(selections[i].id);
                    }
                    $.post(
                        'items/up',
                        {'ids[]':ids},
                        function(data){
                            $('#dg').datagrid('reload');
                        },
                        'json'
                    );
                }
            });
        }
    },{
        iconCls: 'icon-down',
        text:'下架',
        handler: function(){
            var selections = $('#dg').datagrid('getSelections');
            if(selections.length==0){
                $.messager.alert('提示','请至少选中一条');
                return;
            }
            $.messager.confirm('确认','您确定要下架吗？',function(r){
                if(r){
                    var ids = [];
                    for(var i=0;i<selections.length;i++){
                        ids.push(selections[i].id);
                    }
                    $.post(
                        'items/down',
                        {'ids[]':ids},
                        function(data){
                            $('#dg').datagrid('reload');
                        },
                        'json'
                    );
                }
            });
        }
    }]


    $('#dg').datagrid({
        //允许多列排序
        multiSort:true,
        //将工具栏添加到数据表格中
        toolbar: toolbar,
        //请求远程服务器上的URL http://localhost:8080/ddshop/items
        url: 'items',
        //隔行变色，斑马线效果
        striped: true,
        //添加分页工具栏
        pagination: true,
        //每行的前面显示行号
        rownumbers: true,
        //使得数据表格自适应填充父容器
        fit: true,
        //默认显示10条，这样的话就显示20条
        pageSize: 20,
        //分页列表
        pageList: [20,50,100],
        //列属性
        columns: [[
            //field title width列属性
            {field: 'ck', checkbox: true},
            {field: 'id', title: '商品编号', width: 100, sortable:true},
            {field: 'title', title: '商品名称', width: 100, sortable:true},
            {field: 'sellPoint', title: '卖点', width: 100},
            {field: 'status', title: '状态', width: 100, formatter:function(value,row,index){
               switch(value){
                   case 1: return '正常'; break;
                   case 2: return '下架'; break;
                   case 3: return '删除'; break;
                   default: return '未知'; break;
               }
            }},
            {field: 'catName', title: '分类名称', width: 100},
            {field: 'priceView', title: '价格', width: 100},
            {field: 'created', title: '创建时间', width: 100, formatter:function(value,row,index){
                return moment(value).format('LL');
            }},
            {field: 'updated', title: '修改时间', width: 100, formatter:function(value,row,index){
                return moment(value).format('LL');
            }}
        ]]
    });




</script>

