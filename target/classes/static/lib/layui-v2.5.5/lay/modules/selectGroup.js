var loadData = [],
    elem= elem, // 选择器
    ajaxUrl = null, //数据请求地址
    type = null, //请求方式
    dataType = null, //数据类型
    data = null, //传递到服务端的数据
    placeholder='请选择', //占位符
    checkNodeId = null; //选中的组织ID

layui.define(['jquery', 'form', 'tree', 'layer', 'util'], function(exports) {
    var form = layui.form,
        $ = layui.jquery,
        tree = layui.tree,
        util = layui.util,
        index = 100;
    var obj = {
        ajax: function({
                           elem: elem,
                           url: ajaxUrl,
                           type: type,
                           dataType: dataType,
                           data: data,
                           placeholder:placeholder,
                           checkNodeId: checkNodeId
                       }) {

            //请求数据 创建组织树

            $('#' + elem).css('display', 'none');
            var dlHtml = '';
            dlHtml +=
                '<div class="layui-form-select selectGroupTree"><input id="" type="text" placeholder="'+placeholder+'" value="" readonly="readonly" class="layui-input layui-unselect "><i class="layui-edge"></i><dl  class="layui-anim layui-anim-upbit layui-group-dl"><dd><div id="'+elem+'_1'+'"></div></dd></dl></div>';
            $('#' + elem).parent('.layui-input-block').append(dlHtml);
            //请求数据
            $.ajax({
                url: ajaxUrl,
                type: type,
                dataType: dataType,
                data: data,
                success: function(data1) {
                    loadData = data1;
                    tree.render({
                        elem: '#'+elem+'_1',
                        data: loadData,
                        onlyIconControl: true,
                        click: function(node) {
                            var data = node.data; //获取当前点击的节点数据
                            $('#' + elem).parent().find('input').val(data.title);
                            $('#' + elem).val(data.id);
                        },
                        oncheck: function(obj) {
                            console.log(obj);
                        },
                    });

                }
            });

            setTimeout(function() {
                function parseJson(jsonObj, id) {
                    for (var v in jsonObj) {
                        var element = jsonObj[v]
                        if (typeof(element) == 'object') {
                            parseJson(element, id)
                        } else {
                            if (element == id) {
                                $('#' + elem).parent().find('input').val(jsonObj.title);
                                $('#' + elem).val(jsonObj.id);
                            }
                        }
                    }
                }
                parseJson(loadData, checkNodeId);
            }, 100)



            //点击弹出
            $('#' + elem).parent().find(".selectGroupTree").on("click", function(e) {
                var _this = $(this);
                _this.toggleClass("layui-form-selected");
                layui.stope(e);
            }).on("click", "dl i", function(e) {
                layui.stope(e);
            });
            $(document).on("click", function(e) {
                $(".layui-form-select").removeClass("layui-form-selected");
            });
        }
    };


    //输出
    exports('selectGroupTree', obj);
});
