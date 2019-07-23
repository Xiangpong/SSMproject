// 定义变量
var pa = productAdd = {

    initProductCategories:function(){
        function loadSubCategory(value){
            var $sonBox = $("#productAddForm").find('#sonBox');

            if (value == 0){
                return;
            }else {
                $.getJSON('product_category/list',{id:value},function (data) {
                    var Str =  '';
                    Str = '<select id="productCateSelectId2" class="easyui-combobox" name="productCatSelect2" style="width:200px;">';
                    Str += '<option value="0">请选择</option>';

                    $.each(data,function (idx,item) {
                        Str += '<option value="'+item.id+'">'+item.text+'</option>';
                    })

                    Str += '</select>';
                    $sonBox.html(Str).show()
                })
            }
        }

        // 监听onChange
        $("#productAddForm").find("select[name='productCatSelect']").combobox({
          onChange:function () {
              var value = $("#productCateSelectId").val();
              loadSubCategory(value);
          }
        });
    },

    // 初始化方法
    init:function (data) {
        //初始化商品分类
        this.initProductCategories();
    }


}

