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
            data: JSON.stringify(mode == "0" ? leaveForm : leaveFormUpdate),
            success: function (response) {
                let origin = window.origin;
                window.location.href = `${origin}/work-shift`
            },
            error: function (xhr, status, error) {
                console.error("Error: " + status);
            }
        });
    })


    $("#checkAll").change(function () {
        const checkedAll = $("#checkAll").prop("checked");
        if (checkedAll) {
            $('input[name="attendanceId"]').each(function () {
                $("#btnApproved").addClass("show")
                $("#btnApproved").removeClass("hidden")
                $(this).prop("checked", true)
            });
        } else {
            $('input[name="attendanceId"]').each(function () {
                $("#btnApproved").addClass("hidden")
                $("#btnApproved").removeClass("show")
                $(this).prop("checked", false)
            });
        }
    })

    $("#btnApproved").click(function () {
        let attendance = []
        $('input[name="attendanceId"]').each(function () {
            if ($(this).prop("checked")) {
                attendance.push($(this).val())
            }
        });
        approved(attendance)
    })

    function approved(attendance) {
        $.ajax({
            url: "/work-shift/approved",
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(attendance),
            success: function (response) {

                $("#message").text(response.message);
                $("#btnApproved").addClass("hidden")
                $("#btnApproved").removeClass("show")
            },
            error: function (xhr, status, error) {
                $("#messageFail").text("Working Shift is approved successfully.");
                $("#btnApproved").addClass("hidden")
                $("#btnApproved").removeClass("show")
            }
        });
    }


    $('input[name="attendanceId"]').each(function () {
        $(this).change(function () {
            if ($('input[name="attendanceId"]:checked').length > 0) {
                $("#btnApproved").addClass("show")
                $("#btnApproved").removeClass("hidden")
            } else {
                $("#btnApproved").addClass("hidden")
                $("#btnApproved").removeClass("show")
            }
        })
    })
})
