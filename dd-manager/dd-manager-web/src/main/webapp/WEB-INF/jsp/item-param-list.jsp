<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<div id="toolbar">
    <div>
        <button onclick="addParam()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</button>
        <button onclick="editParam()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</button>
        <button onclick="removeParam()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</button>

    </div>
</div>
<table id="dgParamList"></table>
<script>

    $('#dgParamList').datagrid({
        title:'商品规格模板列表',
        url:'itemParams',
        pagination: true,
        rownumbers: true,
        fit: true,
        pageSize: 20,
        toolbar: '#toolbar',
        columns: [[
            {field: 'ck', checkbox: true},
            {field: 'id', title: 'ID', sortable:true},
            {field: 'itemCatName', title: '商品类目'},
            {field: 'paramData', title: '规格（只显示分组名称）', formatter:function(value,row,index){
                console.log(value);
                return value;
            }},
            {field: 'created', title: '创建时间', formatter:function(value,row,index){
                return moment(value).format('YYYY年MM月DD日,hh:mm:ss');
            }},
            {field: 'updated', title: '修改时间', formatter:function(value,row,index){
                return moment(value).format('YYYY年MM月DD日,hh:mm:ss');
            }}
        ]]
    });

    function add(){
        ddshop.addTabs("新增商品","item-add");
    }

    function remove(){
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

    function edit(){}


</script>
