$(document).ready(function () {
    $("#btnSaveAttendance").click(function () {
        let mode = $("#mode").val();
        let leaveSerialize = $("#shiftForm").serializeArray()
        let leaveForm = {};
        leaveSerialize.map(function (data) {
            leaveForm[data.name] = data.value
        })
        let leaveFormUpdate = []
        leaveFormUpdate.push(leaveForm)
        $.ajax({
            url: mode == "0" ? "/work-shift/save" : "/work-shift/edit",
            type: mode == "0" ? "POST" : "PUT",
            contentType: "application/json",
            data: JSON.stringify(mode=="0" ? leaveForm : leaveFormUpdate),
            success: function (response) {
                let  origin = window.origin;
                window.location.href = `${origin}/work-shift`
            },
            error: function (xhr, status, error) {
                console.error("Error: " + status );
            }
        });
    })
})
