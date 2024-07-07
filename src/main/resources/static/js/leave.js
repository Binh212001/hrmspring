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

    $("#leaveData tr").each(function () {
        let id = $(this).attr('data-id');
        $(this).find("td").each(function () {
            $(this).click(function () {
                let {origin} = window
                window.location.href = `${origin}/leave/create-edit?mode=2&id=${id}`
            });
        })
    })

    $("#btnShowEditLeave").click(function () {
        let id = $("#leaveId").val();
        let {origin} = window
        window.location.href = `${origin}/overtime/create-edit?mode=1&id=${id}`
    })
})
