$(document).ready(function () {
    $("#btnSave").click(function () {
        let mode = $("#mode").val();
        let overtimeSerialize = $("#overtimeForm").serializeArray()
        let overtimeForm = {};
        overtimeSerialize.map(function (data) {
            overtimeForm[data.name] = data.value
        })
        $.ajax({
            url: mode === "0" ? "/overtime/save" : "/overtime/edit",
            type: mode === "0" ? "POST" : "PUT",
            contentType: "application/json",
            data: JSON.stringify(overtimeForm),
            success: function (response) {
                $.toast(response.message)
                let  origin = window.origin;
                window.location.href = `${origin}/overtime`
            },
            error: function (xhr, status, error) {
                console.error("Error: " + status + " " + error.getMessage());
            }
        });
    })
})
