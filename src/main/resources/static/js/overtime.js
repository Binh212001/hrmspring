$(document).ready(function () {
    $("#btnSaveOvertime").click(function () {
        let mode = $("#mode").val();
        let overtimeSerialize = $("#overtimeForm").serializeArray()
        let overtimeForm = {};
        overtimeSerialize.map(function (data) {
            overtimeForm[data.name] = data.value
        })
        $.ajax({
            url: mode == "0" ? "/overtime/save" : "/overtime/edit",
            type: mode == "0" ? "POST" : "PUT",
            contentType: "application/json",
            data: JSON.stringify(overtimeForm),
            success: function (response) {
                alert(response.message)
                let  origin = window.origin;
                window.location.href = `${origin}/overtime`
            },
            error: function (xhr, status, error) {
                console.error("Error: " + status );
            }
        });
    })

    $("#overtimeData tr").each(function () {
        let id = $(this).attr('data-id');
        $(this).find("td").each(function () {
            $(this).click(function () {
                let {origin} = window
                window.location.href = `${origin}/overtime/create-edit?mode=2&id=${id}`
            });
        })
    })

    $("#btnShowEditOt").click(function () {
        let id = $("#overtimeId").val();
        let {origin} = window
        window.location.href = `${origin}/overtime/create-edit?mode=1&id=${id}`
    })
})
