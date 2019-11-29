<%--
  Created by IntelliJ IDEA.
  User: DFG
  Date: 2019/11/28
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<script src="js/jquery-3.3.1.js"></script>
<script>
    $(function () {
        //省
        $.ajax({
            url: "/province",
            data: "",
            type: "get",
            dataType: "json",
            success: function (data) {
                var html = '';
                for (var i = 0; i < data.length; i++) {
                    html += '<option value="' + data[i].id + '">' + data[i].name + '</option>';
                }
                $("#province").append(html);
            }
        });


        //市
        $("#province").change(function () {
            $("#district").empty();
            $("#district").append('<option value="-1">请选择</option>');
            var id = $("#province option:selected").val();
            if (id == -1) {
                $("#city").empty();
                $("#city").append('<option value="-1">请选择</option>');
                return;
            }
            $.ajax({
                url: "/city",
                data: {id: id},
                type: "get",
                dataType: "json",
                success: function (data) {
                    $("#city").empty();
                    var html = '<option value="-1">请选择</option>';
                    for (var i = 0; i < data.length; i++) {
                        html += '<option value="' + data[i].id + '">' + data[i].name + '</option>';
                    }
                    $("#city").append(html);
                }
            });
        });


        //区
        $("#city").change(function () {
            var cityId = $("#city option:selected").val();
            if (cityId == -1) {
                $("#district").empty();
                $("#district").append('<option value="-1">请选择</option>');
                return;
            }
            $.ajax({
                url: "/district",
                data: {cityId: cityId},
                type: "get",
                dataType: "json",
                success: function (data) {
                    $("#district").empty();
                    var html = '<option value="-1">请选择</option>';
                    for (var i = 0; i < data.length; i++) {
                        html += '<option value="' + data[i].id + '">' + data[i].name + '</option>';
                    }
                    $("#district").append(html);
                }
            });
        });


    });
</script>
<body>
省：
<select id="province">
    <option value="-1">请选择</option>
</select>
市：
<select id="city">

    <option value="-1">请选择</option>
</select>
区：
<select id="district">
    <option value="-1">请选择</option>
</select>
</body>
</html>
