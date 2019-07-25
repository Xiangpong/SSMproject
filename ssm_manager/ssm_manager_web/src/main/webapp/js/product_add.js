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

    initPictureUpload:function(){
        $('#fileName').filebox({
           prompt:"选择图片",
           width:"300",
           buttonText:"请选择"
        });

        $('.uploadPIC').click(function () {
            $.ajaxFileUpload({
                url:'/uploadfile',
                fileElementId:'filebox_file_id_1',
                type:'post',
                
                success:function (data) {
                    console.log($(data).find("body").text());
                    $('#productIMG').attr("src","http://192.168.46.128:8888/"+$(data).find("body").text());
                }
            
            })
        });
    },

    // 初始化方法
    init:function (data) {

        // 实例化编辑器
        // 建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
        var ue = UE.getEditor('editor')

        //初始化商品分类
        this.initProductCategories();

        // 初始化上传图片
        this.initPictureUpload();

    }


}

