

$('input[name="peopleId"]').change(function() {
    var date = $("#peopleId").val()
    // 根据身份证号查询信息做数据填充
        $.ajax({
            cache : true,
            type : "POST",
            url : "/blog/open/userSubscribe/getMessage?peopleId="+date,
            async : false,
            error : function(request) {
            },
            success : function(data) {
                console.log(data)
                if(data!=null&&data!=''){
                    layer.msg("查到历史信息");

                    $("#name").val(data.name)
                    $("#birthday").val(data.birthday)
                    $("#address").val(data.address)
                    $("#phone").val(data.phone)


                }
            }
        });

})

$().ready(function() {
    validateRule();
});

function initDate(date) {

    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#test1', //指定元素
            value: date[0],
            min:date[0],
            max:date[date.length-1],
            done: function(value, date){
                thirdChange()
            }
        });
    });

}

$().ready(function() {
    initSelect(subscribes)
});

function initSelect(p) {
    console.log("初始化联动")
    var option = "";
    var res = p;
    $.each(res, function (i, n) {//循环，i为下标从0开始，n为集合中对应的第i个对象
        option += "<option value=" + n.key + ">" + n.key + "</option>"
    });
    $("#first").html(option);//将循环拼接的字符串插入第二个下拉列表
    $("#first").show();//把第一个下拉列表展示
    firstChange()
}

//二级联动
function firstChange() {
    var aa = $("#first").val();//得到第一个下拉列表的值
    if (aa != null) {
        var option = "";
        var res = subscribes;
        if (res.length > 0) {
            $.each(res, function (i, n) {//循环，i为下标从0开始，n为集合中对应的第i个对象
                if (n.key==aa){
                    console.log("二级联动匹配成功")
                    $.each(n.value, function (i, n) {
                        option += "<option value=" + n.key + ">" + n.key + "</option>";
                    })
                    $("#second").html(option);//将循环拼接的字符串插入第二个下拉列表
                    $("#second").show();//把第二个下拉列表展示
                    firstMessage=n.value;
                    secondChange();

                }
            });
        } else {
            $("#second").hide();
            $("#second").val("");
        }
    }
}

//三级联动
function secondChange() {
    var aa = $("#second").val();//得到第一个下拉列表的值
    if (aa != null && aa != "") {
        if (aa != -1) {
            var option;
            var res = firstMessage;
            if (res.length > 0) {
                $.each(res, function (i, n) {//循环，i为下标从0开始，n为集合中对应的第i个对象
                    if (n.key==aa){
                        console.log("三级联动匹配成功")
                        var dateObj = new Array();;
                        $.each(n.value, function (i, n) {
                            dateObj.push(n.key)
                            // option += "<option value=" + n.key + ">" + n.key + "</option>";
                        })
                        // $("#third").html(option);//将循环拼接的字符串插入第二个下拉列表
                        $("#third").hide();//把第二个下拉列表展示
                        secondMessage=n.value;
                        initDate(dateObj)

                        thirdChange()
                    }
                });

            } else {
                $("#third").hide();
                $("#third").val("");
            }
        } else {
            $("#third").hide();
            $("#third").val("");
        }
    } else {
        $("#third").hide();
        $("#third").val("");
    }
}

//四级联动
function thirdChange() {
    var aa = $("#test1").val();//得到第一个下拉列表的值
    if (aa != null && aa != "") {
        if (aa != -1) {
            var option;
            var res = secondMessage;
            if (res.length > 0) {
                $.each(res, function (i, n) {//循环，i为下标从0开始，n为集合中对应的第i个对象
                    if (n.key==aa){
                        console.log("四级联动匹配成功")
                        $.each(n.value, function (i, n) {
                            option += "<option value=" + n.id + ">" + n.dictValue + "</option>";
                        })
                        $("#four").html(option);//将循环拼接的字符串插入第二个下拉列表
                        $("#four").show();//把第二个下拉列表展示
                    }
                });

            } else {
                $("#four").hide();
                $("#four").val("");
            }
        } else {
            $("#four").hide();
            $("#four").val("");
        }
    } else {
        $("#four").hide();
        $("#four").val("");
    }
}


function validateRule() {
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#signupForm").validate({
        rules : {
            name : {
                required : true
            }
        },
        messages : {
            name : {
                required : icon + "请输入姓名"
            }
        }
    })
}

$.validator.setDefaults({
    submitHandler : function() {
        save();
    }
});
function save() {
    $.ajax({
        cache : true,
        type : "POST",
        url : "/blog/open/userSubscribe/save",
        data : $('#signupForm').serialize(),// 你的formid
        async : false,
        error : function(request) {
            parent.layer.alert("Connection error");
        },
        success : function(data) {
            if (data.code == 0) {
                parent.layer.msg("预约成功");

            } else {
                parent.layer.alert(data.msg)
            }

        }
    });


}