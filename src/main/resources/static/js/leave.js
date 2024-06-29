$(document).ready(function () {
    $("#btnSaveLeave").click(function () {
        let mode = $("#mode").val();
        let leaveSerialize = $("#leaveForm").serializeArray()
        let leaveForm = {};
        leaveSerialize.map(function (data) {
            leaveForm[data.name] = data.value
        })
        $.ajax({
            url: mode == "0" ? "/leave/save" : "/leave/edit",
            type: mode == "0" ? "POST" : "PUT",
            contentType: "application/json",
            data: JSON.stringify(leaveForm),
            success: function (response) {
                let  origin = window.origin;
                window.location.href = `${origin}/leave`
            },
            error: function (xhr, status, error) {
                console.error("Error: " + status );
            }
        });
    })
})
